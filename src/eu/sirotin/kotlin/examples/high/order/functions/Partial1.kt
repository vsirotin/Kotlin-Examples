package eu.sirotin.kotlin.examples.high.order.functions

fun main() {
    val x = 4
    val y = 5

    val a = f1(x, y)
    println("a = $a")



    val h: (Int)->Int = partial1(x, ::f1)
    val d = h(y)
    println("d = $d")

}

private fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C =
    { b -> f(a, b) }


private fun f1(x: Int, y: Int) : Int
    {return x + y}

