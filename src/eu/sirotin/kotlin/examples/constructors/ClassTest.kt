package eu.sirotin.kotlin.examples.constructors

fun main(args: Array<String>){
    println("Num(3) = " + Num(3).value)
    println("Num default = " + Num().value)
    println("Num100(5) = " + Num100(5).value)
}

open class Num constructor(defaultVal : Int = 25){
    var value : Int
    init {
        value = defaultVal
        println("In Num init")
    }
}

class Num100(defaultVal: Int) : Num(defaultVal){
    init {
        value += 100
        println("In Num100 init")
    }
}