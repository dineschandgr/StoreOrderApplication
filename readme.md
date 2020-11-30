#Decisions 

1. Initially i wanted to hardcode the system path of the CSV and process it but i have assumed that my solution would be used for uploading files dynamically by differenct clients. Hence i have designed it as an API to be used by the clients. 

2. The application processes only CSV files for now. But we can easily extend the functionality to process other file types by creating a new implementation class which implements FileParser interface.

3. I was thinking about processing only the unique records and save them to the database but it might cause ambiguity to the client. So if any duplicate record exists, none of the records would be processed and stored in DB.

4. The CSV has more columns than the database table but i am only processing what is required by the DB table. I am using builder pattern to construct the object based on the attributes.

5. I am using separate DB for application (MySQL) and Tests (H2).

6. This solution follows Test Driven Development (TDD) approach where the test cases were written first and made to fail. Then the actual logic was written and the test cases were executed to pass.

7. Test cases have been written and executed to test the controller end point, service, utility and the repository.

8. I am following Domain Driver Design (DDD) where every class name, method name and the class variables follow the business domain

9. This solutions follows SOLID principles of Object Oriented Design (OOD)

10. Every class in this project follows SRP(Single Responsibility Principle). Example ExceptionHandling is done by a separate class and it only does that work. All the possible exceptions have been handled by the code.

11. Hibernate ORM tool is used for persistence. In future, we can easily switch to any database provider with minimal configuration


#Assumptions

1. I am assuming that the file size is not more than 100 MB. If the file size is more, client needs to split the file into multiple file or we need to do batch processing asynchronously using Spring Batch. This ensures better throughput with low latency.

2. I am assuming that docker image is built for this application it runs inside docker containers with a container orchestrator like Kubernetes. This will make the application highly scalable, fault tolerant and resilient.

3. I have assumed that my end points are secured using OAuth2 / Open ID Connect frameworks.

4. I have assumed that my Database credentials are encrypted and stored in a vault and the applications are not affected when the password is rotated