package pub.edholm.aoc2017.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InverseCaptchaTest {
  @Test
  fun solveCaptchaPartOne() {
    val inverseCaptcha = InverseCaptcha()
    assertThat(inverseCaptcha.solveCaptchaPartOne("1122".formatToInts())).isEqualTo(3)
    assertThat(inverseCaptcha.solveCaptchaPartOne("1111".formatToInts())).isEqualTo(4)
    assertThat(inverseCaptcha.solveCaptchaPartOne("1234".formatToInts())).isEqualTo(0)
    assertThat(inverseCaptcha.solveCaptchaPartOne("91212129".formatToInts())).isEqualTo(9)
  }

  @Test
  fun solveCaptchaPartTwo() {
    val inverseCaptcha = InverseCaptcha()
    assertThat(inverseCaptcha.solveCaptchaPartTwo("1212".formatToInts())).isEqualTo(6)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("1221".formatToInts())).isEqualTo(0)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("123425".formatToInts())).isEqualTo(4)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("123123".formatToInts())).isEqualTo(12)
    assertThat(inverseCaptcha.solveCaptchaPartTwo("12131415".formatToInts())).isEqualTo(4)
  }

}