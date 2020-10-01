#!/bin/bash

cd

mvn install:install-file -Dfile=lib/salesforce-rest-connector/1.0.4/salesforce-rest-connector-1.0.4.jar -DpomFile=lib/salesforce-rest-connector/1.0.4/salesforce-rest-connector-1.0.4.pom

git clone https://github.com/chappie-chatbot/chappie-timeentry.git chappie-timeentry

cd chappie-timeentry
git checkout master
git pull
mvn clean install -DskipTests

cd

java -jar $(ls /chappie/chappie-timeentry/target/chappie-timeentry*.jar | head -n 1)

