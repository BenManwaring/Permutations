package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class StringPermutationsTest {

    @Test
    fun `String permutations iterator for fixed length valid input array`() {
        val stringPermutationsIterator = "ABC".permutations(2).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AC"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BC"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("CA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("CB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("CC"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { stringPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Input array exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `String permutations iterator for zero length valid input array`() {
        val stringPermutationsIterator = "ABC".permutations(0).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(false))
    }

    @Test
    fun `String permutations iterator for ranged length valid input array`() {
        val stringPermutationsIterator = "AB".permutations(1..3).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("A"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("B"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AAA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AAB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("ABA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("ABB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BAA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BAB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BBA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BBB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { stringPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `String permutations iterator for decreasing ranged length valid input array`() {
        val stringPermutationsIterator = "AB".permutations(3 downTo 1).iterator()

        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AAA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AAB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("ABA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("ABB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BAA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BAB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BBA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BBB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("AB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BA"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("BB"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("A"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(true))
        assertThat(stringPermutationsIterator.next(), `is`("B"))
        assertThat(stringPermutationsIterator.hasNext(), `is`(false))

        val exception =
            assertThrows(NoSuchElementException::class.java) { stringPermutationsIterator.next() }
        assertThat(
            exception.message,
            `is`("Range exhausted, check hasNext() prior to using next()")
        )
    }

    @Test
    fun `No such element exception for negative range`() {
        assertThrows(NoSuchElementException::class.java) {
            "ABC".permutations(-1..0).iterator().next()
        }
    }

    @Test
    fun `No such element exception for zero to zero range`() {
        assertThrows(NoSuchElementException::class.java) {
            "ABC".permutations(0..0).iterator().next()
        }
    }

    @Test
    fun `String permutations iterator for large ranged length valid input array`() {
        val stringPermutations = "A".permutations(1..1000)

        var incrementCount = 0
        var expectedStringPermutation = "A"
        for (stringPermutation in stringPermutations) {
            assertThat(stringPermutation, `is`(expectedStringPermutation))
            incrementCount++
            expectedStringPermutation += "A"
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `String permutations iterator for large offset ranged length valid input array`() {
        val stringPermutations = "A".permutations(10..1000)

        var incrementCount = 0
        var expectedStringPermutation = "AAAAAAAAAA"
        for (stringPermutation in stringPermutations) {
            assertThat(stringPermutation, `is`(expectedStringPermutation))
            incrementCount++
            expectedStringPermutation += "A"
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input for fixed length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            "".permutations(1).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }

    @Test
    fun `Illegal argument exception for empty input for ranged length`() {
        val exception = assertThrows(NoSuchElementException::class.java) {
            "".permutations(1..2).iterator().next()
        }
        assertThat(exception.message, `is`("List is empty."))
    }
}
