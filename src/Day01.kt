fun main() {

    fun part1(input: List<String>): Int {

        var list1 = mutableListOf<Int>()
        var list2 = mutableListOf<Int>()


        input.forEach{it ->
            var entries = it.split("   ")
            list1.add(entries[0].toInt())
            list2.add(entries[1].toInt())
        }

        list1.sort()
        list2.sort()


        var totalDistance = 0;
        list1.forEachIndexed{i, it ->
            totalDistance += Math.abs(list1[i] - list2[i])
        }

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
