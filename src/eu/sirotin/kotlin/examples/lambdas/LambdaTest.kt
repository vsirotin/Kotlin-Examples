package eu.sirotin.kotlin.examples.lambdas


fun main(args : Array<String>) {
    val people = listOf(Person("Adam", 3002), Person("Eva", 3001), Person("Donald Tramp", 70))
    println(people.sortedBy{it.name})
    println(people.minBy { it.age})
    println(people.maxBy(Person::age))
    println(people.maxBy({p: Person ->p.age}))
    run{println("Aha!")}

    val names = people.joinToString (separator = ", ", transform =  {p: Person -> p.name} )
    println(names)

    val names1 = people.joinToString("|") {p: Person -> p.name}
    println(names1)
}

data class Person(val name: String, val age: Int)
