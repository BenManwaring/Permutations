package com.benmanwaring.permutations

import com.benmanwaring.permutations.arrays.WrappedArray
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator
import com.benmanwaring.permutations.iterators.InternalGenericIterator

class GenericPermutations<T> : Iterable<Array<T>> {

    private val iterable: Iterable<Array<T>>

    constructor(
        inputArray: Array<T>,
        length: Int,
        init: (length: Int, initialValue: T) -> Array<T>
    ) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (length < 1) {
            throw IllegalArgumentException("Length must be larger than 0")
        }

        iterable = object : Iterable<Array<T>> {
            override fun iterator(): Iterator<Array<T>> {
                return InternalGenericIterator(
                    WrappedArray(inputArray),
                    init.invoke(length, inputArray[0])
                )
            }
        }
    }

    constructor(
        inputArray: Array<T>,
        minLength: Int,
        maxLength: Int,
        init: (length: Int, initialValue: T) -> Array<T>
    ) {
        if (inputArray.isEmpty()) {
            throw IllegalArgumentException("Input must not be empty")
        }

        if (minLength !in 1..maxLength) {
            throw IllegalArgumentException("Min length must be higher than 0 and less than the max length")
        }

        iterable = object : Iterable<Array<T>> {
            override fun iterator(): Iterator<Array<T>> {
                return IncrementalLengthIterator(
                    WrappedArray(inputArray),
                    InternalGenericIterator.factory(init),
                    minLength,
                    maxLength
                )
            }
        }
    }

    override fun iterator(): Iterator<Array<T>> {
        return iterable.iterator()
    }
}

