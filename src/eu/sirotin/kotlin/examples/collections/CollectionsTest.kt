package eu.sirotin.kotlin.examples.collections

fun main(args: Array<String>){
    val intNumbers = setOf(3,14,15,92,7)
    println(intNumbers)
    println(intNumbers.min())

    val intNumbers2 = listOf(3,4,5)
    println("Formatted list 1: " + convertToString(intNumbers2, "; ", "(", ")" ))
    println("Formatted list 2: " + convertToString(intNumbers2, prefix = "{", separator = ", ", postfix = "}"))
    println("Formatted list 3: " + convertToString(intNumbers2))
    println("Formatted list 4: " + convertToString(intNumbers2, separator = "|"))
    println("Formatted list 5: " + convertToString(intNumbers2, prefix = "{", postfix = "}"))
}

fun <T> convertToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "[",
    postfix: String = "]"
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()){
        if(index > 0)result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}