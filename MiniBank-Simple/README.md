# MiniBank Simple Final Project

A simple beginner-friendly Java console banking application. The integrated Practical 14 service layer and JUnit integration test have been removed as requested. The main program now uses a small `ArrayList<Account>` and direct helper methods so the banking flow is easier to understand.

## Requirements
- JDK 17 or newer
- VS Code or another Java IDE

## Run in VS Code
1. Extract the ZIP file.
2. Open the `MiniBank-Simple` folder in VS Code.
3. Open Terminal > New Terminal.
4. Run:

```powershell
.\run.bat
```

If `run.bat` is not found, run `Get-ChildItem` and make sure the terminal is in the folder that contains `run.bat`. You can also run the included JAR with:

```powershell
java -jar .\MiniBank.jar
```

## Main menu
1. Open account
2. Deposit
3. Withdraw
4. Transfer
5. List accounts
6. Print statement
7. Exit

Accounts stay in memory only while the program is running. Restarting the application clears the accounts created during the previous run. Persistence, transaction logging, reporting, and other advanced concepts remain as separate Practical 11 and earlier demo classes; they are not connected to the main menu.

## Practical concepts retained
1. Record, enum, menu loop, Scanner, switch expression.
2. Account objects, constructors, encapsulation, static account IDs, deposit/withdraw.
3. `toString`, `equals`, `hashCode`, nested Address, clone-related and object comparison concepts.
4. Regex validation, command record/parser, StringBuilder statement.
5. Account inheritance and method overriding for interest rates.
6. Interfaces and packages; runnable JAR packaging.
7. Custom annotations and reflection-based validation.
8. Checked bank exceptions and try-with-resources demonstration.
9. Synchronized balance operations.
10. ExecutorService and producer-consumer using wait/notify.
11. Serializable state, transaction logs, and report generation as separate examples.
12. HashMap/ConcurrentHashMap, ArrayList, Comparable and Comparator sorting examples.
13. Generic Repository, `@Id` reflection, SafeVarargs, and bounded generic average examples.
