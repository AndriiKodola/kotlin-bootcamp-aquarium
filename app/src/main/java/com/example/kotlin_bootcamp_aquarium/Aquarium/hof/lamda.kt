package com.example.kotlin_bootcamp_aquarium.Aquarium.hof

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game() {
    val path = mutableListOf(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()

        false
    }
}

fun List<Int>.findDivisibleBy(block: (Int) -> Int): List<Int> {

    val result = mutableListOf<Int>()

    forEach { if (block(it) == 0) result.add(it) }

    return result
}

fun main() {

    // Exercise #1
    val game = Game()

    println(game.path)

    game.north()
    game.east()
    game.south()
    game.west()
    game.end()

    println(game.path)

    // Exercise #1
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println( numbers.findDivisibleBy {
        it.rem(3)
    })
}
