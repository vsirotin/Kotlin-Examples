package eu.sirotin.kotlin.examples.arrays

fun main(args: Array<String>) {
    val arr = Array<String> (5) {i->("A" + i)}
    arr[1] = "VVV"
    println(arr.joinToString (", "))

    val sqrs = IntArray(4){i->i*i}
    println(sqrs.joinToString (", "))

    sqrs.forEachIndexed{index, element -> println("square of $index = $element")}

    val numbers = listOf<Int?>(1, null, 12, 3)
    listSummary(numbers)
}

fun listSummary(lst: List<Int?>)  {
    val nonNuls = lst.filterNotNull()
    println("Sum: ${nonNuls.sum()}")
}