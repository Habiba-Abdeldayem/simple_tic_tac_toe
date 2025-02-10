# Tic-Tac-Toe in Kotlin

## 📌 Overview
A simple **Tic-Tac-Toe** game written in Kotlin. Two players take turns playing as `X` and `O`, and the game continues until a player wins or ends in a draw.

## 🎯 Features
- Interactive 3x3 grid with user input validation.
- Detects **win conditions**, **draws**, and **invalid moves**.
- Error handling for non-numeric and out-of-range inputs.
- Clean and efficient Kotlin implementation.

## 🚀 How to Play
1. Run the program.
2. Enter coordinates (`row col`) where you want to place `X` or `O` (1-based indexing).
3. The game checks for a **win, draw, or continues**.
4. The game ends when someone wins or there's a draw.


## 📂 Project Structure  
- 📁 src
- ┣ 📄 Main.kt # Main game logic
- ┗ 📄 README.md # Documentation

## 📚 What I Learned

While working on this project, I explored and applied several key programming concepts in Kotlin:

- **List Manipulation**: Used `chunked(3)` to divide a flat list into rows for cleaner board printing.
- **Input Handling & Validation**: Used `getOrNull()` to safely extract user input and `toIntOrNull()` to prevent crashes.
- **Game Logic Optimization**: Stored winning patterns in a predefined `winPatterns` list and used `any { pattern.all { ... } }` to check for wins efficiently.
- **State Management**: Used a `MutableList<Char>` for the board, updating it dynamically as the game progresses.
- **Loop Control & Conditions**: Implemented a `while (true)` loop with an inline `when` statement to manage game flow efficiently.

This project improved my understanding of **list operations, functional programming techniques, and game logic handling in Kotlin**. 🚀


## 🎉 Contributions
- Feel free to **fork**, improve, or suggest new features via **pull requests**! 🚀  

