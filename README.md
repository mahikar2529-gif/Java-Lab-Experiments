# Java Lab Experiments

A collection of 12 Java programs covering I/O, AWT, Swing, Applets, multithreading, networking, RMI, JDBC and JavaBeans.
Each experiment has its own folder containing the **source code, question, README and output**.

## Experiments

| S. No. | Experiment | Question |
|:--:|---|---|
| 1 | [Matrix Multiplication](Experiment-01-Matrix-Multiplication/) | Write a program for matrix multiplication. Use InputStreamReader and BufferedReader classes for Input/Output. |
| 2 | [Animated String Applet (Multithreading)](Experiment-02-Animated-String-Applet/) | Write a program to animate a string on Applet. Use the concept of Multithreading. |
| 3 | [Calculator using AWT](Experiment-03-AWT-Calculator/) | Write a program to design a calculator using the AWT controls provided in Java. |
| 4 | [Client-Server Communication using TCP](Experiment-04-Client-Server-TCP/) | Write a program for Client-Server communication using either UDP or TCP protocols. Use ServerSocket and Socket classes. |
| 5 | [Notepad Features using Swing](Experiment-05-Notepad-Swing/) | Write a program to create some of the features of Notepad. Use Swings for designing this application. |
| 6 | [Remote Method Invocation (RMI)](Experiment-06-RMI-Calculator/) | Create functions like multiply, addition, and subtraction respectively. Invoke these functions from remote system by using the concept of Remote Method Invocation in Java. |
| 7 | [Form with Name and Password (Applet)](Experiment-07-Applet-Login-Form/) | Create a form containing fields name and password respectively. Use Applet as a container. |
| 8 | [Store Form Data in Database using JDBC](Experiment-08-Applet-Form-JDBC/) | The input entered in these fields should be stored in the database. Use JDBC connectivity for implementing this program. |
| 9 | [Student Registration Portal using JDBC](Experiment-09-Student-Registration-Portal/) | Write a program to create a small portal which contains the registration form of students. Use JDBC. |
| 10 | [Java Bean for Addition of Two Numbers](Experiment-10-Java-Bean-Addition/) | Write a program to create a bean component in Java for addition of two numbers. |
| 11 | [Form with Name and Password (Applet container)](Experiment-11-Applet-Form-Name-Password/) | Create a form containing fields name and password respectively, using Applet as a container. |
| 12 | [CRUD Operations using JDBC](Experiment-12-Applet-CRUD-JDBC/) | Reuse the above form to perform basic database operations (CRUD) using JDBC. |

## Folder Structure
```
Experiment-XX-Name/
 ├── README.md      # aim, concepts, how to run
 ├── Question.md    # the experiment question
 ├── Output.txt     # program output
 └── *.java         # source code (plus .html / .sql where needed)
```

## Requirements
- JDK 8 or later (`javac`, `java`)
- MySQL and the MySQL Connector/J jar for Experiments 8, 9 and 12
- Applets (Experiments 2, 7, 11, 12): modern JDKs removed `appletviewer`, so each applet also has a `main()` method that runs it inside a Frame. The `.html` files work with `appletviewer` on JDK 8 or earlier.

## Notes on Outputs
Experiments 1, 4, 6 and 10 contain output captured from real runs. Experiments that open a GUI window or need a database (2, 3, 5, 7, 8, 9, 11, 12) contain the expected output; add your own screenshots after running them.
