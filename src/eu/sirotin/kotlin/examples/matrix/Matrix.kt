package eu.sirotin.kotlin.examples.matrix

class Matrix<T>(private val rowNumber: Int, private val columnNumber: Int) {
    private var data : MutableMap<Int, Map<Int, T>>? = null
    fun set(rowPos: Int, colPos: Int, value: T) {
        if((rowPos < 0) || (rowPos >= rowNumber))throw IllegalArgumentException("False value rowPos")
        if((colPos < 0) || (colPos >= columnNumber))throw IllegalArgumentException("False value colPos")
        if(data == null)data = HashMap()

        var row = data!![rowPos]?.toMutableMap()
        if(row == null)row = HashMap()

        row[colPos] = value
        data!![rowPos] = row
    }

    fun get(rowPos: Int, colPos: Int): T?{
        if(data == null)return null
        return when(val row = data!![rowPos]){
            null -> null
            else -> row[colPos]
        }

    }
}