FROM tomcat:latest
ADD target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]