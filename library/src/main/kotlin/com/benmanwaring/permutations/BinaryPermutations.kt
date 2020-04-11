package com.benmanwaring.permutations

import com.benmanwaring.permutations.arrays.WrappedArray
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator
import com.benmanwaring.permutations.iterators.InternalGenericIterator

class BinaryPermutations : Iterable<Array<Boolean>> {

    private val iterable: Iterable<Array<Boolean>>

    constructor(inputArray: Array<Boolean> = arrayOf(false, true), length: Int) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (length < 1) {
            throw IllegalArgumentException("Length must be larger than 0")
        }

        iterable = object : Iterable<Array<Boolean>> {
            override fun iterator(): Iterator<Array<Boolean>> {
                return InternalGenericIterator(
                    WrappedArray(inputArray),
                    Array(length) { inputArray[0] }
                )
            }
        }
    }

    constructor(inputArray: Array<Boolean> = arrayOf(false, true), minLength: Int, maxLength: Int) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (minLength !in 1..maxLength) {
            throw IllegalArgumentException("Min length must be higher than 0 and less than the max length")
        }

        iterable = object : Iterable<Array<Boolean>> {
            override fun iterator(): Iterator<Array<Boolean>> {
                return IncrementalLengthIterator(
                    WrappedArray(inputArray),
                    FACTORY,
                    minLength,
                    maxLength
                )
            }
        }
    }

    override fun iterator(): Iterator<Array<Boolean>> {
        return iterable.iterator()
    }

    companion object {
        private val FACTORY =
            InternalGenericIterator.factory { length, initialValue: Boolean ->
                Array(length) { initialValue }
            }
    }
}

