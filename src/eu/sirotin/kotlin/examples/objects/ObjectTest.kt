package eu.sirotin.kotlin.examples.objects

import java.io.File

fun main(args: Array<String>){
    println("counter =  ${++Counter.coint}")
    val files = listOf(File("./z"), File("./a"), File("first"))
    println(files.sortedWith(FilePathComparator))
}

object Counter {
    var coint = 0
}

object FilePathComparator : Comparator<File> {
    override fun compare(f1: File, f2: File): Int {
        return f1.path.compareTo(f2.path, ignoreCase = true)
    }
}