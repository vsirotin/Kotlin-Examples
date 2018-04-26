package eu.sirotin.kotlin.examples.properties

fun main(args: Array<String>) {
    println(NormalUser("ich@bin.com").loginName)
    val holder = Holder("AAA")
    println("value=${holder.value}")
    holder.value = "BBB"
    println("value=${holder.value}")
    println("name=${holder.name}")
}

interface EmailUser {
    val email : String
    val loginName : String
        get() = email.substringBefore('@')
}

class NormalUser(override val email: String) : EmailUser

class Holder(val name : String) {
    var value = "Unset"
    set(value ) {
        println("Value changed from $field to $value")
        field = value
    }
}