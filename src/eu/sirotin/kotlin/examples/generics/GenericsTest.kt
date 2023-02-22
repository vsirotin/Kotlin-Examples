package eu.sirotin.kotlin.examples.generics

fun main(){
    val lst = listOf<String>("a", "bb", "asr", "cd")
    val res = copyWhenGreater(lst, "b")
    println("copyWhenGreater: res=$res")

    val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)


    val stringToSomething = somePair.asPairOf<String, Any>()
    println("second in stringToSomething=${stringToSomething?.second}")

    val stringToInt = somePair.asPairOf<String, Int>()
    println("second in stringToInt=${stringToInt?.second}")

    val stringToList = somePair.asPairOf<String, List<*>>()
    println("second in stringToList=${stringToList?.second}")

    val stringToStringList = somePair.asPairOf<String, List<String>>()
    println("second in stringToStringList=${stringToStringList?.second}")
}
//------------- out --------------------------------------
interface Source<out T> {
    fun nextT(): T
}

fun demo(srs: Source<String>) {
    val objects: Source<Any> = srs // This is OK, since T is an out-parameter
    // ...
}

interface Source1<T> {
    fun nextT(): T
}

fun demo1(srs: Source1<String>) {
    //val objects: Source1<Any> = srs // Compiler error

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