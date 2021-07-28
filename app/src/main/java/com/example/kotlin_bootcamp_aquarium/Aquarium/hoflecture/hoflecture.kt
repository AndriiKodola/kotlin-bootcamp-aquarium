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

// inline tells the compiler to change the code to replace the lambda with instructions from the lambda
// avoid load on resources, by not creating a lambda object every time the lambda is called
// inlining larger functions increase the code size, it's best to use in for small ones
inline fun myWith(name: String, block: String.() -> Unit) {

    name.block()
}
