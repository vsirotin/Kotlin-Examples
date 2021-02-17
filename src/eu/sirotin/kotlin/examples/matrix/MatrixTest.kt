package eu.sirotin.kotlin.examples.matrix


fun main() {
    val m1 = Matrix<Double>(20,20)
    var v1 = m1[10,11]
    println("v1=$v1") //null
    m1[10,11] = 23.1
    v1 = m1[10,11]
    println("v1=$v1") //23.1

    val m2 = matrixOf<Int>(
        rowOf(1, 2, 3),
        rowOf(4,5,6)
    )

    var v2 = m2[0,2]
    println("v2=$v2") //3

    m2[0,2] = 10
    v2 = m2[0,2]
    println("v2=$v2") //10


}
