# CI-Server

This is a small CI Server made to work with GitHub. This CI Server has been used with GitHub Webhooks, when a commit and push (or how you've set up the web hook) is made to the GitHub repository the server clones the repository, compiles it and run some specified tests and finally sends an email with the result.

Note: The CI Server is tested to clone, compile and run tests of itself. Therefore, if the CI Server is used with webhooks to another repository it might not work properly as compiling is done with Maven.

See API documentation in index.html

## Installation

CI-Server requires Maven to build. You can download it and from their [website](https://maven.apache.org/download.cgi) or Brew installation or any other package manager. 

We recommend you to fork this repository and set up your own webhook, you can try this locally using [ngrok](https://ngrok.com/download) (see their website for more information about ngrok).

The CI Server supports notification of results via email. It is currently using gmail SMTP for this but this can be changed to your liking. Thus you need to create a .env in /src/main/java/group22/resources with your gmail credentials and recipient (we do not recommend hardcode these into your code). If you are a TA in the course where this assignment is given you can ask the owner of the repo for the .env file, he will provide it for you. The .env file should look like this. 
```
GMAIL_USER="the user"
GMAIL_PASSWORD="the password"
RECIPIENT_EMAIL="recipient email"

```


To build the project use:
```bash
mvn clean install
```
We run the server on the machine, and we may make it visible on the Internet thanks to Ngrok:
```bash
ngrok http 8080
```
Copy the forwarding URL (e.g http://8929b010.ngrok.io) and add it as webhook ```Setting >> Webhooks```, paste it in ```Payload URL```. Make sure to change ```Application type``` to json.  

Start the CI Server, open a new terminal and type:
```
cd CI-Server
java -cp "jars/*":Assignment2-0.0.1.jar group22.CIServer

#On windows
java -cp "target/Assignment2-0.0.1.jar;jars\*" group22.CIServer
```

Now you can create a new branch in your repository, make a change and commit it to your repo. The CI Server will run all the tests and send the result to the specified email. 

## Testing
To run tests in the folder src/test/java/group22 :
```bash
mvn test
```


If you for some reason would like to run the tests of functions used by the CI Servers such as **compileProject()** , found in src/test/java/servertests :
```bash
mvn test -Pservertests
```
Note: to run servertests you need the .env file



## Statement of contributions

The contributors of this repository set up the project together, in other words created a template for the repository and created the first functionality, cloneRepository.java.

We created issues after setting up the project and divided the work by those issues, during the development of the project we've also been pair programming together. 

## Team (SEMAT)
We think it is fair to say we passed the "Seeded" state and also the "Formed" state. However, we have not decided any particular roles for any group member. Furthermore, we think that we also passed the "Collaborating" state, all the members consider this group working very well. In the state "Performing" our group consider that we may not fulfill the part of 'wasted work are continuously identified..', this is not something we actively act upon. Though, the group haven't got into those types of situations during the project and therefore it haven't been an issue yet, but still this is something we have to fulfill in order to move to the next state. 