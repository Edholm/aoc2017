package pub.edholm.aoc2017.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpiralMemoryTest {

  @Test
  fun `how many steps are required`() {
    val spiralMemory = SpiralMemory()
    assertThat(spiralMemory.countStepsFrom(1)).isEqualTo(0)
    assertThat(spiralMemory.countStepsFrom(12)).isEqualTo(3)
    assertThat(spiralMemory.countStepsFrom(23)).isEqualTo(2)
    assertThat(spiralMemory.countStepsFrom(1024)).isEqualTo(31)
  }

  @Test
  fun `coordinate distance`() {
    assertThat(Coordinate.origo().distanceTo()).isEqualTo(0)
    assertThat(Coordinate(2, 1).distanceTo()).isEqualTo(3)
    assertThat(Coordinate(0, -2).distanceTo()).isEqualTo(2)
  }
}