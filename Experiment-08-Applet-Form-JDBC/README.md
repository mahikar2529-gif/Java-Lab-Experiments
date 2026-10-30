# Experiment 8: Store Form Data in Database using JDBC

## Aim
To save the Name and Password entered in a form into a MySQL database using JDBC.

## Question
> The input entered in these fields should be stored in the database. Use JDBC connectivity for implementing this program.

## Concepts Used
- JDBC (DriverManager, Connection, PreparedStatement)
- MySQL
- Applet form

## Files
- `LoginDB.java`
- `schema.sql`
- `Question.md`
- `Output.txt`

## How to Compile and Run
```bash
mysql -u root -p < schema.sql
javac LoginDB.java
java -cp .:mysql-connector-j.jar LoginDB   # use ; instead of : on Windows
```

## Output
See [`Output.txt`](Output.txt).

> Add your own screenshot of the running program here, e.g. `![Output](output.png)`.
