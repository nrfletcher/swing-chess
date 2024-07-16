<div align="center">
<a name="readme-top"></a>

# ♟️ Swing Chess

Desktop chess application built with Java Swing

</div>

## 📘 About

This implementation is a standalone program meant to be played by two users on the same machine. The design is a traditional Java MVC and is easily configurable, especially from a design perspective. I do not expect to support any changes to this project as I have had my fair share of Java GUI based programming, and I am prepared to never do it again.
## 📜 Instructions
You must have a Java JDK installed (this particular project built in 17.0.3.1)
```
git clone https://github.com/nrfletcher/swing-chess.git

cd swing-chess

cd gchess_jar

java -jar gchess.jar
```
## 🚧 Design
This project utilizes the MVC (Model View Controller) design pattern
* Model -> Game.Board
* View -> Graphics.BoardView
* Controller -> Controller.ChessController

Each package serves a unique purpose but adheres to MVC pattern overall
* Controller -> Contains controller
* Game -> Contains logic implementation, separating concerns to each piece type
* Graphics -> The view and helper classes
* Main -> Entry to the program
* Utils -> Contains helper classes for both model and controller

## Demo 
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/L1fNI0Gi7kI/0.jpg)](https://www.youtube.com/watch?v=L1fNI0Gi7kI)

## ⚠️ Requirements
This project was built using Gradle and thus requires the following to build and run tests properly:
* Java JDK 17 or higher
* Java Swing
* Gradle 7.2
* JUnit 5.8.1
