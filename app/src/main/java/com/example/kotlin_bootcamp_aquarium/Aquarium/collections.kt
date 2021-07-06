package com.example.kotlin_bootcamp_aquarium.Aquarium

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun doCollections() {
    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")

    println(symptoms)

    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    println(symptoms)

    println(symptoms.contains("red"))
    println(symptoms.contains("red spots"))

    println(symptoms.subList(4, symptoms.size))

    println(listOf(1, 2, 3).sum())
    println(listOf("a", "b", "cc").sumBy { it.length })

    /** --------------------- */

    val cures = mapOf("white spots" to "Ich", "red spots" to "hole disease")

    println(cures.get("white spots"))
    println(cures["red spots"])

    println(cures.getOrDefault("bloating", "sorry I don't know"))
    println(cures.getOrElse("bloating") { "Requesting external source for a cure" })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")

    // Mutable collections might be useful in threaded environment, where multiple threads might want to toch same data
}