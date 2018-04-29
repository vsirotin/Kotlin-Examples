package eu.sirotin.kotlin.examples.dataclasses

fun main(args : Array<String>){
    val agent1 = Agent("Bond", "007")
    val agent2 = Agent("Bond", "007")
    agent2.age = 50
    println("agent1=$agent1")
    println("agent2=$agent2, age=${agent2.age}")
    println("== : ${agent1 == agent2}")
    println("=== : ${agent1 === agent2}")

    val agent3 = agent2.copy()
    println("agent3=$agent3, age=${agent3.age}")

    val agent4 = agent2.copy(id="008")
    println("agent4=$agent4")
}

data class Agent(val name: String, val id: String) {
    var age  = 30
}