package eu.sirotin.kotlin.examples.kotlin.tests

import eu.sirotin.kotlin.examples.java.Customer
import eu.sirotin.kotlin.examples.java.KotlinCaller

/**
 * @author vsirotin
 */
fun main(args: Array<String>){
    val customer = Customer("Jonson")
    println("Customer name=${customer.name}")

    val kotlinCaller = KotlinCaller()
    println(kotlinCaller.callStringsKt())
}