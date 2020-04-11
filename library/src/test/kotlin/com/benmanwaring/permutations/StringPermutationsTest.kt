package com.benmanwaring.permutations

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThrows
import org.junit.Test

class StringPermutationsTest {

    @Test
    fun `Incremental string Iterable`() {
        val stringIterableIterator = StringPermutations("ABC".toCharArray(), 2).iterator()

        assertThat(stringIterableIterator.next(), `is`("AA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AC"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BC"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("CA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("CB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("CC"))
        assertThat(stringIterableIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Incremental length string Iterable with inverse characters`() {
        val stringIterableIterator = StringPermutations("BA".toCharArray(), 1, 3).iterator()

        assertThat(stringIterableIterator.next(), `is`("B"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("A"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BBB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BBA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BAB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("BAA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("ABB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("ABA"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AAB"))
        assertThat(stringIterableIterator.hasNext(), `is`(true))
        assertThat(stringIterableIterator.next(), `is`("AAA"))
        assertThat(stringIterableIterator.hasNext(), `is`(false))
    }

    @Test
    fun `Incremental length string Iterable with end length of 1000`() {
        val stringIterableIterator = StringPermutations("A".toCharArray(), 1, 1000)

        var incrementCount = 0
        var expectedString = "A"
        for (string in stringIterableIterator) {
            assertThat(string, `is`(expectedString))
            incrementCount++
            expectedString += "A"
        }

        assertThat(incrementCount, `is`(1000))
    }

    @Test
    fun `Incremental length string Iterable with start length of 10 and end length of 1000`() {
        val stringIncrementalLengthIterable =
            StringPermutations(
                "A".toCharArray(),
                10,
                1000
            )

        var incrementCount = 0
        var expectedString = "AAAAAAAAAA"
        for (string in stringIncrementalLengthIterable) {
            assertThat(string, `is`(expectedString))
            incrementCount++
            expectedString += "A"
        }

        assertThat(incrementCount, `is`(991))
    }

    @Test
    fun `Illegal argument exception for empty input and fixed length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringPermutations("".toCharArray(), 0).iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for empty input and ranged length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringPermutations("".toCharArray(), 0, 0).iterator()
        }
        assertThat(exception.message, `is`("Input must not be empty"))
    }

    @Test
    fun `Illegal argument exception for 0 length`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringPermutations("A".toCharArray(), 0).iterator()
        }
        assertThat(exception.message, `is`("Length must be larger than 0"))
    }

    @Test
    fun `Illegal argument exception for miss ranged min and max`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringPermutations("A".toCharArray(), 2, 1).iterator()
        }
        assertThat(
            exception.message,
            `is`("Min length must be higher than 0 and less than the max length")
        )
    }
}
