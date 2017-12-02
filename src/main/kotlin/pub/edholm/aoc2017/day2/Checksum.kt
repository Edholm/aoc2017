package pub.edholm.aoc2017.day2

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inputForDay2 = getInputForDay(2)
  val matrix = buildMatrix(inputForDay2)
  val checksum = Checksum()
  println("Day 2:")
  println("  Part I:  ${checksum.calculate(matrix)}")
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
  fun calculate(matrix: List<List<Int>>): Int {
    return matrix.map { it.getMinAndMax() }
      .map { it.diff() }
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
}

private data class MinMax(val min: Int, val max: Int)
