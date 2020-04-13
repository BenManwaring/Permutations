package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert
import org.junit.Test

class CharRangePermutationsTest {

    @Test
    fun `Char range permutation iterator with fixed length`() {
        val charRangePermutationsIterator = ('A'..'C').permutations(2).iterator()

        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(false))

        val exception =
            Assert.assertThrows(NoSuchElementException::class.java) { charRangePermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Char range permutation iterator with length range`() {
        val charRangePermutationsIterator = ('A'..'C').permutations(1..2).iterator()

        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("A"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("B"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("C"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("AC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("BC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CA"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CB"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(true))
        assertThat(charRangePermutationsIterator.next(), `is`("CC"))
        assertThat(charRangePermutationsIterator.hasNext(), `is`(false))

        val exception =
            Assert.assertThrows(NoSuchElementException::class.java) { charRangePermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Char range permutation iterator with fixed length, relatively large combinations`() {
        val charRangePermutations = ('a'..'z').permutations(2)

        var incrementCount = 0
        for (charListPermutation in charRangePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(26 * 26))
    }

    @Test
    fun `Char range permutation iterator with length range, relatively large combinations`() {
        val charRangePermutations = ('a'..'z').permutations(1..2)

        var incrementCount = 0
        for (charListPermutation in charRangePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(26 + (26 * 26)))
    }
}
