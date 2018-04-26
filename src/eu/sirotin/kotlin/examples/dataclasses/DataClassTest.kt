package eu.sirotin.kotlin.examples.dataclasses

fun main(args : Array<String>){
    val agent1 = Agent("Bond", "007")
    val agent2 = Agent("Bond", "007")
    agent2.age = 50
    println("agent1=$agent1")
    println("agent2=$agent2")
    println("== : ${agent1 == agent2}")
    println("=== : ${agent1 === agent2}")
}

data class Agent(val name: String, val id: String) {
    var age  = 30
}