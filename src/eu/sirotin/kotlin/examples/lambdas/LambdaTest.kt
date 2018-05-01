package eu.sirotin.kotlin.examples.lambdas


fun main(args : Array<String>) {
    val people = listOf(Person("Adam", 3002), Person("Eva", 3001), Person("Donald Tramp", 70))
    println(people.sortedBy{it.name})
    println(people.minBy { it.age})
    println(people.maxBy(Person::age))
}

data class Person(val name: String, val age: Int)
