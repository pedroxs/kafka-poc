# Kafka with Spring POC

Demonstration of using [Kafka][] with [Spring][]. [Docker][] used for infra setup. 

### Setup

There is one producer and two consumers. 
The producer sends a message to "myTopic" every second randomly choosing the 
partition number (0 or 1). There is one dedicated consumer for each partition.

You will need the following installed for this demo:

 - JDK 1.8
 - Docker
 - Docker Machine
 - Maven (optional)
 
##### Running on docker

To run on docker execute on a shell console, from the root folder, the following commands:

    mvn clean package
    docker-compose up -d
    
Verify all is working with (Ctrl-C to exit):
    
    docker-compose logs -f app

To stop everything and cleanup:

    docker-compose down -v

It is possible to add more brokers with the command (For the current demo app this will not be used!):

    docker-compose scale kafka=4


##### Running on local (debug)    

To run locally for debugging, first start the kafka broker. From root folder run:

    docker-compose -f docker-compose-dev.yml up -d
    
From your IDE run the `KafkaPocApplication` main method in debug mode.  

## Additional information

To access the kafka shell run the following script from the root folder:

    ./start-kafka-shell.sh

From there you will be able to create, inspect and manage your kafka broker.

Create a topic:

    > $KAFKA_HOME/bin/kafka-topics.sh --create --topic topic \
    --partitions 4 --zookeeper $ZK --replication-factor 2

List topics:
    
    > $KAFKA_HOME/bin/kafka-topics.sh --describe --topic topic --zookeeper $ZK
    
Start a console producer:
     
    > $KAFKA_HOME/bin/kafka-console-producer.sh --topic=topic \
    --broker-list=`broker-list.sh`
    
Start a console consumer (from another shell instance):    

    > $KAFKA_HOME/bin/kafka-console-consumer.sh --topic=topic --zookeeper=$ZK
    
---

Thanks to [https://github.com/wurstmeister/kafka-docker](https://github.com/wurstmeister/kafka-docker) for the amazing docker images and tutorial.
    
[Kafka]: https://kafka.apache.org/
[Spring]: https://projects.spring.io/spring-kafka/
[Docker]: https://www.docker.com/