package eu.sirotin.kotlin.examples.high.order.functions

fun<A, B, C> compose(f: (B)-> C, g: (A)->B) : (A) -> C =
    {x: A -> f(g(x))}

infix fun <A, B, C> ((B)->C).compose1(f: (A)->B): (A)->C = {a: A ->this(f(a))}


infix fun <A, B, C> ((A)->B).andThen(g: (B)->C): (A) -> C = {a:A -> g(this(a))}
fun <A, B, C> ((A, B) -> C).fixFirstArgument(a: A): (B) -> C = {b: B -> this(a,b)}

fun <A, B, C> ((A, B) -> C).fixSecondArgument(b: B): (A) -> C = {a: A -> this(a,b)}

operator fun <A, B, C> ((A, B) -> C).invoke(p1: A): (B) -> C = {b: B -> this(p1,b)}

infix fun<A, B> A.pipe(f: (A) ->B): B = f(this)
