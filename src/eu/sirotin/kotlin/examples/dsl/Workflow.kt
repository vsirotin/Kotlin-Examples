package eu.sirotin.kotlin.examples.dsl


typealias Step<I, S, E> = (I)->Result<S, E>
class Workflow<I, S, E> {

    val chain: List<Step<Any, Any, Any>> = emptyList()
}

class Result<S,E>{
    fun success(): E? = null

    fun isSuccess(): Boolean = true
}

interface IError{}





fun main(){
    val workflow = Workflow<I11, S11, E11>()
    var input: Any = 1

    workflow.chain.forEach {
        if(input !is IError){
            val res: Result<Any, Any> = it(input)
            if(!res.isSuccess())input= res.success()!!
        }

    }
}

class I11{}
class S11{}
class E11{}

