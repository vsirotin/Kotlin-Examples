package eu.sirotin.kotlin.examples.dsl

class Res<I>(val x: I){

    fun<S> step(f: (I)-> Res<S>): Res<S>{
        return f(x)
    }


}
fun f1(s: String): Res<Int> = Res(s.length)
fun f2(i: Int): Res<Boolean> = Res(i/2 == 0)
fun f3(b: Boolean): Res<Double> = Res(if(b)2.0 else 3.0)


val res =
    Res<String>("ab")
    .step(::f1)
    .step(::f2)
    .step(::f3)


fun main(){
    println(res.x)
}

//Supplementary test classes
class I1{}
class S1{}
class E1{}

class S2{}
class E2{}

fun f1(input: I1): Result<S1, E1> = Result<S1, E1>()
fun e1(){}
fun e2(){}


