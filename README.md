# Swing Chess
A Java Swing based chess application

This implementation is a standalone program meant to be played on a single computer

Further versions may include networked version or a simple CPU bot
# How to run the program
You must have a Java JDK installed (this particular project built in 17.0.3.1)
```
git clone https://github.com/nrfletcher/swing-chess.git
cd swing-chess
cd gchess_jar
java -jar gchess.jar
```
# Architecture
This project utilizes the MVC (Model View Controller) design pattern
* Model -> Gane.Board
* View -> Graphics.BoardView
* Controller -> Controller.ChessController
Each package serves a unique purpose but adheres to MVC pattern overall
* Controller -> Contains controller
* Game -> Contains logic implementation, separating concerns to each piece type
* Graphics -> The view and helper classes
* Main -> Entry to the program
* Utils -> Contains helper classes for both model and controller

# Demo 
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/L1fNI0Gi7kI/0.jpg)](https://www.youtube.com/watch?v=L1fNI0Gi7kI)
