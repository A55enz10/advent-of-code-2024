fun main() {

    fun part1(input: List<String>): Int {

        val solution1 = input.sumOf{
            Regex("mul\\(\\d+,\\d+\\)").findAll(it)
            .map { it.value.substring(4, it.value.length-1).split(",") }
            .toList()
            .sumOf { it[0].toInt() * it[1].toInt() }
        }

        val solution2 = input.sumOf{
            it.split("mul(")
            .map {if (it.indexOf(")") > 1) it.substring(0, it.indexOf(")")) else null }
            .filter { s -> s != null && s.matches(Regex("""^-?\d+,-?\d+${'$'}""")) }
            .map { s2 -> s2?.split(",") }
            .sumOf { values -> values!![0].toInt() * values[1].toInt() }
        }

        return solution1
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

