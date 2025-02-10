package org.example

import kotlin.math.absoluteValue

val winPatterns = listOf(
    listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
    listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
    listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonals
)

fun main() {
    gameLoop()
//    val userInput = readln().replace("_", " ")
//    printGrid(userInput)
//    move(userInput)
//    println(determineStatus(userInput))
}

fun printGrid(gridSymbols: String) {
    println("---------")
    gridSymbols.chunked(3).forEach { println("| ${it.toCharArray().joinToString(" ")} |") }
    println("---------")
}

fun move(gridSymbols: String, currentPlayer: String): String {
    val gameMatrix = gridSymbols.toMutableList()
//    println(gameMatrix)
    var validInput = false

    while (!validInput) {
        val input = readln().split(" ")
        val row = input.getOrNull(0)?.toIntOrNull()?.minus(1)
        val col = input.getOrNull(1)?.toIntOrNull()?.minus(1)
        when {
            row == null || col == null -> println("You should enter numbers!")
            row !in 0..2 || col !in 0..2 -> println("Coordinates should be from 1 to 3!")
            gameMatrix[row * 3 + col] != ' ' -> println("This cell is occupied! Choose another one!")
            else -> {

                gameMatrix[row * 3 + col] = currentPlayer.first()
                printGrid(gameMatrix.joinToString(""))
                return gameMatrix.joinToString("")
            }
        }
    }
    return gridSymbols
}


fun determineStatus(gridSymbols: String): String {
    val xCount = gridSymbols.count { it == 'X' }
    val oCount = gridSymbols.count { it == 'O' }

    val xWins = winPatterns.any { pattern -> pattern.all { gridSymbols[it] == 'X' } }
    val oWins = winPatterns.any { pattern -> pattern.all { gridSymbols[it] == 'O' } }

    return when {
        xWins && oWins || (xCount - oCount).absoluteValue > 1 -> "Impossible"
        xWins -> "X wins"
        oWins -> "O wins"
        " " in gridSymbols -> "Game not finished"
        else -> "Impossible"
    }
}

fun gameLoop() {
    var gameBoard = "         "
    var currentPlayer = "X"
    printGrid(gameBoard)
    var gameStatus = "Game not finished"
    while (gameStatus == "Game not finished") {
        gameBoard = move(gameBoard, currentPlayer)
        gameStatus = determineStatus(gameBoard)
        currentPlayer = if (currentPlayer == "X") "O" else "X"
    }
    println(gameStatus)
}