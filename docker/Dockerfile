FROM tomcat:jre8
MAINTAINER Bino Varghese 
RUN \
rm -rf /opt/tomcat/webapps/examples && \
rm -rf /opt/tomcat/webapps/docs && \
rm -rf /opt/tomcat/webapps/ROOT && \
rm -rf /opt/tomcat/webapps/host-manager && \
rm -rf /opt/tomcat/webapps/manager
COPY cmad-t9bloggerV3-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war