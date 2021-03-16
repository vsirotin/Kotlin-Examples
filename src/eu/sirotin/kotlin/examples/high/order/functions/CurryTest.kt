package eu.sirotin.kotlin.examples.high.order.functions

fun main() {

    val curriedAdd: (Int) -> (Int) -> Int = { x -> { y: Int -> x + y }}

    val z = curriedAdd(3)
    val w = z(6)
    println("w = $w")

    val x = 4
    val y = 5

    val a = f1(x, y)
    println("a = $a")


    val h: (Int)->(Int)->Int = curry(::f1)
    val d = h(y)
    println("d = $d")
    val e = d(12)
    println("e = $e")

    val e1 = curry(::f1)(10)(14)
    println("e1 = $e1")

    val h1 = g2(7)
    println("h1 = $h1")
    val x1 = h1(2)
    println("x1 = $x1")

    val h2 = uncurry(::g2)
    println("h2 = $h2")
    val x2 = h2(7, 2)
    println("x2 = $x2")

    println(create.curried()("Thomas")(1888)("Berlin"))

}

private fun f1(x: Int, y: Int) : Int =x + y

private fun g2(x: Int) : (Int) -> String = {"RR$x"}
