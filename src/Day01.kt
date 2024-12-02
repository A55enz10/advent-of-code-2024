fun main() {

    fun part1(input: List<String>): Int {

        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()


        input.forEach{
            list1.add(it.split("   ")[0].toInt())
            list2.add(it.split("   ")[1].toInt())
        }

        list1.sort()
        list2.sort()

        var totalDistance = 0;
        list1.forEachIndexed{i, it ->
            totalDistance += Math.abs(it - list2[i])
        }

        return totalDistance
    }

    fun part2(input: List<String>): Int {

        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()


        input.forEach{
            list1.add(it.split("   ")[0].toInt())
            list2.add(it.split("   ")[1].toInt())
        }

        var totalDistance = 0;
        list1.forEach{it ->
            totalDistance += it * list2.count { item -> item == it }
        }

        return totalDistance
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
