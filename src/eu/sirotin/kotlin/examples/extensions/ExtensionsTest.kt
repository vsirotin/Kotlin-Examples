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

    //User extension
    val user1 = User("354", "John Simpson", "Somewhere")
    saveUser(user1)

    val user2 = User("", "", "")
    saveUser(user2)
}

fun saveUser(user : User){
    user.validate()
    println("User ${user.id} saved!")
}

fun User.validate(){
    if(id.isEmpty())throw IllegalArgumentException("id must be not empty!")
}