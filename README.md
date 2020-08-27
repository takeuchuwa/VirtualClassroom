# VirtualClassroom

Deploy VirtualClassroom-1-0.war to your servlet container and start server.
Class info: javadoc.

Pages: 
* /views/login.xhtml
* /views/members.xhtml(loginfailed.xhtml in case of failed login)
              
Both pages has filters. If you are not authenticated user, you can't reach "members", and viceversa (already authenticated can't reach "login").
Members screen fully dynamic.

Technologies: Java 11, Primefaces 8.0, JSF 2.3, HTML/CSS, XML, Bootstrap, Apache Tomcat 9.0.37, Maven.
