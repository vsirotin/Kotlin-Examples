package eu.sirotin.kotlin.examples.safeoperators

fun main(args: Array<String>) {
    printUpper("gFq")
    printUpper(null)

    val boss = Employeee("Boss", null)
    val noBoss = Employeee("No Boss", boss)

    println(chefName(noBoss))
    println(chefName(boss))

    println(strlenSafe("rewq"))
    println(strlenSafe(null))

    printEmployeeeData(noBoss)
    printEmployeeeData(boss)
}

fun printUpper(s : String?) {
    val s1 : String? = s?.toUpperCase()
    println(s1)
}

class Employeee(val name : String, val chef : Employeee?)

fun chefName(x : Employeee) : String? = x.chef?.name

fun printEmployeeeData(x : Employeee)  {
    println(x.name)
    val hisChef: Employeee = x.chef
        ?: throw IllegalArgumentException("Chef not set!")
    with(hisChef){
        println("Chef name: $name")
    }
}

fun strlenSafe(s: String?) : Int = s?.length ?: 0