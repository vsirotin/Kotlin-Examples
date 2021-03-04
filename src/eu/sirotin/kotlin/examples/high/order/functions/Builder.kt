package eu.sirotin.kotlin.examples.high.order.functions

data class User(val name: String, val yearOfBorn: Int, val bornIn: String)

val create: (String, Int, String) -> User = ::User
val builder: (String)->(Int)->(String)->User = {name: String -> {yearOfBorn: Int -> {bornIn: String -> User(name, yearOfBorn, bornIn)}}}

fun main(){
    println(create("Tom", 2001, "Hof"))
    println(builder("Max")(2002)("Stadt"))
}