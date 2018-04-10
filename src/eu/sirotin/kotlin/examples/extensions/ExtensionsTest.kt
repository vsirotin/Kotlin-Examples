package eu.sirotin.kotlin.examples.extensions

import eu.sirotin.kotlin.examples.extensions.lastLetter as last
fun main(args: Array<String>){
    println("Sommer".lastChar())
    println("Ura!".last())
    println("Step".last())
    println("Hi".lastChar)

    val eh = StringBuilder("Eh")
    println("Object before set: $eh")
    eh.lastChar = 'x'

    println("Object after set: $eh")

    val strings : List<String> = listOf("One", "Two", "Three")
    println("Last element:" + strings.last())
}