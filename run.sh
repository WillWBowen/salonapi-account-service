#!/bin/sh
echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z eurekaserver $EUREKASERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z configserver $CONFIGSERVER_PORT`; do sleep 3; done
echo "*******  Configuration Server has started"

echo "********************************************************"
echo "Waiting for the authentication server to start on port $AUTHSERVICE_PORT"
echo "********************************************************"
while ! `nc -z authenticationservice $AUTHSERVICE_PORT`; do sleep 3; done
echo "*******  Authentication Server has started"



#echo "********************************************************"
#echo "Waiting for the kafka server to start on port  $KAFKASERVER_PORT"
#echo "********************************************************"
#while ! `nc -z kafkaserver $KAFKASERVER_PORT`; do sleep 10; done
#echo "******* Kafka Server has started"
#
#echo "********************************************************"
#echo "Waiting for the ZIPKIN server to start  on port $ZIPKIN_PORT"
#echo "********************************************************"
#while ! `nc -z zipkin $ZIPKIN_PORT`; do sleep 10; done
#echo "******* ZIPKIN has started"
#

echo "********************************************************"
echo "Starting Account service on port $ACCOUNTSERVICE_PORT}"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom \
     -Dspring.cloud.config.uri=$CONFIGSERVER_URI                          \
     -Dspring.cloud.config.password=$CONFIGSERVER_PASSWORD                \
     -Dspring.profiles.active=$PROFILE                                    \
     -jar /usr/local/accountservice/app.jar

