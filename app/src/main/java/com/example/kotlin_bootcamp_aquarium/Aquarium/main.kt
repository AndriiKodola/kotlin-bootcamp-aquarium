package com.example.kotlin_bootcamp_aquarium.Aquarium

fun main (args: Array<String>) {
    buildAquarium()
    makeFish()
}

private fun buildAquarium() {

    val myAquarium = Aquarium()
    val smallAquarium = Aquarium(20, 15, 30)
    val aquarium2 = Aquarium(5)

    println(myAquarium.volume)
    println(smallAquarium.volume)
    println(aquarium2.volume)
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark: ${shark.color} \nPlecostomus: ${plecostomus.color}")

    shark.eat()
    plecostomus.eat()
}
