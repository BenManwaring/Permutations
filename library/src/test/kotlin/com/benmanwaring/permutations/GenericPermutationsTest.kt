package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class GenericPermutationsTest {

    @Test
    fun `Generic permutations iterable for fixed length`() {
        val genericIterableIterator = GenericPermutations<Any?>(
            arrayOf(null, 1, "test"),
            2
        ) { length, initialValue -> Array(length) { initialValue } }.iterator()

        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { genericIterableIterator.next() }
    }

    @Test
    fun `Generic permutations iterable for length range`() {
        val genericIterableIterator = GenericPermutations(
            arrayOf<Any?>(null, 1, "test"),
            1,
            3
        ) { length, initialValue -> Array(length) { initialValue } }.iterator()

        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, null, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, null, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, null, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, 1, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, 1, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, 1, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, "test", null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, "test", 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(null, "test", "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, null, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, null, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, null, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, 1, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, 1, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, 1, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, "test", null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, "test", 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>(1, "test", "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", null, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", null, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", null, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", 1, null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", 1, 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", 1, "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", "test", null)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", "test", 1)))
        assertThat(genericIterableIterator.hasNext(), `is`(true))
        assertThat(genericIterableIterator.next(), `is`(arrayOf<Any?>("test", "test", "test")))
        assertThat(genericIterableIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { genericIterableIterator.next() }
    }

    @Test
    fun `Generic permutations with end length of 1000`() {
        val genericIterable = GenericPermutations<Any?>(
            arrayOf(null),
            1,
            1000
        ) { length, initialValue -> Array(length) { initialValue } }

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
    fun `Generic permutations with start length of 10 and end length of 1000`() {
        val genericIterable = GenericPermutations<Any?>(
            arrayOf(null),
            10,
            1000
        ) { length, initialValue -> Array(length) { initialValue } }

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
    fun `Illegal argument exception for empty input and fixed length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            GenericPermutations<Any?>(arrayOf(), 0)
            { length, initialValue -> Array(length) { initialValue } }.iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for empty input and ranged length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            GenericPermutations<Any?>(arrayOf(), 0, 0)
            { length, initialValue -> Array(length) { initialValue } }.iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for 0 length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            GenericPermutations<Any?>(arrayOf(null), 0)
            { length, initialValue -> Array(length) { initialValue } }.iterator()
        }
        assertThat(exception.message, `is`("Length must be larger than 0"))
    }

    @Test
    fun `Illegal argument exception for miss ranged min and max`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            GenericPermutations<Any?>(arrayOf(null), 2, 1)
            { length, initialValue -> Array(length) { initialValue } }.iterator()
        }
        assertThat(
            exception.message,
            `is`("Min length must be higher than 0 and less than the max length")
        )
    }
}
