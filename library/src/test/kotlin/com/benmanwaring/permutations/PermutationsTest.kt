package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class PermutationsTest {

    @Test
    fun `Any permutations iterator for fixed length valid input array`() {
        val genericPermutationsIterator =
            Permutations.create(arrayOf(null, 1, "test")).iterable(2).iterator()

        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { genericPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Any permutations iterator for zero length valid input array`() {
        val genericPermutationsIterator =
            Permutations.create(arrayOf<Any?>(null, 1, "test")).iterable(0).iterator()

        assertThat(genericPermutationsIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Any permutations iterator for ranged length valid input array`() {
        val genericPermutationsIterator =
            Permutations.create(arrayOf<Any?>(null, 1, "test")).iterable(1..3).iterator()

        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, null, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, null, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, null, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, null, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, null, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, null, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", null, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", null, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", null, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", null)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", 1)))
        assertThat(genericPermutationsIterator.hasNext(), `is`(true))
        assertThat(genericPermutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", "test")))
        assertThat(genericPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { genericPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `No such element exception for negative range`() {
        assertThrows(NoSuchElementException::class.java) {
            Permutations.create(arrayOf<Any?>(null)).iterable(-1..0).iterator().next()
        }
    }

    @Test
    fun `No such element exception for zero to zero range`() {
        assertThrows(NoSuchElementException::class.java) {
            Permutations.create(arrayOf<Any?>(null)).iterable(0..0).iterator().next()
        }
    }

    @Test
    fun `Any permutations iterator for large ranged length valid input array`() {
        val genericIterable = Permutations.create(arrayOf<Any?>(null)).iterable(1..1000)

        var incrementCount = 0
        val expectedArray = mutableListOf<Any?>(null)
        for (array in genericIterable) {
            assertThat(array, `is`(expectedArray.toTypedArray()))
            incrementCount++
            expectedArray.add(null)
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Any permutations iterator for large offset ranged length valid input array`() {
        val genericIterable = Permutations.create(arrayOf<Any?>(null)).iterable(10..1000)

        var incrementCount = 0
        val expectedArray =
            mutableListOf<Any?>(null, null, null, null, null, null, null, null, null, null)

        for (array in genericIterable) {
            assertThat(array, `is`(expectedArray.toTypedArray()))
            incrementCount++
            expectedArray.add(null)
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input for fixed length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            Permutations.create(arrayOf<Any?>()).iterable(1).iterator().next()
        }
        assertThat(exception.message, `is`("Array is empty."))
    }

    @Test
    fun `Illegal argument exception for empty input for ranged length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            Permutations.create(arrayOf<Any?>()).iterable(1..2).iterator().next()
        }
        assertThat(exception.message, `is`("Array is empty."))
    }
}
