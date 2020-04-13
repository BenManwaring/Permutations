package com.benmanwaring.permutations

import com.benmanwaring.permutations.arrays.UnwrappedStringPermutations
import com.benmanwaring.permutations.factory.PermutationsIterable
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator

class StringPermutations(private val inputArray: CharArray) : PermutationsIterable<String> {

    init {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }
    }

    fun iterable(length: Int): Iterable<String> {
        if (length < 1) {
            return emptyList()
        }

        return object : Iterable<String> {
            override fun iterator(): Iterator<String> {
                return UnwrappedStringPermutations(inputArray, length)
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

