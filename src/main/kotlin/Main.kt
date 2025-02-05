package org.example

fun main() {
    val userInput = readln()
    game_state(userInput)
}

fun game_state(gridSymbols: String) {
    println("---------")

    var line1 = gridSymbols[0] + " " + gridSymbols[1] + " " + gridSymbols[2]
    var line2 = gridSymbols[3] + " " + gridSymbols[4] + " " + gridSymbols[5]
    var line3 = gridSymbols[6] + " " + gridSymbols[7] + " " + gridSymbols[8]
    line(line1)
    line(line2)
    line(line3)

    print("----------")
}

fun line(line: String) {
    println("| $line |")
}
