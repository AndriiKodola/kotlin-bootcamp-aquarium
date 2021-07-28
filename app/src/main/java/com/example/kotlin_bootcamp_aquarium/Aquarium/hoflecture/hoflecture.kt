package com.example.kotlin_bootcamp_aquarium.Aquarium.hoflecture

data class Fish (var name: String)

fun main() {
    fishExample()
}

fun fishExample() {
    val fish = Fish("splashy")

    with (fish.name) {
        println(capitalize())
    }

    myWith (fish.name) {
        println(capitalize())
    }

    println(fish.run {name})

    println(fish.apply {  })

    val fish2 = Fish("splashy").apply {name = "Splashy" }
    println(fish2.name)

    println(fish.let{it.name.capitalize() }
        .let{it + "fish"}
        .let{it.length}
        .let{it + 31})
}

fun myWith(name: String, block: String.() -> Unit) {

    name.block()
}
