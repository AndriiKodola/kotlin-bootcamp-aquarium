package com.example.kotlin_bootcamp_aquarium.Aquarium.hof

import kotlin.system.exitProcess

enum class Directions (val direction: String) {
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w"),
    START("start"),
    END("end")
}

class Game {
    private val path = mutableListOf(Directions.START)

    private val north: () -> Unit = { path.add(Directions.NORTH); updatePosition(Directions.NORTH) }
    private val south: () -> Unit = { path.add(Directions.SOUTH); updatePosition(Directions.SOUTH) }
    private val east: () -> Unit = { path.add(Directions.EAST); updatePosition(Directions.EAST) }
    private val west: () -> Unit = { path.add(Directions.WEST); updatePosition(Directions.WEST) }

    val map = Location()
    var position = 0 to 0 // x to y

    private fun isMovePossible(direction: String): Boolean {
        val (x, y) = position
        return when (direction) {
            Directions.NORTH.direction -> x.inc() <= Location.maxX
            Directions.SOUTH.direction -> x.dec() >= 0
            Directions.EAST.direction -> y.inc() <= Location.maxX
            Directions.WEST.direction -> y.dec() >= 0
            else -> false
        }
    }

    private fun updatePosition(direction: Directions) {
        val (x, y) = position
        when (direction) {
            Directions.NORTH -> position = position.copy(first = x.inc())
            Directions.SOUTH -> position = position.copy(first = x.dec())
            Directions.EAST -> position = position.copy(second = y.inc())
            Directions.WEST -> position = position.copy(second = y.dec())
            else -> println("cannot move there")
        }
        println("you're now at $position")
    }

    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()

        false
    }

    private fun move(where: () -> Unit) {
        where()
    }

    fun makeMove(direction: String) {
        when (direction) {
            Directions.NORTH.direction -> if (isMovePossible(direction)) move(north) else println("you're on the edge")
            Directions.SOUTH.direction -> if (isMovePossible(direction)) move(south) else println("you're on the edge")
            Directions.EAST.direction -> if (isMovePossible(direction)) move(east) else println("you're on the edge")
            Directions.WEST.direction -> if (isMovePossible(direction)) move(west) else println("you're on the edge")
            else -> println("cannot move there")
        }
    }
}

class Location {
    companion object {
        const val maxX = 4
        const val maxY = 4
    }

    private val width = maxX
    private val height = maxY

    val map = Array (width) { arrayOfNulls<String>(height)}
}

fun List<Int>.findDivisibleBy(block: (Int) -> Int): List<Int> {

    val result = mutableListOf<Int>()

    forEach { if (block(it) == 0) result.add(it) }

    return result
}

fun main() {

//    // Exercise #1
//    val game = Game()
//
//    println(game.path)
//
//    game.north()
//    game.east()
//    game.south()
//    game.west()
//    game.end()
//
//    println(game.path)
//
//    // Exercise #1
//    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
//    println( numbers.findDivisibleBy {
//        it.rem(3)
//    })

    // Exercise #3
    val game = Game()

    while (true) {
        println("Enter a direction: n/s/e/w:")
        val input = readLine()
        if (input == "exit") {
            game.end()
            exitProcess(1)
        } else {
            if (input != null) {
                game.makeMove(input)
            } else {
                println("invalid input")
            }
        }
    }
}
