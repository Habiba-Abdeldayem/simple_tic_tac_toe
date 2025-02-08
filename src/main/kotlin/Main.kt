package org.example

fun main() {
    val grid = readln()
    printGrid(grid)
}

fun printGrid(gridSymbols: String) {
    println("---------")
    gridSymbols.chunked(3).forEach { println("| ${it.toCharArray().joinToString(" ")} |" )}
    println("---------")
}
