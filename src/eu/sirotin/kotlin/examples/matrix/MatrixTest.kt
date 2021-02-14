package eu.sirotin.kotlin.examples.matrix


fun main() {
    val m1 = Matrix<Double>(20,20)
    var v1 = m1.get(10,11)
    println("v1=$v1")
    m1.set(10,11, 23.1)
    v1 = m1.get(10,11)
    println("v1=$v1")
}
