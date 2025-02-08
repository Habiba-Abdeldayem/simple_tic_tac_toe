package org.example

import java.sql.DriverManager.println
import kotlin.math.absoluteValue

val row1 = listOf(0, 1, 2)
val row2 = listOf(3, 4, 5)
val row3 = listOf(6, 7, 8)
val col1 = listOf(0, 3, 6)
val col2 = listOf(1, 4, 7)
val col3 = listOf(2, 5, 8)
val diagonal1 = listOf(0, 4, 8)
val diagonal2 = listOf(2, 4, 6)
val game = listOf(
    row1, row2, row3, col1, col2, col3, diagonal1, diagonal2
)

fun main() {
    val grid = readln()
    game_state(grid)
    val xCount = grid.count { it == 'X' }
    val oCount = grid.count { it == 'O' }

    val winPatterns = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
        listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonals
    )

    val xWins = winPatterns.any { pattern -> pattern.all { grid[it] == 'X' } }
    val oWins = winPatterns.any { pattern -> pattern.all { grid[it] == 'O' } }


    val status = when{
        xWins && oWins || (xCount - oCount).absoluteValue > 1 -> "Impossible"
        xWins -> "X wins"
        oWins -> "O wins"
        "_" in grid -> "Game not finished"
        else -> "Draw"
    }

    print(status)



}

fun game_state(gridSymbols: String) {
    print("---------\n|")
    var stringIndex = 0

    for (symbolIdx in gridSymbols.indices) {
        print("${gridSymbols[symbolIdx]} ")
        if (symbolIdx == 2 || symbolIdx == 5 || symbolIdx == 8) print("|\n|")
    }

//    var line1 = gridSymbols[0] + " " + gridSymbols[1] + " " + gridSymbols[2]
//    var line2 = gridSymbols[3] + " " + gridSymbols[4] + " " + gridSymbols[5]
//    var line3 = gridSymbols[6] + " " + gridSymbols[7] + " " + gridSymbols[8]
//    line(line1)
//    line(line2)
//    line(line3)

    print("---------\n")
}

fun line(line: String) {
    println("| $line |")
}

fun countsApplicable(userInput: String): Boolean {
    val cntX = userInput.count { it == 'X' }
    println("cnt x: $cntX")
    val cntY = userInput.count { it == 'O' }
    println("cnt y: $cntY")

    val isApplicable = (cntX == cntY) || (cntX == cntY - 1) || (cntY == cntX - 1)
    return isApplicable
}

fun containThreeInARow(userInput: String): Boolean {

    var countWinner = 0

    for (line in game) {
        if (userInput[line[0]] == 'X' && userInput[line[1]] == 'X' && userInput[line[2]] == 'X' || userInput[line[0]] == 'O' && userInput[line[1]] == 'O' && userInput[line[2]] == 'O') {
            countWinner++
            if (countWinner > 1) return true
        }
    }

    return false
}

fun determineWinner(userInput: String): String {
    var winner = ""

    for (line in game) {
        if (userInput[line[0]] == 'X' && userInput[line[1]] == 'X' && userInput[line[2]] == 'X') {
            winner = "X"
            return winner
        } else if (userInput[line[0]] == 'O' && userInput[line[1]] == 'O' && userInput[line[2]] == 'O') {
            winner = "O"
            return winner
        }
    }
    return winner
}