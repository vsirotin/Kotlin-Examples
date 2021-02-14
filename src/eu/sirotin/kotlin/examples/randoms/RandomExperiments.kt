package eu.sirotin.kotlin.examples.randoms

import kotlin.random.Random

fun main() {
    for (i in 3..20){
        for (j in 3..i){
            val res = doSerie(i, j)
            println(res)
        }
    }

}

fun doSerie(initPlayer1: Int,
            initPlayer2: Int,
            serieLength: Int = 1000
): PlaysSeriesResult {
    var minLength = Int.MAX_VALUE
    var maxLength = Int.MIN_VALUE
    var sumLength = 0
    var countWinForFirstPlayer = 0
    for(i in 0.. serieLength){
        val state = doPlay(PlayState(initPlayer1, initPlayer2))

        if(minLength > state.stepNumber)minLength = state.stepNumber
        if(maxLength < state.stepNumber)maxLength = state.stepNumber
        sumLength += state.stepNumber
        if(state.statePlayer1 > 0)countWinForFirstPlayer++
    }
    return PlaysSeriesResult(
            initPlayer1,
            initPlayer2,
            minLength,
            maxLength,
            sumLength/(serieLength + 0.0),
    countWinForFirstPlayer/(serieLength + 0.0))
}

fun doPlay(initState : PlayState):PlayState{
    var currentState = initState
    for (i in 0..1000) {
        currentState = doStep(currentState)
        if (currentState.isFinished) break
    }
    return currentState

}

fun doStep(state: PlayState): PlayState {
    val check = Random.nextBoolean()
    if(check)return PlayState(state.initPlayer1, state.initPlayer2, state.statePlayer1 + 1, state.statePlayer2 -1, state.stepNumber + 1 )

    return PlayState(state.initPlayer1, state.initPlayer2, state.statePlayer1 -1, state.statePlayer2 + 1, state.stepNumber + 1 )
}

data class PlayState(
        val initPlayer1: Int,
        val initPlayer2: Int,
        val statePlayer1: Int = initPlayer1,
        val statePlayer2: Int = initPlayer2,
        val stepNumber: Int = 0){

    val isFinished :Boolean = ((statePlayer1 <= 0) || (statePlayer2 <= 0))
    override fun toString(): String {
        return "PlayState(initPlayer1=$initPlayer1, statePlayer1=$statePlayer1, initPlayer2=$initPlayer2, statePlayer2=$statePlayer2, stepNumber=$stepNumber, isFinisched=$isFinished)"
    }
}

data class PlaysSeriesResult(
        val initPlayer1: Int,
        val initPlayer2: Int,
        val minLength: Int,
        val maxLength: Int,
        val averageLength: Double,
        val winProbabilityForFirstPlayer: Double
)