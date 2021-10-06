package eu.sirotin.kotlin.examples.dsl



fun main() {
    val id = "ID"
//apply---------
    val user = User().apply {
        add("id", id)
    }
    println(user)

//also------------
    user.also {println("In also it=$it")  }


//run ------------
    val map = mapOf("key1" to 2, "key2" to 22)

    val logItem = map.run {
        val count = size
        val keys = keys
        val values = values
        "Map $this has $count keys $keys and values $values"
    }
    println(logItem)

//let--------------
    var mapProperty : Map<String, Int>? = mapOf("keyFirst" to 0, "keyLast" to 200)

    fun toLogString() : String {
        return mapProperty?.let {
            val count = it.size
            val keys = it.keys
            val values = it.values
            "Map $it has $count keys $keys and values $values"
        } ?: "Map is empty"
    }

    println(toLogString())
    mapProperty = null

    println(toLogString())
}

class User {
    private val param : MutableMap<String, String> = mutableMapOf()
    fun add(key: String, value: String) {
        this.param[key] = value
    }
}