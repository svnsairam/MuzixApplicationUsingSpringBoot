FROM java:8-jre
ENV MYSQL_DATABASE=database1
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:6603/database1
ADD ./target/MuzixApplication-0.0.1-SNAPSHOT.jar /usr/src/MuzixApplication-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/usr/src/MuzixApplication-0.0.1-SNAPSHOT.jar"]
