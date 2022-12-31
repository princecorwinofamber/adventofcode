fun main() {
    fun part1(input: List<String>): Int {
        var totalScore = 0
        for (line in input) {
            when (line) {
                "A X" -> totalScore += 3 + 1
                "B X" -> totalScore += 0 + 1
                "C X" -> totalScore += 6 + 1
                "A Y" -> totalScore += 6 + 2
                "B Y" -> totalScore += 3 + 2
                "C Y" -> totalScore += 0 + 2
                "A Z" -> totalScore += 0 + 3
                "B Z" -> totalScore += 6 + 3
                "C Z" -> totalScore += 3 + 3
            }
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0
        for (line in input) {
            when (line) {
                "A X" -> totalScore += 0 + 3
                "B X" -> totalScore += 0 + 1
                "C X" -> totalScore += 0 + 2
                "A Y" -> totalScore += 3 + 1
                "B Y" -> totalScore += 3 + 2
                "C Y" -> totalScore += 3 + 3
                "A Z" -> totalScore += 6 + 2
                "B Z" -> totalScore += 6 + 3
                "C Z" -> totalScore += 6 + 1
            }
        }
        return totalScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
