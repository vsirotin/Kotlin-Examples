package eu.sirotin.kotlin.examples.matrix

fun <T> matrixOf(vararg rows: Row<T>): Matrix<T>{
    if(rows.isEmpty())throw IllegalArgumentException("No rows set")

    val colNumber = rows[0].data.size
    if(colNumber == 0)throw IllegalArgumentException("First row is empty")

    if(rows.any { it.data.size != colNumber }) throw IllegalArgumentException("Rows have different length")

    val result = Matrix<T>(rows.size, colNumber)
    rows.forEachIndexed{indexRow, row->result.setRow(indexRow, row)}
    return result
}

fun <T> rowOf(vararg elements: T): Row<T>{
    return Row(*elements)
}

class Matrix<T>(private val rowNumber: Int, private val columnNumber: Int) {
    private var data : MutableMap<Int, Map<Int, T>>? = null
    operator fun set(rowPos: Int, colPos: Int, value: T) {
        if((rowPos < 0) || (rowPos >= rowNumber))throw IllegalArgumentException("False value rowPos")
        if((colPos < 0) || (colPos >= columnNumber))throw IllegalArgumentException("False value colPos")
        if(data == null)data = HashMap()

        var row = data!![rowPos]?.toMutableMap()
        if(row == null)row = HashMap()

        row[colPos] = value
        data!![rowPos] = row
    }

    operator fun get(rowPos: Int, colPos: Int): T?{
        if(data == null)return null
        return when(val row = data!![rowPos]){
            null -> null
            else -> row[colPos]
        }

    }

    fun setRow(indexRow: Int, row: Row<T>) {
        row.data.forEachIndexed{indexColumn, value->this[indexRow, indexColumn] = value}
    }
}

class Row<T>(vararg elements: T){
    var data: Array<out T> = elements
}