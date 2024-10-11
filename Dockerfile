FROM openjdk:22-jdk-slim
COPY ./application/target/preapprove-process-module*.jar preapprove-process-module.jar
RUN mkdir -p /opt/logs

ENV TZ=Asia/Tashkent 
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ /etc/timezone

ENTRYPOINT ["java","-jar","/preapprove-process-module"]

