package eu.sirotin.kotlin.examples.high.order.functions

fun main() {
    val x = 4

    val a = g1(x)
    println("a = $a")

    val b = f1(a)
    println("b= $b")

    val c = f1(g1(x))
    println("c = $c")

    val h: (Int)->Int = compose(::f1, ::g1)
    val d = h(x)
    println("d = $d")

}

private fun<A, B, C> compose(f: (B)-> C, g: (A)->B) : (A) -> (C) =
    {x: A -> f(g(x))}

private fun f1(x: Int) : Int
    {return x + 1}

private fun g1(x: Int) : Int
    {return x * 3}