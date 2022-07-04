FROM openjdk:11.0.15-jdk-slim-buster
USER root
COPY ./target/*.jar .
USER 1001
CMD ['java -jar','docker-jenkins-integration-sample']
