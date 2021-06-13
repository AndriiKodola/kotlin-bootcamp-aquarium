package com.example.kotlin_bootcamp_aquarium.Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    init {
        println("first init")
    }

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}

//Good classes contain one constructor with optional values
//If you need second constructor, consider creating helper function as below to keep classes simple
fun makeDefaultFish() = Fish(true, 50)

fun printFish() {
    val fish = Fish(true, 20)
    println("${fish.friendly}, ${fish.size}")
}
