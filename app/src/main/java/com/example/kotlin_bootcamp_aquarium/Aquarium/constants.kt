package com.example.kotlin_bootcamp_aquarium.Aquarium

//only works in top level and in classes declared as object (or companion object)
const val rocks = 3 //value determined at compile time

val number = 5 //during program execution

object Constants {
    const val CONSTANT = "object constant"
}

val foo = Constants.CONSTANT