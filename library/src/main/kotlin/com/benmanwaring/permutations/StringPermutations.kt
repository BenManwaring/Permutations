package com.benmanwaring.permutations

import com.benmanwaring.permutations.arrays.WrappedCharArray
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator
import com.benmanwaring.permutations.iterators.InternalStringIterator

class StringPermutations : Iterable<String> {

    private val iterable: Iterable<String>

    constructor(inputArray: CharArray, length: Int) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (length < 1) {
            throw IllegalArgumentException("Length must be larger than 0")
        }

        iterable = object : Iterable<String> {
            override fun iterator(): Iterator<String> {
                return InternalStringIterator(inputArray, length)
            }
        }
    }

    constructor(inputArray: CharArray, minLength: Int, maxLength: Int) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (minLength !in 1..maxLength) {
            throw IllegalArgumentException("Min length must be higher than 0 and less than the max length")
        }

        iterable = object : Iterable<String> {
            override fun iterator(): Iterator<String> {
                return IncrementalLengthIterator(
                    WrappedCharArray(inputArray),
                    InternalStringIterator.FACTORY,
                    minLength,
                    maxLength
                )
            }
        }
    }

    override fun iterator(): Iterator<String> {
        return iterable.iterator()
    }
}

