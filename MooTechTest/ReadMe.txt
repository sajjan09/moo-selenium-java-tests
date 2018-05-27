This is  a test exercise written by Shobha Sajjan. For any queries, please email at sajjan09@gmail.com

Technical details:
-----------------
These Selenium/Junit tests were written using 'Eclipse Java EE IDE' on Windows platform for the given scenarios 
along with 2 more additional scenarios.

Prerequisites:
-------------
You would need Firefox Browser and Eclipse IDE on Windows platform to run these tests

Steps to run the tests:
----------------------
1) Expand the provided zip file and import the project from MooTechTest folder into Eclipse.
2)Make sure you have latest Java verion 8.1
3)Download selenium-java-3.12.0.zip and unzip it

4)add these jars to the Project: right click on project-> 'Build Path'->Configure build path->
go to Libraries tab->choose 'add External JARS'->add these jar files which were downloaded above:
client-combined-3.12.0.jar
byte-buddy-1.8.3.jar
commons-codec-1.10.jar
commons-exec-1.3.jar
commons-logging-1.2.jar
gson-2.8.2.jar
guava-23.6-jre.jar
httpclient-4.5.3.jar
httpcore-4.4.6.jar
okhttp-3.9.1.jar
okio-1.13.0.jar

5)Download "geckodriver-v0.20.1-win64.zip" and unzip

6)note down the path of gekodriver.exe file as this needs to added in each test class' setUp method.

7)Add JUnit dependencies by downloding these jars:
 "hamcrest-core-1.3.jar" 
 "junit-4.12.jar" 
 
 