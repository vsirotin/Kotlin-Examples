package eu.sirotin.kotlin.examples.high.order.functions


fun <A, B, C> curry(f: (A, B) -> C) : (A) -> ((B) -> C)  =
    { a -> {b -> f(a,b)} }



fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    { a: A, b: B -> f(a)(b) }


fun <A, B, C, D> ((A, B, C) -> D).curried(): (A)->(B)->(C)->(D) =
        {a: A-> {b:B -> {c: C->this(a, b, c) }}}