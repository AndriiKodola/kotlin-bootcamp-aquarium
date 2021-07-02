package com.example.kotlin_bootcamp_aquarium.Aquarium

//singleton pattern
object MobyDickWhale {

    val author = "Herman Melville"

    fun jump() {
        // ...
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

//can only be used as a subclass in the same file, kotlin is able to know all sub classes statically (at compile time). So compiler may provide extra checks.
//it's great for representing fixed number of types, for example for returning success of error on a network API
sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
    //because kotlin knows all subclasses at compile time, when would give an error if not all of the subclasses listed
    return when(seal) {
        is SeaLion -> "SeaLion"
        is Walrus -> "Walrus"
    }
}