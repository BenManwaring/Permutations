package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class IterablePermutationsTest {

    @Test
    fun `Iterable permutation iterator with fixed length`() {
        val iterablePermutationsIterator = (0..2).permutations(2).iterator()

        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { iterablePermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Iterable permutation iterator with length range`() {
        val iterablePermutationsIterator = (0..2).permutations(1..2).iterator()

        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(0, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(1, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 0)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 1)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(true))
        assertThat(iterablePermutationsIterator.next(), `is`(listOf(2, 2)))
        assertThat(iterablePermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { iterablePermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Iterable permutation iterator with fixed length, relatively large combinations`() {
        val iterablePermutations = (0..9).permutations(2)

        var incrementCount = 0
        for (charListPermutation in iterablePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(10 * 10))
    }

    @Test
    fun `Iterable permutation iterator with length range, relatively large combinations`() {
        val iterablePermutations = (0..9).permutations(1..2)

        var incrementCount = 0
        for (charListPermutation in iterablePermutations) {
            incrementCount++
        }
        assertThat(incrementCount, `is`(10 + (10 * 10)))
    }
}
