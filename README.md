# CRUDoperation
1. Tools & technologies: Java, Selenium, Maven, TestNG and also I used json to save test data and read from it.
2. pom.xml file: contains the dependencies I used in my code
3. I've used Page Object Model designing the Script so the project is divided into two packages:-
-Src/main/java which contains 2 Packages: 
*Package “data”: includes “jsondata.json” file and “dataReader” class that reads the data from the json file to not to set the data hard coded in the script
*Package “crud_test”: includes “CRUDoperation” class that contains the main script that runs the automated test case 
4. RunTest.xml file: to run the tests from it as automation test
