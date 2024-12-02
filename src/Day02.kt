import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        return input.count {it.isSafe()}
    }

    fun part2(input: List<String>): Int {
        return input.count {it.isAlmostSafe()}
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun String.isSafe(): Boolean {
    val elements = this.split(" ").map{it.toInt()}
    return checkForSafety(elements)
}

private fun checkForSafety(elements: List<Int>) = elements.filterIndexed { i, _ ->
    i < elements.size - 1 && (abs(elements[i] - elements[i + 1]) !in 1..3 || (elements[0] > elements[1] && elements[i] < elements[i + 1] || elements[0] < elements[1] && elements[i] > elements[i + 1]))
}.isEmpty()

fun String.isAlmostSafe(): Boolean {
    val elements = this.split(" ").map{it.toInt()}
    if (!checkForSafety(elements)) {
        return elements.filterIndexed { i, _ ->
            val smallElements = elements.toMutableList()
            smallElements.removeAt(i)
            checkForSafety(smallElements)
        }.isNotEmpty()
    }

    return true
}
