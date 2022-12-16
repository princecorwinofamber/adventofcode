fun main() {
    fun part1(input: List<String>): Int {
        var currentTotalCalories = 0
        var maxTotalCalories = 0
        for (string in input) {
            val trimmed = string.trim()
            if (trimmed.isEmpty()) {
                if (currentTotalCalories > maxTotalCalories) {
                    maxTotalCalories = currentTotalCalories
                }
                currentTotalCalories = 0
            } else {
                currentTotalCalories += trimmed.toInt()
            }
        }
        return maxTotalCalories
    }

    fun part2(input: List<String>): Int {
        val top3 = mutableListOf(0, 0, 0)
        var currentTotalCalories = 0
        for (string in input) {
            val trimmed = string.trim()
            if (trimmed.isEmpty()) {
                val binSearchResult = top3.binarySearch(currentTotalCalories)
                if (binSearchResult < 0) {
                    top3.add(-(binSearchResult + 1), currentTotalCalories)
                } else {
                    top3.add(binSearchResult, currentTotalCalories)
                }
                top3.removeFirst()
                currentTotalCalories = 0
            } else {
                currentTotalCalories += trimmed.toInt()
            }
        }
        return top3.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
