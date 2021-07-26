FROM openjdk:11-jdk-slim

# time zone
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# update sources
RUN apt-get update

# install some packages
RUN apt-get install -y curl

# run under a user
RUN groupadd group_venzel
RUN useradd -G group_venzel venzel
USER venzel:group_venzel

# run app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]