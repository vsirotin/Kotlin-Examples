package eu.sirotin.kotlin.examples.high.order.functions

fun main() {

    //Direct compose
    val x1 = 4

    val a = g1(x1)
    println("a = $a")

    val b = f1(a)
    println("b= $b")

    val c = f1(g1(x1))
    println("c = $c")

    val h: (Int)->Int = compose(::f1, ::g1)
    val d = h(x1)
    println("d = $d")

    val f3: (Int)->Int = {x: Int -> x * 3}
    val f4: (Int)->Int = {x: Int->x + 5}
    val h1: (Int) -> Int = f3 compose1 f4
    val d1 = h1(2)

    println("d1 = $d1")

    //Indirect compose
    val p1 = Person("Max", 1986)

    printUserStrong(p1)

    printUserStrong1(p1)

    printUserStrong2(p1)

    printUserStrong3(p1)

    //Pipe (do in my case)
    printReport(reportStrong(calculateStrong((calculateAge(p1)))))
    //The same as:

    p1 pipe calculateAge pipe calculateStrong pipe reportStrong pipe printReport

}

private fun f1(x: Int) : Int = x + 1

private fun g1(x: Int) : Int = x * 3

data class Person(val name: String, val yearOfBorn: Int)
val calculateAge: (Person) -> Int ={person->2021 - person.yearOfBorn}
val calculateAge1: (Person, Int) -> Int ={person, currentYear -> currentYear - person.yearOfBorn}
val calculateStrong: (Int) -> Boolean = {x -> x > 21}
val reportStrong: (Boolean) -> String = {b->"Strong is $b"}
val reportStrong1: (String, Boolean) -> String = {s, b->"$s $b"}
val printReport: (String) -> Unit = {s->println(s)}


val printUserStrong : (Person) -> Unit = calculateAge andThen calculateStrong andThen reportStrong andThen printReport

val printUserStrong1 : (Person) -> Unit = calculateAge andThen calculateStrong andThen reportStrong1.fixFirstArgument("Ha! Ha! Strong 1 is") andThen printReport

val printUserStrong2 : (Person) -> Unit = calculateAge andThen calculateStrong andThen reportStrong1(p1 ="Oh! Uh! Strong 2 is") andThen printReport

val printUserStrong3 : (Person) -> Unit = calculateAge1.fixSecondArgument(2021) andThen calculateStrong andThen reportStrong1.fixFirstArgument("Ha! Ha! Strong 3 is") andThen printReport