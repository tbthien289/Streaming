all: runClient

runClient: runServer
	java -cp target/StreamingMusic-0.0.1-SNAPSHOT.jar com.client.Client

runServer: compile
	java -cp target/StreamingMusic-0.0.1-SNAPSHOT.jar com.server.Server

compile:
	mvn package
