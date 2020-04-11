package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class BinaryPermutationsTest {

    @Test
    fun `Binary permutations iterable for fixed length`() {
        val binaryPermutationsIterator = BinaryPermutations(length = 2).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { binaryPermutationsIterator.next() }
    }

    @Test
    fun `Binary permutations iterable with additional inputs for fixed length`() {
        val binaryPermutationsIterator =
            BinaryPermutations(arrayOf(true, false, true), 2).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { binaryPermutationsIterator.next() }
    }

    @Test
    fun `Binary permutations iterable for length range`() {
        val binaryPermutationsIterator = BinaryPermutations(minLength = 1, maxLength = 3).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { binaryPermutationsIterator.next() }
    }

    @Test
    fun `Binary permutations iterable for length range with inverted booleans`() {
        val binaryPermutationsIterator = BinaryPermutations(arrayOf(true, false), 1, 3).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(false))

        assertThrows(
            "Iterable exhausted: use has next to check element available prior to using next",
            NoSuchElementException::class.java
        ) { binaryPermutationsIterator.next() }
    }

    @Test
    fun `Binary permutations with end length of 1000`() {
        val binaryPermutations = BinaryPermutations(arrayOf(false), 1, 1000)

        var incrementCount = 0
        val expectedBinary = mutableListOf(false)
        for (binary in binaryPermutations) {
            assertThat(binary, `is`(expectedBinary.toTypedArray()))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Binary permutations with start length of 10 and end length of 1000`() {
        val binaryPermutations = BinaryPermutations(arrayOf(false), 10, 1000)

        var incrementCount = 0
        val expectedBinary =
            mutableListOf(false, false, false, false, false, false, false, false, false, false)
        for (binary in binaryPermutations) {
            assertThat(binary, `is`(expectedBinary.toTypedArray()))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input and fixed length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BinaryPermutations(arrayOf(), 0).iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for empty input and ranged length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BinaryPermutations(arrayOf(), 0, 0).iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for 0 length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BinaryPermutations(arrayOf(true), 0).iterator()
        }
        assertThat(exception.message, `is`("Length must be larger than 0"))
    }

    @Test
    fun `Illegal argument exception for miss ranged min and max`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            BinaryPermutations(arrayOf(true), 2, 1).iterator()
        }
        assertThat(
            exception.message,
            `is`("Min length must be higher than 0 and less than the max length")
        )
    }
}
