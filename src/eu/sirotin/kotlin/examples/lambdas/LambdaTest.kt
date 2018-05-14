package eu.sirotin.kotlin.examples.lambdas


fun main(args : Array<String>) {
    val people = listOf(Person("Adam", 3002), Person("Eva", 3001), Person("Donald Tramp", 70))
    println(people.sortedBy{it.name})
    println(people.minBy { it.age})
    println(people.maxBy(Person::age))
    println(people.maxBy({p: Person ->p.age}))
    println(people.maxBy({it.age}))
    run{println("Aha!")}
    println(sum(2, 4))

    val names = people.joinToString (separator = ", ", transform =  {p: Person -> p.name} )
    println(names)

    val names1 = people.joinToString("|") {p: Person -> p.name}
    println(names1)
    println(z)
    println(adder)
    println(z)
    z =20
    println(adder)
    println(z)

    println("Using with...")
    with(Arithmetics(11)){
        plus(3)
        min(2)
        println(this.result)
    }

    println("Using apply...")
    Arithmetics(20).apply{
        plus(3)
        min(2)
        println(this.result)
    }
}

data class Person(val name: String, val age: Int)

val sum ={x : Int, y : Int ->
    print("$x + $y = ")
    x + y
}

var z : Int = 12
val adder: () -> Int = {z + 3 }

class Arithmetics (var result: Int) {
    fun plus(x: Int) = {
        this.result = this.result + x
    }


    fun min(x: Int) = {
        this.result = this.result + x
    }


}
