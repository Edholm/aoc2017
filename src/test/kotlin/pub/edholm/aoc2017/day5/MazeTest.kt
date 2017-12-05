package pub.edholm.aoc2017.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MazeTest {

  @Test
  fun walkJumpList() {
    val jumps = intArrayOf(0, 3, 0, 1, -3)
    val countJumps = Maze().countJumps(jumps)

    assertThat(countJumps).isEqualTo(5)
  }

  @Test
  fun walkJumpListPart2() {
    val jumps = intArrayOf(0, 3, 0, 1, -3)
    val countJumps = Maze().countJumpsPart2(jumps)

    assertThat(countJumps).isEqualTo(10)
  }
}