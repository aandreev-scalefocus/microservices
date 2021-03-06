cd discovery-server/
call mvn compile com.google.cloud.tools:jib-maven-plugin:0.10.1:build -Dimage=avandreev/discovery-server
cd ../
cd config-server/
call mvn compile com.google.cloud.tools:jib-maven-plugin:0.10.1:build -Dimage=avandreev/config-server
cd ../
cd rest-server/
call mvn compile com.google.cloud.tools:jib-maven-plugin:0.10.1:build -Dimage=avandreev/rest-server
cd ../
cd web-client/
call mvn compile com.google.cloud.tools:jib-maven-plugin:0.10.1:build -Dimage=avandreev/web-client
cd ../
cd hystrix-dashboard/
call mvn compile com.google.cloud.tools:jib-maven-plugin:0.10.1:build -Dimage=avandreev/hystrix-dashboard
cd ../
call docker pull avandreev/discovery-server
call docker pull avandreev/config-server
call docker pull avandreev/rest-server
call docker pull avandreev/web-client
call docker pull avandreev/hystrix-dashboard