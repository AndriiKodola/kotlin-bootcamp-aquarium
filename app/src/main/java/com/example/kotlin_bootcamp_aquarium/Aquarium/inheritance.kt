package com.example.kotlin_bootcamp_aquarium.Aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

//here we've overriden eat fun to implement FishAction and
//class Plecostomus: FishAction,
//        FishColor by GoldColor {//implement interface FishColor by deferring all calls to the object GoldColor (composition: using instance of another class, not inheriting from it)
//    override fun eat() {
//        println("eat algae")
//    }
//}

class Plecostomus(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("a log of algae"),
        FishColor by fishColor //same as before, but class instance is only used as default value, we can pass other instance to a Plecostomos instance if we like


object GoldColor: FishColor {//delegating interface to an object
    override val color = "gold"
}

object RedColor: FishColor {//delegating interface to an object
override val color = "red"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}
