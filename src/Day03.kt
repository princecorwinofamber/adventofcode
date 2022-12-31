enum class State {
    ONE, TWO, THREE
}

fun main() {
    val prioritiesBuilder = mutableMapOf<Char, Int>()
    for (c in 'a'..'z') {
        prioritiesBuilder[c] = c - 'a' + 1
    }
    for (c in 'A'..'Z') {
        prioritiesBuilder[c] = c - 'A' + 27
    }
    val priorities: Map<Char, Int> = prioritiesBuilder

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val first = it.substring(0, it.length / 2)
            val second = it.substring(it.length / 2)
            priorities[(first.toSet() intersect second.toSet()).randomOrNull()] ?: 0
        }
    }

    fun part2(input: List<String>): Int {
        var total = 0
        var state = State.ONE
        var common = setOf<Char>()
        for (line in input) {
            when (state) {
                State.ONE -> {
                    common = line.toSet()
                    state = State.TWO
                }
                State.TWO -> {
                    common = common intersect line.toSet()
                    state = State.THREE
                }
                State.THREE -> {
                    common = common intersect line.toSet()
                    total += priorities[common.randomOrNull()] ?: 0
                    common = setOf()
                    state = State.ONE
                }
            }
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
