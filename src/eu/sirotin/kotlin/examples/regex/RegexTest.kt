package eu.sirotin.kotlin.examples.regex

fun main(args: Array<String>){
    println("0345-264 221".split("-", " "))
    parseUrl("http://www.sirotin.eu/blog")

    //triple quotes
    val expectedAsString = """  _My
                                _new
                                _thing"""
    println(expectedAsString.trimMargin("_"))
}

fun parseUrl(url : String){
    val http = url.substringBefore(":")
    val domain = url.substringAfter("//")
    val part = url.substringAfterLast("/")
    println("type=$http domain= $domain part=$part")
}