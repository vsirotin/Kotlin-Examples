package eu.sirotin.kotlin.examples.smartenesse

/**
 * Sometimes you have functions with N parameters and sequence of its call with similar subset of parameters.
 * In Kotlin you can solve this problem in elegant way as shows examples below.
 */
fun main(){
    //So will be coded in Java convention
    println(greetingAsJava("Good Morning,", "Alice"))
    println(greetingAsJava("Good Morning,", "Bob"))
    println(greetingAsJava("Bye,", "Alice"))
    println(greetingAsJava("Bye,", "Bob"))

    //So can be coded in Kotlin
    val goodMorning = greetingKotlin("Good Morning,")
    val bye = greetingKotlin("Bye,")

    println(goodMorning("Alice"))
    println(goodMorning("Bob"))
    println(bye("Alice"))
    println(bye("Bob"))

    //If you can't reproduce a behaviour of existing function, you can develop its wrapper
    val goodMorningW = greetingWrapper("Good Morning,")
    val byeW = greetingWrapper("Bye,")

    println(goodMorningW("Alice"))
    println(goodMorningW("Bob"))
    println(byeW("Alice"))
    println(byeW("Bob"))

}

fun greetingAsJava(prefix: String, name: String): String = "$prefix $name!"

fun greetingKotlin(prefix: String): (String)-> String {
    return {"$prefix $it!"}
}

fun greetingWrapper(prefix: String): (String)-> String {
    return {greetingAsJava(prefix, it)}
}