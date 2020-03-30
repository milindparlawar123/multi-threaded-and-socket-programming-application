# CSX42: Assignment 1
## Name: Smriti Janaswamy and Milind 
-----------------------------------------------------------------------

#### Important Note : 
* All the code had initially been checked into the develop branch. 
* See a list here with the dates for the commits - https://github.com/csx42/csx42-spring-2020-assign3-smriti/commits/develop
* Guidelines for the assignment have been followed and we have not checked in more than 80% of the code 72 hours before the deadline. 
* I will eventually be raising a PR against master branch and merge it for viewing.
* The reason for doing this is to help ensure I have adhered to industry standards (from my experience this is a design aspect) of always checking in code to a custom/develop branch before merging into the main branch that holds ALL the code.
* Both developers have done equal parts of the assignment. The commits may not reflect this because we have tried pair programming for some parts of the assignment.

-----------------------------------------------------------------------

#### Following are the commands and the instructions to run ANT on your project.

#### Note: build.xml is present in multiThreaded/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

###Command: ant -buildfile multiThreaded/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

###Command: ant -buildfile multiThreaded/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

## Run PersisterService first:

###Command: ant -buildfile multiThreaded/src/build.xml run-persister-service -Dport=9090 -DoutputFile=output.txt

** Note: **
* Arguments accept the absolute path of the files.
* The current input.txt file has some content that I have used when writing code.
* Please feel free to replace the text in this to test with.
* The output file is in the same location as the input.txt file.

## Run PrimeDetector next:

###Command: ant -buildfile multiThreaded/src/build.xml run-prime-detector -DinputFile=input.txt -DnumThreads=3 -Dcapacity=5 -DpersisterServiceIp=192.168.1.50 -DpersisterServicePort=7000 -DdebugValue=1

** Note **
* The input file name is input.txt
* numThreads can be a number between 1 AND 5
* capacity is a number that must not be <= 0
* persisterServiceIp is the IP address on which the server is running. This information is printed to the console - pick it up from there.
* DpersisterServicePort is the port number on which the Server is running. Since we have entered it above, pick it up from there. It is also printed to the console.
* debugValue is a number between 0 AND 4 and each of the 5 values represents the following :

DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]  
DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]  
DEBUG_VALUE=2 [Print to stdout everytime an entry is added to the Results data structure]  
DEBUG_VALUE=1 [Print to stdout the contents of the data structure in the store Results instance]  
DEBUG_VALUE=0 [No output should be printed from the application, except the line "The sume of all the prime numbers is: XYZ" ]  

Additional Info -  Use 2 terminal windows to run. One window will run the persisterService and the other will run Prime Detector. 

-----------------------------------------------------------------------
## Description:

**CLASSES**


**INTERFACES**


**OUTPUT FILES**


**DATA STRUCTURES USED**


**DOCUMENTATION**  
* I have provided documentation in Javadoc style as much as possible for classes and methods.

**OTHER ASPECTS MENTIONED IN GUIDELINES**

For exception handling, I have used **both** try catch blocks as well as throwing exceptions where I felt it was necessary.  

-----------------------------------------------------------------------
## REFERENCES and CITATIONS

https://www.programcreek.com/2011/03/java-write-to-a-file-code-example/  
https://stackoverflow.com/questions/16390309/write-out-java-vector-results-to-file  
https://codereview.stackexchange.com/questions/36942/java-printwriter-not-printing-data-to-file  
https://stackoverflow.com/questions/30662642/printwriter-write-vs-print-method-in-java  
https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html  
https://howtodoinjava.com/java/io/java-write-to-file/  
http://www.java2s.com/Code/Java/File-Input-Output/OutputtoatextFile.htm  
http://www.java2s.com/Code/Java/Collections-Data-Structure/SaveVectortofile.htm  
https://www.dreamincode.net/forums/topic/202955-producer-consumer-problem-using-tcp-clientserver/  
https://github.com/Dhirajdgandhi/Producer-Consumer-problem-using-Socket-Programming  
https://stackoverflow.com/questions/15156888/client-server-assignment-modeled-using-java-threads-producer-consumer-queues  
https://codereview.stackexchange.com/questions/180061/socket-server-with-consumer-producer-design-to-handle-concurrent-connections  
https://stackoverflow.com/questions/2888725/multiple-depends-in-ant-task  

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

--
Smriti Janaswamy



Date: 30 Mar 2020.

-----------------------------------------------------------------------
### SLACK DAYS USED :

We have used 1 slack day for this assignment.

-----------------------------------------------------------------------
