package uz.keysoft.processmodules.camundaprocessadapter.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.camunda.community.rest.client.api.DeploymentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Profile("!test")
@Configuration
public class TenantAwareCamundaAutoDeploymentConfiguration {
  @Autowired
  private DeploymentApi deploymentApi;
  @Value("classpath*:**/*.bpmn")
  private Resource[] bpmnSchemaResources;

  @Value("classpath*:**/*.form")
  private Resource[] bpmnFormResources;
  @Value("${camunda.bpm.client.tenantId}")
  private String tenantId;

  @PostConstruct
  public void deployCamundaResources() {
    final List<Resource> resourcesToDeploy = new ArrayList<>(Arrays.asList(this.bpmnSchemaResources));
    resourcesToDeploy.addAll(Arrays.asList(this.bpmnFormResources));

    resourcesToDeploy.forEach(resource -> log.info(String.format("Found camunda resource: %s", resource.getFilename())));

    resourcesToDeploy.stream()
      .filter(resource -> StringUtils.isNotBlank(resource.getFilename()))
      .filter(resource -> !Objects.requireNonNull(resource.getFilename()).contains("_source.bpmn"))
      .forEach(resource -> {
        File resourceTempFile = null;
        try {
          final InputStream inputStream = resource.getInputStream();
          resourceTempFile = new File(Objects.requireNonNull(resource.getFilename()));
          FileUtils.copyInputStreamToFile(inputStream, resourceTempFile);
          this.deploymentApi.createDeployment(
            tenantId,
            null,
            true,
            true,
            this.tenantId + "-" + resource.getFilename(),
            null,
            resourceTempFile);
        } catch (final Exception e) {
          log.error(e.getMessage(), e);
          throw new RuntimeException(e);
        } finally {
          if (resourceTempFile != null) {
            deleteFile(resourceTempFile);
          }
        }
      });
  }

  private File deleteFile(final File resourceTempFile) {
    try {
      return FileUtils.delete(resourceTempFile);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }
}
