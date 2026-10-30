# Experiment 12: CRUD Operations using JDBC

## Aim
To perform Insert, View, Update and Delete operations on a database using the Name/Password form.

## Question
> Reuse the above form to perform basic database operations (CRUD) using JDBC.

## Concepts Used
- CRUD (Create, Read, Update, Delete)
- JDBC PreparedStatement
- Reusing the Applet form

## Files
- `CrudApplet.java`
- `CrudApplet.html`
- `schema.sql`
- `Question.md`
- `Output.txt`

## How to Compile and Run
```bash
mysql -u root -p < schema.sql
javac CrudApplet.java
java -cp .:mysql-connector-j.jar CrudApplet   # use ; instead of : on Windows
```

## Output
See [`Output.txt`](Output.txt).

> Add your own screenshot of the running program here, e.g. `![Output](output.png)`.
