#instructions to build the code and execute it

1. Navigate to the folder \StoreOrderApplication in cmd prompt or shell

#Run all the tests, download the dependencies and generate the jar file
2. execute the command

mvn clean install

#Run the jar file inside the embedded server
3. execute this command to start the server in default port 8080

mvn spring-boot:run

#Test file upload from postman

4. Submit a post request to the url http://localhost:8080/api/uploadStoreOrder with the key as 'file' and then choose the csv file.

5. Verify the response messages in the postman


#Javadocs

1. Navigate to the folder \StoreOrderApplication\Javadocs

2. open the index.html to naviage across and read the javadocs for all the classes and its methods