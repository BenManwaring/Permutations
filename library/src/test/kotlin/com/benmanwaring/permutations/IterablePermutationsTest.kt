package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class IterablePermutationsTest {

    @Test
    fun `Char range permutation iterator`() {
        val charRangePermutations = ('a'..'z').permutations(1..2)

        var incrementCount = 0
        for (charListPermutation in charRangePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(26 + (26 * 26)))
    }

    @Test
    fun `Int range permutation iterator`() {
        val intRangePermutations = (0..9).permutations(1..2)

        var incrementCount = 0
        for (intListPermutation in intRangePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(110))
    }
}
