package eu.sirotin.kotlin.examples.safeoperators

fun main() {

    val inter  = runCatching{ "12".toInt()}.map{it + 24}
    println("inter=: $inter")

    val inter1   = runCatching{ Int.MAX_VALUE}.getOrNull()
    println("inter1=: $inter1")

    val inter2   = runCatching{ "12".toInt()}.getOrNull()
    println("inter2=: $inter2")

    val inter3   = runCatching{ "haha".toInt()}.fold(
        {it + 1},
        {"Error 21"}
    )
    println("inter3=: $inter3")

    val inter4   = runCatching{ "28".toInt()}.fold(
        {it + 1},
        {"Error 21"}
    )
    println("inter4=: $inter4")

    val inter5   = runCatching{ "zz".toInt()}.recover{
        println("In recover 1")
    }
    println("inter5=: $inter5")

    val inter51   = runCatching{ "zz".toInt()}.recover{
        println("In recover 51")
    }.getOrDefault("18".toInt())
    println("inter51=: $inter51")

    val inter6   = runCatching{ "19".toInt()}.recover{
        println("In recover 2")
    }.getOrNull()
    println("inter6=: $inter6")

    val x1 = runCatching { "29".toInt() }.fold (
        { it + 1 },
        { 111}
    )

    println("x1=: $x1")

    val x2 = runCatching { "cc".toInt() }.fold (
        { it + 1 },
        { println("In fold it=$it")
            "Error 299"}
    )

    println("x2=: $x2")

    val x3 = runCatching { "cc".toInt() }.onFailure { "Error: ${it.message}" }

    println("x3=: $x3")

    val x4 = runCatching { ("7".toInt()).toInt() }.onFailure { "Error: ${it.message}" }

    println("x4=: $x4")

    val x5 = runCatching { ("gg".toInt()).toInt() }.onFailure { processError(it) }

    println("x5=: $x5")



}

fun processError(err: Any)  {
    println("processError: $err")
}