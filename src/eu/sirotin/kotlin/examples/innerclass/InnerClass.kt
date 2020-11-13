package eu.sirotin.kotlin.examples.innerclass

fun main(args: Array<String>){
    A().logMe()
    println(A().getFullInformation())
    println(A.C().getFullName())

    // B().logMe() compiler error

}

class A {
    val label : String = "A"
    fun logMe() {
        println("I am A")
        B().logMe() //OK
        //println(B().getFullInformation()) //Compiler error
        println(B().getFullNamePublic()) //OK
    }

    fun getFullInformation(): String {
       return "I am A and contain: " + B().getFullNamePublic() + " and " + C().getFullName()
    }

    inner class B {
        fun logMe(){
            println(getFullName())
        }

        private fun getFullName() = "Iinner B in " + this@A.label

        fun getFullNamePublic() = "Inner B in " + this@A.label
    }

    class C {
        fun getFullName(): String {
            return "Internal C in " + A().label
        }
    }
}