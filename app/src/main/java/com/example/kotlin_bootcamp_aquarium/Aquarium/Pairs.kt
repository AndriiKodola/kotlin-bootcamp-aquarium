package com.example.kotlin_bootcamp_aquarium.Aquarium

fun main(args: Array<String>) {

    val equipment = "fishnet" to "catching fish"

    println(equipment.first)
    println(equipment.second)

    val equipment2 = "fishnet" to "catching fish" to "of big size" to "and strong"
    println(equipment2)
    println(equipment2.first)
    println(equipment2.first.first)

    val equipment3 = ("fishnet" to "catching fish") to ("of big size" to "and strong")
    println(equipment3)

    val (tool, use) = equipment //pair destructuring
    println("The tool $tool is used for $use")

    println(equipment.toString())
    println(equipment.toList())

    for ((f, s) in equipment3.toList()) {
        println(f)
        println(s)
    }

    val mushroom = Triple("brown", "poisonous", listOf("family", "kind"))
    val (color, eaten, charachteristics) = mushroom
}