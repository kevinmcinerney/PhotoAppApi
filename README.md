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
  - docker tag <IMAGE_ID> <DOCKERHUB_NAME_OF_REPO>
  - docker push <DOCKERHUB_NAME_OF_REPO>
  
#### Run Docker Image for PhotoAppApiConfigServer
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run --env=spring.rabbitmq.host=172.17.0.3 -p 8012:8012 kevbot55/config-server  (use Docker inspect to get rabbitmq.host)
  
 #### Set inbound ports for PhotoAppApiConfigServer
 
  ![GitHub Logo](/images/config-inbound.png)
 
 #### Test endpoints for PhotoAppApiConfigServer
 
 - See PhotoApp.postman_collection.json
 - getUserConfigDocker
 - getAppConfigDocker
 
 
## Eureka Server

#### Build Docker Image for Eureka Server
  - docker login --username=kevbot55
  - ./mvnw clean
  - ./mvnw package
  - docker build --tag=km-eureka-server --force-rm=true .
  - create dockerhub repository online with your account
  - docker tag <IMAGE_ID> <DOCKERHUB_NAME_OF_REPO>
  - docker push <DOCKERHUB_NAME_OF_REPO>
  
#### Run Docker Image for Eureka Server
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run -d -p 8010:8010 kevbot55/config-server 
  
 #### Set inbound ports for Eureka Server
 
  ![GitHub Logo](/images/eureka-inbound.png)
 
 #### Check Dashboard for Eureka Server
   - <PUBLIC_IP_ADDRESS_OF_EUREKA_INSTANCE>:8010
    
    
## Zuul Server
  
#### Build Docker Image for Zuul Server
  - docker login --username=kevbot55
  - ./mvnw clean
  - ./mvnw package
  - docker build --tag=km-zuul_api-gateway --force-rm=true .
  - create dockerhub repository online with your account
  - docker tag <IMAGE_ID> <DOCKERHUB_NAME_OF_REPO>
  - docker push <DOCKERHUB_NAME_OF_REPO>
  
#### Run Docker Image for Zuul Server
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run -d -p 8010:8010 kevbot55/km-zuul-api-gateway
  
 #### Set inbound ports for Zuul Server
 
  ![GitHub Logo](/images/zuul-inbound.png)
 
 #### Check Dashboard for Zuul Server
   - <PUBLIC_IP_ADDRESS_OF_ZUUL_INSTANCE>:8010
   
   
## MYSQL SERVER
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - sudo service docker start
  - sudo usermod -a -G docker ec2-user
  - docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=kevin -e MYSQL_DATABASE=photo_app -e MYSQL_USER=kevin -e MYSQL_PASSWORD=kevin                   -v /var/lib/mysql:/var/lib/mysql  mysql:5.7.31
  
   #### Set inbound ports for Zuul Server
 
  ![GitHub Logo](/images/mysql-inbound.png)
  
  ## Kibabana + Elastic Search
  - ssh into aws instance
  - docker login --username=kevbot55
  - sudo yum update
  - sudo yum install docker 
  - docker network create --driver bridge api-network
  - docker run -d -v esdata1:/usr/share/elasticsearch/data --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" 
                  --network api-network elasticsearch:7.3.0
  - docker run -d --network api-network -p 5601:5601 kibana:7.3.0

#### ELastic + Kibana inbound ports

  ![GitHub Logo](/images/elastic-kibana-inbound.png)
  


  

  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
  
 

  
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
