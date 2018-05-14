package eu.sirotin.kotlin.examples.nullable

fun main(args: Array<String>) {
    val s: String? = null
    println("length of null = ${strLen(null)}")
    println("length of AHA = " + strLen("AHA"))
    println("length of s = ${strLen(s)}")

    //Compiler error strLen1(s)
}

fun strLen(s: String?) : Int =
        if (s == null) 0 else s.length

fun strLen1(s: String) : Int = s.length