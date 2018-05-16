package eu.sirotin.kotlin.examples.safeoperators

fun main(args: Array<String>) {
    printUpper("gFq")
    printUpper(null)

    val boss = Employee("Boss", null)
    val noBoss = Employee("No Boss", boss)
    val noBoss1 = Employee("No Boss", null)

    println(chefName(noBoss))
    println(chefName(boss))

    var s1 : String? = "SSSS"
    s1?.let { printString(it) }
    s1  = null

    s1?.let { printString(it) }

    println(noBoss.equals(noBoss))
    println(noBoss.equals(noBoss1))
    println(noBoss.equals(boss))
    println(boss.equals(noBoss))
    println(boss.equals(boss))

    println(strLenSafe("rewq"))
    println(strLenSafe(null))

    printEmployeeData(noBoss)
    printEmployeeData(boss)
}

fun printUpper(s : String?) {
    val s1 : String? = s?.toUpperCase()
    println(s1)
}

fun printString(s: Any) {
    println(s)
}

class Employee(val name : String, val chef : Employee?){
    override fun equals(other: Any?): Boolean {
        val e1 = other as? Employee ?: return false
        if (!(name ==e1.name)) return false
        chef ?: return (e1.chef == null)
        return chef == e1.chef
    }

    override fun hashCode(): Int {
        return super.hashCode() + 12
    }
}

fun chefName(x : Employee) : String? = x.chef?.name

fun printEmployeeData(x : Employee)  {
    println(x.name)
    val hisChef: Employee = x.chef
        ?: throw IllegalArgumentException("Chef not set!")
    with(hisChef){
        println("Chef name: $name")
    }
}

fun strLenSafe(s: String?) : Int = s?.length ?: 0