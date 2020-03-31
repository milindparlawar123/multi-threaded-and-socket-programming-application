# CSX42: Assignment 3
## Name: Smriti Janaswamy and Milind Keshav Parlawar

#### Repository Link - https://github.com/csx42/csx42-spring-2020-assign3-smriti/
-----------------------------------------------------------------------

#### Important Note : 
* All the code had initially been checked into the develop branch. 
* See a list here with the dates for the commits - https://github.com/csx42/csx42-spring-2020-assign3-smriti/commits/develop
* Guidelines for the assignment have been followed and we have not checked in more than 80% of the code 72 hours before the deadline. 
* We will eventually be raising a PR against master branch and merge it for viewing.
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
** Please Enter commands as given below without change **
## Run PersisterService first:

###Command: ant -buildfile multiThreaded/src/build.xml run-persister-service -Dport=9090 -DoutputFile=output.txt

** Note: **
* Arguments accept the absolute path of the files.
* The output file is in the same location as the input.txt file.
* The port number you enter must be in between 32768 and 50000.

## Run PrimeDetector next:

###Command: ant -buildfile multiThreaded/src/build.xml run-prime-detector -DinputFile=input.txt -DnumThreads=3 -Dcapacity=5 -DpersisterServiceIp=192.168.1.50 -DpersisterServicePort=7000 -DdebugValue=1

** Note **
* The input file name is input.txt
* The current input.txt file has some content that I have used when writing code.  
	* Please feel free to replace the text in this to test with.
* The output file name is output.txt and is in the same location as the input file.
* numThreads can be a number between 1 AND 5
* capacity is a number that must not be <= 0
* persisterServiceIp is the IP address on which the server is running. This information can be printed to the console - pick it up from there.  
	* In order to do so, type ping remote05.cs.binghamton.edu  
	* Replace 5 with the machine number you have remote'd into.  
	* This will give you a value like 128.226.114.205  
	* Once you have this value, stop it using Ctrl+C.  
* DpersisterServicePort is the port number on which the Server is running. Since we have entered it above, pick it up from there. It is also printed to the console.
* debugValue is a number between 0 AND 4 and each of the 5 values represents the following :

Additional Info -  Use 2 terminal windows to run. One window will run the persisterService and the other will run Prime Detector. 

-----------------------------------------------------------------------
## Description:

**CLASSES**
* PrimeDetector
* PersisterService
* DataSender
* WorkerThread
* PrimeNumber
* FileProcessor
* Results
* PersistValidator
* PrimeDetectorValidator
* ValidatorUtil
* Constants

**INTERFACES**
* PrimeI
* Validator

**OUTPUT FILES**
* output.txt


**DATA STRUCTURES USED**
* Vector - this is the shared data structure we have used for the Producer Consumer.

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
https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/  
http://tutorials.jenkov.com/java-util-concurrent/executorservice.html  

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
Milind Keshav Parlawar


Date: 30 Mar 2020.

-----------------------------------------------------------------------
### SLACK DAYS USED :

We have used 2 slack days for this assignment.

-----------------------------------------------------------------------
