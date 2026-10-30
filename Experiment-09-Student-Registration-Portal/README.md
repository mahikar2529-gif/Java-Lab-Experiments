# Experiment 9: Student Registration Portal using JDBC

## Aim
To create a student registration portal that stores students in a database and lists them.

## Question
> Write a program to create a small portal which contains the registration form of students. Use JDBC.

## Concepts Used
- Swing form + JTable
- JDBC INSERT / SELECT
- Input validation

## Files
- `StudentPortal.java`
- `schema.sql`
- `Question.md`
- `Output.txt`

## How to Compile and Run
```bash
mysql -u root -p < schema.sql
javac StudentPortal.java
java -cp .:mysql-connector-j.jar StudentPortal   # use ; instead of : on Windows
```

## Output
See [`Output.txt`](Output.txt).

> Add your own screenshot of the running program here, e.g. `![Output](output.png)`.
