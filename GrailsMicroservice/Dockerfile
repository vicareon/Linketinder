FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
ADD /build/libs/GrailsMicroservice-0.1.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]