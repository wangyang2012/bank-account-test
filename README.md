# Bank-account-test
This is a demonstration application to manage bank account.

As a bank customer, the user can deposit, withdrawal and check balance.

To go for simplest, a bank customer can have only one account.

## To build this project
- run mvn clean install command.

## To launch a demo of this application
- run the main in App.java class.

## To launch Sonar analyse
- Download Sonar from the official site
- Execute Sonar
     - On Windows, execute:
     sonarqube\bin\windows-x86-64\StartSonar.bat
      
     - On other operating systems, as a non-root user execute:
     sonarqube/bin/[OS]/sonar.sh console
- Open Sonar GUI from http://localhost:9000 with the browser
- Login and create a Sonar project
- Go back to the project, analyse with maven command:
        mvn sonar:sonar 
            -Dsonar.projectKey=Bank-account-test 
            -Dsonar.host.url=http://localhost:9000 
            -Dsonar.login=MY_TOKEN
