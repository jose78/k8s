FROM maven as builder
COPY . /app
RUN mvn clean compile package -f /app/pom.xml

FROM fabric8/java-alpine-openjdk11-jre
COPY --from=builder /app/target/producer*.jar /app
RUN ls /app
