package pub.edholm.aoc2017.day5

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val formattedInput = formatInput(getInputForDay(5))
  val maze = Maze()

  println("Day 5:")
  println("  Part I:  ${maze.countJumps(formattedInput)}")
  println("  Part II: ${maze.countJumpsPart2(formattedInput)}")
}

private fun formatInput(input: String): IntArray {
  return input.split("\n")
    .map { it.toInt() }
    .toIntArray()
}

internal class Maze {
  fun countJumps(jumpsOrg: IntArray): Long {
    val jumps = jumpsOrg.copyOf()

    var index = 0
    var count = 0L

    while (index < jumps.size) {
      count++

      val jump = jumps[index]
      jumps[index] = jumps[index].inc()

      index += jump
    }
    return count
  }

  fun countJumpsPart2(jumpsOrg: IntArray): Long {
    val jumps = jumpsOrg.copyOf()
    var index = 0
    var count = 0L

    while (index < jumps.size) {
      val jump = jumps[index]

      if (jump >= 3) {
        jumps[index] -= 1
      } else {
        jumps[index] += 1
      }

      count++
      index += jump
    }
    return count
  }

}