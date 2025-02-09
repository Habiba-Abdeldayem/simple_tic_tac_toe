package org.example

import kotlin.math.absoluteValue

val winPatterns = listOf(
    listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
    listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
    listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonals
)


fun main() {
    val userInput = readln().replace("_", " ")
    printGrid(userInput)
    move(userInput)
//    println(determineStatus(userInput))
}

fun printGrid(gridSymbols: String) {
    println("---------")
    gridSymbols.chunked(3).forEach { println("| ${it.toCharArray().joinToString(" ")} |") }
    println("---------")
}

fun move(gridSymbols: String) {
    val gameMatrix = gridSymbols.chunked(3).map { it.toMutableList() }.toMutableList()
//    println(gameMatrix)
    var validInput = false

    while (!validInput) {
        val twoNumbers = readln().split(" ").map { it.first() }.toCharArray()
        val a = twoNumbers.first()
        val b = twoNumbers.last()
        val aInt = a.digitToIntOrNull()?.minus(1)
        val bInt = b.digitToIntOrNull()?.minus(1)
        when {
            !a.isDigit() || !b.isDigit() -> println("You should enter numbers!")
            a.digitToInt() !in 1..3 || b.digitToInt() !in 1..3 -> println("Coordinates should be from 1 to 3!")
            gameMatrix[aInt!!][bInt!!] != ' ' -> println("This cell is occupied! Choose another one!")
            else -> {
                val idx = aInt * 3 + bInt
                val updatedGrid = gridSymbols.replaceRange(idx, idx + 1, "X")
                printGrid(updatedGrid)
                validInput = true
            }
        }
    }
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
        "_" in gridSymbols -> "Game not finished"
        else -> "Impossible"
    }
}

