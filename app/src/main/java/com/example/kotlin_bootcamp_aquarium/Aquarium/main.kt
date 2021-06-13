package com.example.kotlin_bootcamp_aquarium.Aquarium

fun main (args: Array<String>) {
    buildAquarium()
}

private fun buildAquarium() {

    val myAquarium = Aquarium()
    val smallAquarium = Aquarium(20, 15, 30)
    val aquarium2 = Aquarium(5)

    println(myAquarium.volume)
    println(smallAquarium.volume)
    println(aquarium2.volume)
}
