# Experiment 6: Remote Method Invocation (RMI)

## Aim
To invoke multiply, add and subtract methods of a remote object using RMI.

## Question
> Create functions like multiply, addition, and subtraction respectively. Invoke these functions from remote system by using the concept of Remote Method Invocation in Java.

## Concepts Used
- Remote interface
- UnicastRemoteObject
- RMI Registry / Naming

## Files
- `CalculatorInterface.java`
- `CalculatorImpl.java`
- `CalculatorServer.java`
- `CalculatorClient.java`
- `Question.md`
- `Output.txt`

## How to Compile and Run
```bash
javac *.java
# Terminal 1
java CalculatorServer
# Terminal 2
java CalculatorClient

# For a truly remote system, replace 'localhost' in CalculatorClient.java with the server's IP.
```

## Output
See [`Output.txt`](Output.txt).
