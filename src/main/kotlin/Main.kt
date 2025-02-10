package org.example

import kotlin.math.absoluteValue

val winPatterns = listOf(
    listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
    listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
    listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonals
)

fun main() {
    startGame()
}

fun printBoard(board: List<Char>) {
    println("---------")
    board.chunked(3).forEach { println("| ${it.joinToString(" ")} |") }
    println("---------")
}

fun getValidMove(board: List<Char>): Pair<Int, Int> {
    while (true) {
        val input = readln().split(" ")
        val row = input.getOrNull(0)?.toIntOrNull()?.minus(1)
        val col = input.getOrNull(1)?.toIntOrNull()?.minus(1)
        when {
            row == null || col == null -> println("You should enter numbers!")
            row !in 0..2 || col !in 0..2 -> println("Coordinates should be from 1 to 3!")
            board[row * 3 + col] != ' ' -> println("This cell is occupied! Choose another one!")
            else -> return row to col

        }
    }
}


fun checkGameStatus(board: List<Char>): String {
    val xCount = board.count { it == 'X' }
    val oCount = board.count { it == 'O' }

    val xWins = winPatterns.any { pattern -> pattern.all { board[it] == 'X' } }
    val oWins = winPatterns.any { pattern -> pattern.all { board[it] == 'O' } }

    return when {
        xWins && oWins || (xCount - oCount).absoluteValue > 1 -> "Impossible"
        xWins -> "X wins"
        oWins -> "O wins"
        board.contains(' ') -> "Game not finished"
        else -> "Draw"
    }
}

fun startGame() {
    val gameBoard = MutableList(9) { ' ' }
    var currentPlayer = 'X'

    printBoard(gameBoard)
    while (true) {
        val (row, col) = getValidMove(gameBoard)
        gameBoard[row * 3 + col] = currentPlayer
        printBoard(gameBoard)

        when (val status = checkGameStatus(gameBoard)) {
            "X wins", "O wins", "Draw" -> {
                println(status)
                return
            }
        }
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'

    }
}