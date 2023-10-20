# CSX42: Assignment 2
## Name: Tejas Ravindra Hiremath

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in backupSystem_StudentRecords/src folder.
-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile backupSystem_StudentRecords/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile backupSystem_StudentRecords/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile backupSystem_StudentRecords/src/build.xml run -Darg0=<input_file.txt> -Darg1=<output_file.txt> -Darg2=<errorLog_file.txt> -Darg3=<debugValue> -Darg4=<updateValue>


Replace <fileName.txt> with real file names and <debugValue> and <updateValue> with Integers. For example, if the files are available in the path,
you can run it in the following manner:

### Command: 
ant -buildfile backupSystem_StudentRecords/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=2 -Darg4=1


Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
I have designed a Backup System for Student Records, which contains four binary search trees with id's and name's of various students at the university, among which the three binary search trees are Backup's to the Main Binary Search Tree. This project stores the student records in a data structure- Binary Search Tree and every node of the Binary Search Tree is registered with 3 different observers, which are the nodes of the backup trees namely- Backup1 Tree, Backup2 Tree and Backup3 Tree using the Observer Pattern. I have implemented two different filters using the filter pattern to update the Backup Trees if the id in a particular node in the Main Binary Search Tree is updated. Backup1 and Backup2 trees use the FilterAllImpl which is set to always return true. Therefore both trees get updated when there is a change in the id of node of the Main BST. Backup3 tree uses the FilterPrimeImpl which return true if the resulting id of node of the Main BST is a prime number, otherwise not. The program writes the output to an output file which contains the inorder traversal of all the BST's and their sum, before and after the update. The error file contains any error which is encountered in the program. Above are the commands to run the demo of my project.

## Input:
Example of bstInput.txt file:
7:AA;
13:BB;
5:CC;
10:DD;
14:EE;

## Output:
The bstOutput.txt will have the following format:

Inorder Traversal
BST:  <Id-1>:<Name-1>,<Id-2>:<Name-2>,<Id-3>:<Name-3>,<Id-4>:<Name-4>,...,<Id-n>:<Name-n>
Backup-1:  <Id-1>:<Name-1>,<Id-2>:<Name-2>,<Id-3>:<Name-3>,<Id-4>:<Name-4>,...,<Id-n>:<Name-n>
Backup-2:  <Id-1>:<Name-1>,<Id-2>:<Name-2>,<Id-3>:<Name-3>,<Id-4>:<Name-4>,...,<Id-n>:<Name-n>
Backup-3:  <Id-1>:<Name-1>,<Id-2>:<Name-2>,<Id-3>:<Name-3>,<Id-4>:<Name-4>,...,<Id-n>:<Name-n>

Sum of all the B-Numbers in each tree
BST: <MainBSTSum>
Backup-1: <Backup1Sum>
Backup-2: <Backup2Sum>
Backup-3: <Backup3Sum>

Sum of all the B-Numbers after increment
BST: <MainBSTSum>
Backup-1: <Backup1Sum>
Backup-2: <Backup2Sum>
Backup-3: <Backup3Sum>

-----------------------------------------------------------------------
### Quality of the Solution: 
This program is efficient while performing all the operations. Such as, while updating the nodes of the backup trees we have used the observer pattern which does not require us to traverse all the backup trees one by one but update the nodes using the notifyAllObserver() method of NodeImpl. If the main tree is ever lost or deleted we have the backup nodes in such cases which makes this algorithm safe to use when these types of risks occur.

Algorithm Used: The BSTBuilder.java file, uses the FileProcessor API to read the input file line by line and inserts into the four instances of Binary Search tree namely- MainBST, Backup1, Backup2, Backup3 using the B-Number to insert in the Binary Search Tree. The Backup1, Backup2, Backup3 trees are the Backup Trees for the Main Binary Search Tree. All the nodes of backup trees are registered as Observers to the nodes of MainBST using the Observer Pattern. It also uses the Filter Pattern to store the filter used for a particular backup tree. Here, the Backup1 and Backup2 use the FilterAllImpl filter which is set to always return true. The Backup3 uses the FilterPrimeImpl which uses the utility class checkPrime to check whether a number a number is prime and return a boolean value- true if the number is prime, otherwise false.

If any id in the node of the Main BST is updated, the corresponding backup nodes are also updated using the notify method of NodeImpl. If the resulting id in the node of the MainBST is Prime then only the Backup3 node is updated.


### Time Complexity: 

The total amount of time taken by the algorithm is Theta(N^(2)) time complexity.

BinarySearchTree Methods-
The worst case time complexity of insert method of Binary search tree is O(h) time, where h denotes the height of the binary search tree. In worst case, we may have to travel till the leaf node to insert in the BST which is O(N) time, where N denotes the total number of lines in the input file.

The Update method of the BST takes total of (K^(1/2) to check whether the B-Number is prime or not) N * K^(1/2) + c which is Theta(N*K^(1/2)+c) worst case time complexity where, N denotes the total number of lines in the input file and K is the largest value of an id in the input file.

Other methods such as Inorder and Sum method are similar to Inorder traversal that's why the time complexity remains O(N).

BSTBuilder Methods-
The Insert method of the BST Builder takes O(N^2) time comeplexity in the worst case where N denotes the number of lines in the Input file. 

The Update method of the BST Builder takes total of (K^(1/2) to check whether the B-Number is prime or not) N * K^(1/2) + c which is Theta(N*K^(1/2)+c) worst case time complexity where, N denotes the total number of lines in the input file and K is the largest value of an id in the input file.

Other Methods of the BST Builder such as Inorder and Sum are called only once that's why their time complexity remains O(N).  

NodeImpl Methods-
The notifyAllObservers takes O(K^1/2 + c) which is O(K^(1/2)) time where N denotes the total number of lines in the input file and K is the largest value of an id in the input file.

Other methods such as registerObserver, update and updateNode methods take constant amount of time.

### Data Structures used: 

This Algorithm uses Data Structures- (Custom DataStructures: NodeImpl and BinarySearchTree), ArrayList, Array and HashMap.

I have created a NodeImpl Data Structure which has the member variables such as the (int)B-Number, (String)First Name, (NodeImpl)left and (NodeImpl)right. It also a uses a HashMap and an ArrayList to store the observers and filters using the Observer and Filter Pattern. It uses the registerObserver, notifyAllObservers and update methods.

I have also created a BinarySearchTree Data Structure to perform operation on tree. It has methods such as Insert, Update, Print Inorder Traversal, Calculate Sum whose time complexities are discussed above.

The NodeImpl uses a HashMap(HashMap<Filter,ArrayList<ObserverInterface>>), which is found in java.util.HashMap package to store the filter as a key and an ArrayList of Observers as a value for every node. Here the total size of hashmap is always 2 because there are only two types of filter in our program. The operations performed using HashMap are get(), find() and put() which are all constant-time operation i.e O(1) time complexity which makes these operations very efficient.

The BST Builder uses the FileProcessor API which uses a same [String]Array N number of times, it is reused to store and iterate over the id's and name's students one by one. We used Array here, because we just need to iterate over the preferences one by one and we don't want to use any other methods. We know the length of Array which is atmost 2 i.e constant time- O(1) operation.

The NodeImpl uses a ArrayList<ObserverInterface>, which is found in java.util.ArrayList package to store the observers which are using a particular filter. We have only used add() method of ArrayList which takes constant time i.e, O(1) time complexity.


-----------------------------------------------------------------------

### Purpose of all folders

bstBuilder:
    This folder contains the Main Algorithm with classes- BinarySearchTree,BSTBuilder,FilterAllImpl,FilterInterface,FilterPrimeImpl,NodeImpl,ObserverInterface,SubjectInterface.

Driver:
    This folder has the Driver class which contains the main method and accepts 5 String arguments through command line. It validates the number of arguments passed and creates an instance of projectmanager and calls its run method, passing all the arguments.

projectmanager:
    This folder has the projectManager class which calls all the methods of the bstBuilder such as insert,update,sum and inorder.

results:
    This folder has the Results class which has methods- writetoFile, writeToConsole. It contains the final result which is used to write to the output file.

utils:
    This folder contains all the utility classes- checkPrime, ExceptionHandler, FileProcessor, FileProcessorInterface, NodePair, Pair.

-----------------------------------------------------------------------
### No Slack Days used for the Assignment.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

Date: -- 10/19/2023