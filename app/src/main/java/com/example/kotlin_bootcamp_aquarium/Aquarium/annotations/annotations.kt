package com.example.kotlin_bootcamp_aquarium.Aquarium.annotations

import kotlin.reflect.full.findAnnotation

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize () {}

    @get:OnGet
    val isGrowing = true

    @set:OnSet
    var needsFood = false

}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflection() {
    val classObj = Plant::class

    for (method in classObj.members) {
        println(method.name)
    }

    for (annotation in classObj.annotations) {
        println(annotation.annotationClass)
    }

    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated?.apply {
        println("Found a plant annotation")
    }
}

fun main() {
    reflection()
}
