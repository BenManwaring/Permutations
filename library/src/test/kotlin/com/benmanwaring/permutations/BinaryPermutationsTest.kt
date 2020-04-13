package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class BinaryPermutationsTest {

    @Test
    fun `Binary permutations iterator for fixed length defaulted input array`() {
        val binaryPermutationsIterator = Permutations.createBinary().iterable(2).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(arrayOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { binaryPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Binary permutations iterator for fixed length valid input array`() {
        val binaryPermutationsIterator =
            Permutations.createBinary(arrayOf(true, false, true)).iterable(2).iterator()

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

        val exception =
            assertThrows(NoSuchElementException::class.java) { binaryPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Binary permutations iterator for zero length valid input array`() {
        val stringPermutationsIterator =
            Permutations.createBinary().iterable(0).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Binary permutations iterator for ranged length defaulted input array`() {
        val binaryPermutationsIterator = Permutations.createBinary().iterable(1..3).iterator()

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

        val exception =
            assertThrows(NoSuchElementException::class.java) { binaryPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `Binary permutations iterator for ranged length valid input array`() {
        val binaryPermutationsIterator =
            Permutations.createBinary(arrayOf(true, false)).iterable(1..3).iterator()

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

        val exception =
            assertThrows(NoSuchElementException::class.java) { binaryPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `No such element exception for negative range`() {
        assertThrows(NoSuchElementException::class.java) {
            Permutations.createBinary().iterable(-1..0).iterator().next()
        }
    }

    @Test
    fun `No such element exception for zero to zero range`() {
        assertThrows(NoSuchElementException::class.java) {
            Permutations.createBinary().iterable(0..0).iterator().next()
        }
    }

    @Test
    fun `Binary permutations iterator for large ranged length valid input array`() {
        val binaryPermutationsIterable = Permutations.createBinary(arrayOf(false)).iterable(1..1000)

        var incrementCount = 0
        val expectedBinary = mutableListOf(false)
        for (binary in binaryPermutationsIterable) {
            assertThat(binary, `is`(expectedBinary.toTypedArray()))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Binary permutations iterator for large offset ranged length valid input array`() {
        val binaryPermutationsIterable =
            Permutations.createBinary(arrayOf(false)).iterable(10..1000)

        var incrementCount = 0
        val expectedBinary =
            mutableListOf(false, false, false, false, false, false, false, false, false, false)
        for (binary in binaryPermutationsIterable) {
            assertThat(binary, `is`(expectedBinary.toTypedArray()))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Permutations.createBinary(arrayOf())
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }
}
