package eu.sirotin.kotlin.examples.dsl

val source: String = """
DSL:

We say:
<#Model/Use Cases Model/Actors/+>{
Hello <.Name>!
}
"""


fun main() {
    pump(0,15)
    process("Model/Use Cases Model/Actors/*").forEach {
        pump(50,56)
        insert(it, ".Name")
        pump(63,65)
    }

}

fun process(statement: String): List<String> {
    return listOf("One", "Two", "Three")
}

fun pump(start: Int, end: Int) : Unit {
    print(source.substring(start, end))
}

fun insert(context: String, selection: String): Unit {
    print(context)
}
