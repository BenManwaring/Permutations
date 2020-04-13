package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class BinaryListPermutationsTest {

    @Test
    fun `Binary permutations iterator for fixed length defaulted input array`() {
        val binaryPermutationsIterator = listOf(false, true).permutations(2).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
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
        val binaryPermutationsIterator = listOf(true, false, true).permutations(2).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
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
        val stringPermutationsIterator = listOf(false, true).permutations(0).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Binary permutations iterator for ranged length defaulted input array`() {
        val binaryPermutationsIterator = listOf(false, true).permutations(1..3).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true, true)))
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
            listOf(true, false).permutations(1..3).iterator()

        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(true, false, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, true, false)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false, true)))
        assertThat(binaryPermutationsIterator.hasNext(), `is`(true))
        assertThat(binaryPermutationsIterator.next(), `is`(listOf(false, false, false)))
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
            listOf(false, true).permutations(-1..0).iterator().next()
        }
    }

    @Test
    fun `No such element exception for zero to zero range`() {
        assertThrows(NoSuchElementException::class.java) {
            listOf(false, true).permutations(0..0).iterator().next()
        }
    }

    @Test
    fun `Binary permutations iterator for large ranged length valid input array`() {
        val binaryPermutations = listOf(false).permutations(1..1000)

        var incrementCount = 0
        val expectedBinary = mutableListOf(false)
        for (binary in binaryPermutations) {
            assertThat(binary, `is`(expectedBinary as List<Boolean>))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Binary permutations iterator for large offset ranged length valid input array`() {
        val binaryPermutations =
            listOf(false).permutations(10..1000)

        var incrementCount = 0
        val expectedBinary =
            mutableListOf(false, false, false, false, false, false, false, false, false, false)
        for (binary in binaryPermutations) {
            assertThat(binary, `is`(expectedBinary as List<Boolean>))
            incrementCount++
            expectedBinary.add(false)
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input for fixed length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            listOf<Boolean>().permutations(1).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }

    @Test
    fun `Illegal argument exception for empty input for ranged length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            listOf<Boolean>().permutations(1..2).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }
}
