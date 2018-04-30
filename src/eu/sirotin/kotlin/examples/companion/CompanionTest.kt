package eu.sirotin.kotlin.examples.companion

fun main(args: Array<String>){
    println("Result of call craeteUnregisratedUser: ${User.createUnregisteredUser("Ivan").loginName}")
    println("Result of call craeteRegisratedUser: ${User.createRegisteredUser("ivan@pupkin.com").loginName}")
    val person = Person.createFromString("Donald,Tramp")
    println("Result of createFromString: ${person.firstName} ${person.secondName}" )
}

interface IUser {
    val loginName: String
}

class User private constructor(private val name : String) : IUser {
    override val loginName: String
        get() = this.name
    companion object {
        fun createUnregisteredUser (name : String) = User(name)
        fun createRegisteredUser (email : String) = User(email.substringBefore('@'))
    }
}

class Person(val firstName: String, val secondName: String){
    companion object  //Empty object
}

fun Person.Companion.createFromString(entry: String) : Person {
    return Person(entry.substringBefore(",").trim(), entry.substringAfter(",").trim())
}