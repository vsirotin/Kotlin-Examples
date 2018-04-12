package eu.sirotin.kotlin.examples.pairs

fun main(args: Array<String>) {
    val map = mapOf(1 to "raz", 2 to "dva", 10 to "desat")
    println("map=" + map)

    val(number, name) = 1 to "eins"
    println("number=$number name=$name")

    //Using monad

    val m1 = 2.monad("tri")
    println("m1=$m1")

    val m2 = 4 monad 5
    println("m2=$m2")

}

infix fun Any.monad(other : Any) = Pair(this, other)
