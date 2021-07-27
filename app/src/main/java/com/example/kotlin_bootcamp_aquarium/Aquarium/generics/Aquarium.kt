package com.example.kotlin_bootcamp_aquarium.Aquarium.generics


fun main(args: Array<String>) {
    genericExample()
}


open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {

    fun addChemicalCleaners() = apply { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {

    fun filter() = apply { needsProcessed = false }
}

//WaterSupply in this case is a top type in a type hierarchy we want to use
// out types might only be returned, not passed as an argument (except constructors)
class Aquarium<out T: WaterSupply>(val waterSupply: T) {

    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }

        //check acts as an assertion, and will throw an illegal argument exception if it's argument is false
        check(!waterSupply.needsProcessed) { "water supply needs processing" }

        println("adding water from $waterSupply")
    }
}

// in types can only passed as an arguments, not returned
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

// in and out types are used by Kotlin to ensure, that we won't do anything unsafe with our generics
// will throw an exception if won't be sure

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample() {

    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    aquarium2.addWater()

    val cleaner = TapWaterCleaner()
    val aquarium3 = Aquarium(TapWater())
    aquarium3.addWater(cleaner)
    addItemTo(aquarium3)
}
