package pub.edholm.aoc2017.day2

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inputForDay2 = getInputForDay(2)
  val matrix = buildMatrix(inputForDay2)
  val checksum = Checksum()
  println("Day 2:")
  println("  Part I:  ${checksum.calculatePartOne(matrix)}")
  println("  Part I:  ${checksum.calculatePartTwo(matrix)}")
}

private fun buildMatrix(input: String): List<List<Int>> {
  return input
    .trim()
    .split("\n")
    .map {
      it.split("\t")
        .map(String::toInt)
    }
}

internal class Checksum {
  fun calculatePartOne(matrix: List<List<Int>>): Int {
    return matrix
      .map { it.getMinAndMax() }
      .map { it.diff() }
      .sum()
  }

  fun calculatePartTwo(matrix: List<List<Int>>): Int {
    return matrix
      .map { it.findDivisible() }
      .map { it.divide() }
      .sum()
  }

  private fun MinMax.diff(): Int {
    return this.max - this.min
  }

  private fun List<Int>.getMinAndMax(): MinMax {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    this.forEach {
      if (it > max) {
        max = it
      }
      if (it < min) {
        min = it
      }
    }
    return MinMax(min, max)
  }

  private fun List<Int>.findDivisible(): Pair<Int, Int> {
    this.forEachIndexed { index, value ->
      this.subList(index + 1, this.size).forEach { nxtValue ->
        if (value % nxtValue == 0) {
          return Pair(value, nxtValue)
        } else if (nxtValue % value == 0) {
          return Pair(nxtValue, value)
        }
      }
    }
    throw IllegalStateException("No divisible numbers found in $this")
  }

  private fun Pair<Int, Int>.divide() = this.first / this.second
}

private data class MinMax(val min: Int, val max: Int)
