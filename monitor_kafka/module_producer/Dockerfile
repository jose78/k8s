FROM maven as builder
COPY . /app
RUN mvn clean compile package -f /app/pom.xml

RUN ls -ltra  /app/target
RUN mvn_version=$(mvn -f /app/pom.xml org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version  | grep -v "\[\|Downl" ) && \
  echo "Version of MVN project: producer-$mvn_version.jar $mvn_version"  && \
  mv /app/target/producer-$mvn_version.jar /app/target/producer.jar
RUN ls -ltra  /app/target

FROM fabric8/java-alpine-openjdk11-jre
COPY --from=builder /app/target/producer.jar /app/producer.jar
RUN ls -ltra /app
CMD ["java", "-jar" , "/app/producer.jar"]
