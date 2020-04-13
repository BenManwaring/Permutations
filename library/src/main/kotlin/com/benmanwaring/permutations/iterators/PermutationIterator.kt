package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface

internal open class PermutationIterator<T, A : ArrayInterface<T>> private constructor(
    private val inputIterable: Iterable<T>,
    private val outputArray: A,
    private val outputArrayIndex: Int
) : Iterator<A> {

    private val subPermutationIterator: PermutationIterator<T, A>? = if (outputArrayIndex > 0) {
        PermutationIterator(inputIterable, outputArray, outputArrayIndex - 1)
    } else {
        null
    }

    private var currentIterator: Iterator<T> = inputIterable.iterator()

    init {
        // The outputArray is already initialised for all the positions so we need to neglect the
        // first items of the all but last permutation.
        if (outputArrayIndex != outputArray.size - 1) {
            currentIterator.next()
        }
    }

    constructor(inputArray: Iterable<T>, outputArray: A) : this(
        inputArray,
        outputArray,
        outputArray.size - 1
    )

    override fun hasNext(): Boolean {
        return (subPermutationIterator != null && subPermutationIterator.hasNext()) || (currentIterator.hasNext())
    }

    override fun next(): A {
        if (!currentIterator.hasNext()) {
            if (subPermutationIterator == null || !subPermutationIterator.hasNext()) {
                throw NoSuchElementException("Input array exhausted, check hasNext() prior to using next()")
            }
            subPermutationIterator.next()
            currentIterator = inputIterable.iterator()
        }
        outputArray[outputArrayIndex] = currentIterator.next()
        return outputArray
    }
}

