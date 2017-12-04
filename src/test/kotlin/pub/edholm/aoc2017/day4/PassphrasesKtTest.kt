package pub.edholm.aoc2017.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PassphrasesKtTest {

  @Test
  fun formatInput() {

  }

  @Test
  fun isValid() {
    val passphrases = Passphrases()
    assertThat(passphrases.isValid(listOf("aa", "bb", "cc", "dd", "ee"))).isTrue()
    assertThat(passphrases.isValid(listOf("aa", "bb", "cc", "dd", "aa"))).isFalse()
    assertThat(passphrases.isValid(listOf("aa", "bb", "cc", "dd", "aaa"))).isTrue()
  }

  @Test
  fun `anagram checker`() {
    assertThat("ecdab".isAnagramOf("abcde")).isTrue()
    assertThat("abcde".isAnagramOf("fghij")).isFalse()
    assertThat("abcde".isAnagramOf("abdc")).isFalse()
    assertThat("oiii".isAnagramOf("ooii")).isFalse()
  }

  @Test
  fun containsAnagrams() {
    val p = Passphrases()
    assertThat(p.containsAnagrams(listOf("abcde", "fghij"))).isFalse()
    assertThat(p.containsAnagrams(listOf("abcde", "xyz", "ecdab"))).isTrue()
    assertThat(p.containsAnagrams(listOf("a", "ab", "abc", "abd", "abf", "abj"))).isFalse()
    assertThat(p.containsAnagrams(listOf("iiii", "oiii", "ooii", "oooi", "oooo"))).isFalse()
    assertThat(p.containsAnagrams(listOf("oiii", "ioii", "iioi", "iiio"))).isTrue()

  }
}