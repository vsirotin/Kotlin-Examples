package eu.sirotin.kotlin.examples.operators

import java.time.LocalDate

data class Pixel(val x : Int, val y : Int){
    operator fun plus(other : Pixel) : Pixel {
        return Pixel(x + other.x, y + other.y)
    }
}

data class Rectangle(val upperLeft: Pixel, val lowerRight: Pixel)

operator fun Rectangle.contains(p : Pixel) : Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

fun main(args: Array<String>){
    val p1 = Pixel(10, 20)
    val p2 = Pixel(21, 33)
    println(p1 + p2)
    println(p1 - p2)
    println(p1*5 - p2)

    println(p1[1])

    val r = Rectangle(p1, p2)
    println(Pixel(15,25) in r)
    println(Pixel(25,25) in r)

    println('s'*12)

    val list = arrayListOf(1, 2)
    list +=3
    println(list)

    val list1 = list + listOf(100, 101)

    println(list1)

    val firstDay = LocalDate.now()
    val vacation = firstDay..firstDay.plusDays(17)
    println(firstDay.plusWeeks(1) in vacation)

    (0..12).forEach{println(it)}

    val (x, y) = p1

    println("x=$x y=$y")
}

operator fun Pixel.minus(other : Pixel) : Pixel {
    return Pixel(x - other.x, y - other.y)
}

operator fun Pixel.times(scala : Int) : Pixel {
    return Pixel(x * scala, y * scala)
}

operator fun Pixel.get(index : Int) : Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid index $index")
    }
}

operator fun Char.times(count: Int) : String {
    return toString().repeat(count)
}