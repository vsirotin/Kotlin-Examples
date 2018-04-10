package eu.sirotin.kotlin.examples.extensions

fun String.lastChar() : Char = this.get(this.length - 1)

fun String.lastLetter() : Char = get(length - 1)

val String.lastChar : Char
    get() = get(length - 1)

var StringBuilder.lastChar : Char
    get() = get(length - 1)
    set(value){this.setCharAt(length - 1, value)}