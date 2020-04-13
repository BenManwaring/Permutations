package com.benmanwaring.permutations

import com.benmanwaring.permutations.iterables.PermutationsIterable
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator
import com.benmanwaring.permutations.iterators.StringPermutationsIterator

class StringPermutations(private val charArray: CharArray) : PermutationsIterable<String> {

    fun iterable(length: Int): Iterable<String> {
        if (length < 1) {
            return emptyList()
        }

        return object : Iterable<String> {
            override fun iterator(): Iterator<String> {
                return StringPermutationsIterator(charArray, length)
            }
        }
    }

    override fun create(length: Int): Iterator<String> {
        return iterable(length).iterator()
    }

    fun iterable(range: Iterable<Int>): Iterable<String> {
        return object : Iterable<String> {
            override fun iterator(): Iterator<String> {
                return IncrementalLengthIterator(this@StringPermutations, range)
            }
        }
    }
}

