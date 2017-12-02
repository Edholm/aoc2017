package pub.edholm.aoc2017.utils

import java.net.URL

fun getInputForDay(day: Int): String {
  if (day < 1 || day > 25) {
    throw IllegalArgumentException("Invalid day, got $day, expected 1<day<25")
  }
  val resource: URL = {}.javaClass.enclosingClass.getResource("/day$day")
    ?: throw IllegalArgumentException("Input for day $day not found")

  return resource.readText()
}

