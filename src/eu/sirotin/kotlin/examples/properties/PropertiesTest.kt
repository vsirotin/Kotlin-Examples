package eu.sirotin.kotlin.examples.properties

fun main(args: Array<String>) {
    println(NormalUser("ich@bin.com").loginName)
}

interface EmailUser {
    val email : String
    val loginName : String
        get() = email.substringBefore('@')
}

class NormalUser(override val email: String) : EmailUser