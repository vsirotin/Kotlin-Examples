package eu.sirotin.kotlin.examples.operators

fun main(){
    println("AA")
    V{println("In v x=${this.x}")}
}

class V private constructor() {
    val x =14
    companion object {
        operator fun invoke(s: V.() -> Unit): V =
                V().apply(s)
    }
}

