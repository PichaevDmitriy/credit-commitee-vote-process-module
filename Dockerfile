FROM openjdk:17-jdk-slim
COPY ./application/target/credit-commitee-vote-process-module*.jar credit-commitee-vote-process-module.jar
RUN mkdir -p /opt/logs

ENV TZ=Asia/Tashkent 
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ /etc/timezone

ENTRYPOINT ["java","-jar","/credit-commitee-vote-process-module.jar"]

