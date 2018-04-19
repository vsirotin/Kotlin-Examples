package eu.sirotin.kotlin.examples.sealedclass

fun main(args: Array<String>){
    println("2 + 3 = " + eval(Expr.Plus(2, 3)))
    println("2 - 3 = " + eval(Expr.Minus(2, 3)))
}

sealed class Expr {
    class Plus(val x1 : Int, val x2 : Int) : Expr()
    class Minus(val x1 : Int, val x2 : Int) : Expr()
    class Multiply(val x1 : Int, val x2 : Int) : Expr()
}

fun eval (e: Expr) : Int = 
        when(e) {
            is Expr.Plus -> e.x1 + e.x2
            is Expr.Minus -> e.x1 - e.x2
            is Expr.Multiply -> e.x1 * e.x2
        }