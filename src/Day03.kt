fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf{
            Regex("mul\\(\\d+,\\d+\\)").findAll(it)
            .map { it.value.substring(4, it.value.length-1).split(",") }
            .toList()
            .sumOf { it[0].toInt() * it[1].toInt() }
        }
    }

    fun part2(input: List<String>): Int {
        return part1(input.joinToString().split("do()").map { if (it.contains("don't()"))  it.substring(0, it.indexOf("don't()")) else it })
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

