package pub.edholm.aoc2017.day1

import pub.edholm.aoc2017.utils.getInputForDay

fun main(args: Array<String>) {
  val inverseCaptcha = InverseCaptcha()
  println("Sum: " + inverseCaptcha.solveCaptcha(getInputForDay(1)))
}

class InverseCaptcha {
  fun solveCaptcha(input: String): Long {
    val inputs = input.convertToListOfLongs()
    val initial = if (inputs.first() == inputs.last()) inputs.first() else 0L

    return inputs
      .zipWithNext()
      .fold(initial, { total, next ->
        when {
          next.valuesAreEqual() -> total + next.first
          else -> total
        }
      })
  }

  private fun <T> Pair<T, T>.valuesAreEqual() = this.first == this.second
  private fun String.convertToListOfLongs() = this.trim().map { it.toString().toLong() }
}