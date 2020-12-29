package eu.sirotin.kotlin.examples.high.order.functions

sealed class List<out A> {

    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }
        fun sum(ints: List<Int>): Int =
            when (ints) {
                is Nil -> 0
                is Cons -> ints.head + sum(ints.tail)
            }
        fun product(doubles: List<Double>): Double =
            when (doubles) {
                is Nil -> 1.0
                is Cons ->
                    if (doubles.head == 0.0) 0.0
                    else doubles.head * product(doubles.tail)
            }


        private fun <A, B> foldRight(xs: List<A>, z: B, f: (A, B) -> B): B =
            when (xs) {
                is Nil -> z
                is Cons -> f(xs.head, foldRight(xs.tail, z, f))
            }

        fun sum2(ints: List<Int>): Int =
            foldRight(ints, 0, { a, b -> a + b })
        fun product2(dbs: List<Double>): Double =
            foldRight(dbs, 1.0, { a, b -> a * b })
    }
}
object Nil : List<Nothing>()
data class Cons<out A>(
    val head: A,
    val tail: List<A>
) : List<A>()

fun main() {

    val ex1: List<Double> = Nil
    val ex2: List<Int> = Cons(1, Nil)
    val ex3: List<String> = Cons("a", Cons("b", Nil))
    println("ex1 = $ex1")
    println("ex2 = $ex2")
    println("ex3 = $ex3")

    val x1 = List.of(1, 2)
    println("x1 = $x1")

    val l1 = List.of(1, 4, 6)
    val x2 = List.sum(l1)
    println("x2 = $x2")

    val x3 = List.sum2(l1)
    println("x3 = $x3")
}
