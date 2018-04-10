package eu.sirotin.kotlin.examples.strings.formatter


fun <T> Collection<T>.formatToString(
    prefix: String = "[",
    separator: String = ", ",
    postfix: String = "]"
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if(index > 0)result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}