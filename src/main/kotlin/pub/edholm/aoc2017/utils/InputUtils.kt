package pub.edholm.aoc2017.utils

import java.net.URL

fun getInputForDay(day: Int): String {
  if (day < 1 || day > 25) {
    throw IllegalArgumentException("Invalid day, got $day, expected 1<day<25")
  }
  return getResource("day$day")
}

fun getResource(path: String): String {
  val resource: URL = {}.javaClass.enclosingClass.getResource("/$path")
    ?: throw IllegalArgumentException("Resource '$path' not found")

  return resource.readText().trim()
}
