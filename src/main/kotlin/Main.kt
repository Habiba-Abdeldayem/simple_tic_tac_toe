package org.example


fun main() {
    val grid = readln()
    game_state(grid)
}

fun game_state(gridSymbols: String) {
    println("---------")

    val line1 = gridSymbols[0] + " " + gridSymbols[1] + " " + gridSymbols[2]
    val line2 = gridSymbols[3] + " " + gridSymbols[4] + " " + gridSymbols[5]
    val line3 = gridSymbols[6] + " " + gridSymbols[7] + " " + gridSymbols[8]
    line(line1)
    line(line2)
    line(line3)

    println("---------")
}

fun line(line: String) {
    println("| $line |")
}
