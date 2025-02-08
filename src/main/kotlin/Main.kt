package org.example

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
    val userInput = readln()
    printGrid(userInput)
    var status = ""


    status = if (userInput.contains("_")) {
        if (countsApplicable(userInput) && !containThreeInARow(userInput)) {
            if(determineWinner(userInput) == "") "Game not finished"
            else determineWinner(userInput) + " wins"
        } else {
            "Impossible"
        }
    } else {
        if (countsApplicable(userInput) && !containThreeInARow(userInput)) {
            if(determineWinner(userInput) == "") "Draw"
            else determineWinner(userInput) + " wins"
        } else {
            "Impossible"
        }
    }

    print(status)

}

fun printGrid(gridSymbols: String) {
    println("---------")
    gridSymbols.chunked(3).forEach { println("| ${it.toCharArray().joinToString(" ")} |" )}
    println("---------")
}

fun countsApplicable(userInput: String): Boolean {
    val cntX = userInput.count { it == 'X' }
    val cntY = userInput.count { it == 'O' }

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