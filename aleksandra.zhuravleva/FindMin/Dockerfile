
FROM ubuntu:latest

LABEL maintainer "Aleksandra Zhuravleva <guravleva.aleksandra@gmail.com>"

USER root

RUN apt-get update
RUN apt-get install -y openjdk-8-jre maven

COPY ./build/libs/FindMin-1.0-SNAPSHOT.jar FindMin-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "FindMin-1.0-SNAPSHOT.jar"]
CMD ["1 2 3 4 5 6 7 8 9 0"]

