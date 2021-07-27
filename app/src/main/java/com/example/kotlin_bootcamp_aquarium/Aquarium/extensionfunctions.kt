package com.example.kotlin_bootcamp_aquarium.Aquarium

fun String.hasSpaces() = find {it == ' '} != null

/** convenient to use as helper functions for the classes we do own */
open class AquariumPlant(val color: String, private val size: Int)

//doesn't have access to private variable
fun AquariumPlant.isRed() = color == "Red"
/** ----------------------- */

class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(50)
    plant.print() //GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() //AquariumPlant - this is because extension functions are resolved statically (at compile time). Compiler just looks at a type of a variable
}

//Extension properties
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen //true
}

//Extension with nullable receivers
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull() // ok
}
