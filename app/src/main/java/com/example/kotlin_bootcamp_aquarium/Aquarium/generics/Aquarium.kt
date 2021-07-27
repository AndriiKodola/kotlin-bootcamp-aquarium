package com.example.kotlin_bootcamp_aquarium.Aquarium.generics


fun main(args: Array<String>) {
    genericExample()
}


open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {

    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {

    fun filter() {
        needsProcessed = false
    }
}

//WaterSupply in this case is a top type in a type hierarchy we want to use
class Aquarium<T: WaterSupply>(val waterSupply: T) {

    fun addWater() {
        //check acts as an assertion, and will throw an illegal argument exception if it's argument is false
        check(!waterSupply.needsProcessed) { "water supply needs processing" }

        println("adding water from $waterSupply")
    }
}

fun genericExample() {

    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    aquarium2.addWater()
}
