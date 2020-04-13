package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class ArrayPermutationsTest {

    @Test
    fun `Any permutations iterator for fixed length valid input array`() {
        val permutationsIterator = arrayOf(null, 1, "test").permutations(2).iterator()

        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(permutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { permutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Any permutations iterator for zero length valid input array`() {
        val permutationsIterator = arrayOf<Any?>(null, 1, "test").permutations(0).iterator()

        assertThat(permutationsIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Any permutations iterator for ranged length valid input array`() {
        val permutationsIterator =
            arrayOf<Any?>(null, 1, "test").permutations(1..3).iterator()

        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, null, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, null, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, null, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, 1, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(null, "test", "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, null, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, null, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, null, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, 1, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>(1, "test", "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", null, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", null, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", null, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", 1, "test")))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", null)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", 1)))
        assertThat(permutationsIterator.hasNext(), `is`(true))
        assertThat(permutationsIterator.next(), `is`(arrayOf<Any?>("test", "test", "test")))
        assertThat(permutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { permutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `No such element exception for negative range`() {
        assertThrows(NoSuchElementException::class.java) {
            arrayOf<Any?>(null).permutations(-1..0).iterator().next()
        }
    }

    @Test
    fun `No such element exception for zero to zero range`() {
        assertThrows(NoSuchElementException::class.java) {
            arrayOf<Any?>(null).permutations(0..0).iterator().next()
        }
    }

    @Test
    fun `Any permutations iterator for large ranged length valid input array`() {
        val permutations = arrayOf<Any?>(null).permutations(1..1000)

        var incrementCount = 0
        val expectedArray = mutableListOf<Any?>(null)
        for (array in permutations) {
            assertThat(array, `is`(expectedArray.toTypedArray()))
            incrementCount++
            expectedArray.add(null)
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Any permutations iterator for large offset ranged length valid input array`() {
        val permutations = arrayOf<Any?>(null).permutations(10..1000)

        var incrementCount = 0
        val expectedArray =
            mutableListOf<Any?>(null, null, null, null, null, null, null, null, null, null)

        for (array in permutations) {
            assertThat(array, `is`(expectedArray.toTypedArray()))
            incrementCount++
            expectedArray.add(null)
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input for fixed length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            arrayOf<Any?>().permutations(1).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }

    @Test
    fun `Illegal argument exception for empty input for ranged length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            arrayOf<Any?>().permutations(1..2).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }
}
