package eu.sirotin.kotlin.examples.kotlin.tests

import eu.sirotin.kotlin.examples.global.formatString

/**
 * @author vsirotin
 */
fun main(args: Array<String>){
    val intNumbers = setOf(3,14,15,92,7)
    println(intNumbers)
    println(intNumbers.min())

    val intNumbers2 = listOf(3,4,5)
    println("Formatted list 1: " + formatString(intNumbers2, "; ", "(", ")" ))
    println("Formatted list 2: " + formatString(intNumbers2, prefix = "{", separator = ", ", postfix = "}"))
    println("Formatted list 3: " + formatString(intNumbers2))
    println("Formatted list 4: " + formatString(intNumbers2, separator = "|"))
    println("Formatted list 5: " + formatString(intNumbers2, prefix = "{", postfix = "}"))
}