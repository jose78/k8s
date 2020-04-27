FROM maven as builder
COPY . /app
RUN mvn clean compile package -f /app/pom.xml -Dmaven.test.skip=true

FROM fabric8/java-alpine-openjdk11-jre
COPY --from=builder /app/target/micrometer-prometheus-0.0.1-SNAPSHOT.jar /app/micrometer-prometheus.jar
RUN ls -ltra /app
CMD ["java", "-jar" , "/app/micrometer-prometheus.jar"]
