# PhotoApp Microservice Project
  
## PhotoAppApiConfigServer


#### Build RabbitMQ Docker Image for PhotoAppApiConfigServer

  - docker run -d --name rabbit-name-management -p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369 rabbitmq:3-management
  - Go to RabbitMQ dashboard and create users: <INSTANCE_PUBLIC_IP_ADDRESS>:15672

#### Build Docker Image for PhotoAppApiConfigServer
  - docker login --username=kevbot55
  - ./mvnw clean
  - ./mvnw package
  - docker build --tag=config-server --force-rm=true .
  - create dockerhub repository online with your account
  - docker tag <CONTAINER_ID> <DOCKERHUB_NAME_OF_REPO>
  - docker push <DOCKERHUB_NAME_OF_REPO>
  
#### Run Docker Image for PhotoAppApiConfigServer
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run --env=spring.rabbitmq.host=172.17.0.2 -p 8012:8012 kevbot55/config-server  (use Docker inspect to get rabbitmq.host)
  
 ### Set inbound ports for PhotoAppApiConfigServer
 
  ![GitHub Logo](/images/config-inbound.png)
 
 ### Test endpoints for PhotoAppApiConfigServer
 
 - See PhotoApp.postman_collection.json
 - getUserConfigDocker
 - getAppConfigDocker
 
 
 ## Eureka Server

#### Build Docker Image for PhotoAppApiConfigServer
  - docker login --username=kevbot55
  - ./mvnw clean
  - ./mvnw package
  - docker build --tag=eureka-server --force-rm=true .
  - create dockerhub repository online with your account
  - docker tag <CONTAINER_ID> <DOCKERHUB_NAME_OF_REPO>
  - docker push <DOCKERHUB_NAME_OF_REPO>
  
#### Run Docker Image for PhotoAppApiConfigServer
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run -d -p 8010:8010 -e "spring.cloud.config.uri=http://34.254.0.23:8012" kevbot55/config-server  (try to get working with private)
  or if config is all on remote server then
  - docker run -d -p 8010:8010 kevbot55/config-server  (try to get working with private)
  
 ### Set inbound ports for PhotoAppApiConfigServer
 
  ![GitHub Logo](/images/eureka-inbound.png)
 
 ### Check Euerka Dashboard
   - <PUBLIC_IP_ADDRESS_OF_EUREKA_INSTANCE>:8010
    
    
 

  
sudo service rabbitmq-server start
sudo service rabbitmq-server stop

sudo service mysql start
sudo service mysql stop

mysql -u kevin -p

keytool -genkey -alias apiEncryptionKey -keyalg RSA -dname "CN=Kevin Mcinerney,OU=API Development,O=appsdeveloperblog.com,L=Ottawa,S=ON,C=CA" -keypass 1q2w3e4r -keystore apiEncryption.jks -storepass 1q2w3e4r


kevin@Babage-Machine:~$ java -jar zipkin.jar


kevin@Babage-Machine:/usr/share/logstash$ bin/logstash -f simple-config.conf 


kevin@Babage-Machine:/usr/share/elasticsearch$ ./bin/elasticsearch


http://localhost:9200/albums-ws-2020.08.10/_search?q=*&format&pretty
http://localhost:9200/users-ws-2020.08.10/_search?q=*&format&pretty

kevin@Babage-Machine:~/kibana-4.1.1-linux-x64$ bin/kibana



# To run in chosen environment (dev prod...)
./mvnw spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=production






© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
