package pub.edholm.aoc2017.day3

import pub.edholm.aoc2017.utils.getInputForDay
import pub.edholm.aoc2017.utils.getResource

fun main(args: Array<String>) {
  // Increase stack size with -Xss before running.
  val formattedInput = formatInput(getInputForDay(3))
  val spiralMemory = SpiralMemory()

  println("Day 3:")
  println("  Part I:  ${spiralMemory.countStepsFrom(formattedInput)}")
  println("  Part II: ${spiralMemory.partTwo(formattedInput)}")
}

private fun formatInput(input: String) = input.toInt()

internal class SpiralMemory {

  fun partTwo(input: Int): Long {
    return getResource("b141481.txt")
      .split("\n")
      .mapNotNull { it.toLongOrNull() }
      .first { it > input }
  }

  fun countStepsFrom(square: Int): Int {
    return coordinatefromSquare(square)
      .distanceTo(Coordinate.origo())
  }

  fun coordinatefromSquare(square: Int): Coordinate {
    if (square < 1) throw IllegalArgumentException("Illegal square, got $square, expected >= 1")
    return Coordinate(calcX(square), calcY(square))
  }

  private fun calcX(square: Int): Int {
    if (square == 0) return 0
    val k = (Math.floor(Math.sqrt(4.0 * (square - 2) + 1)) % 4)

    return calcX(square - 1) +
      Math.sin(k * Math.PI / 2).toInt()
  }

  private fun calcY(square: Int): Int {
    if (square == 0) return 0
    val k = (Math.floor(Math.sqrt(4.0 * (square - 2) + 1)) % 4)

    return calcY(square - 1) +
      Math.cos(k * Math.PI / 2).toInt()
  }
}

data class Coordinate(val x: Int = 0, val y: Int = 0) {
  companion object {
    fun origo() = Coordinate()
  }

  /** @return the Manhattan distance */
  fun distanceTo(other: Coordinate = origo()) = Math.abs(this.x - other.x) + Math.abs(this.y + other.y)
}