package eu.sirotin.kotlin.examples.generics

fun main(args: Array<String>){
    val lst = listOf<String>("a", "bb", "asr", "cd")
    val res = copyWhenGreater(lst, "b")
    println(res)

    val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)


    val stringToSomething = somePair.asPairOf<String, Any>()
    val stringToInt = somePair.asPairOf<String, Int>()
    val stringToList = somePair.asPairOf<String, List<*>>()
    val stringToStringList = somePair.asPairOf<String, List<String>>()

    println(stringToStringList?.second)
}

//------------- out --------------------------------------
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

interface Source1<T> {
    fun nextT(): T
}

fun demo1(strs: Source1<String>) {
    //val objects: Source1<Any> = strs // Compiler error

}

//---------- in --------------------------------------
interface DoubleHolder<in T> {
    operator fun plus(other: T): Double
}

fun demo2(x: DoubleHolder<Number>) {
    x.plus(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type DoubleHolder
    val y: DoubleHolder<Double> = x // OK!
}

//---------------where--------------------------------
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

//------------reified-------------------------------
inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}