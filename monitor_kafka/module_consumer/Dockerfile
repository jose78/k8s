FROM maven as builder
COPY . /app
RUN mvn clean compile package -f /app/pom.xml

RUN ls -ltra  /app/target
RUN mvn_version=$(mvn -f /app/pom.xml org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version  | grep -v "\[\|Downl" ) && \
  echo "Version of MVN project: consumer-$mvn_version.jar $mvn_version"  && \
  mv /app/target/consumer-$mvn_version.jar /app/target/consumer.jar
RUN ls -ltra  /app/target

FROM fabric8/java-alpine-openjdk11-jre
COPY --from=builder /app/target/consumer.jar /app/consumer.jar
RUN ls -ltra /app
CMD ["java", "-jar" , "/app/consumer.jar"]
