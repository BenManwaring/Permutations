package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface

internal open class PermutationIterator<T, A : ArrayInterface<T>> private constructor(
    private val inputArray: A,
    private val outputArray: A,
    private val outputArrayIndex: Int
) : Iterator<A> {

    private val subPermutationIterator: PermutationIterator<T, A>? =
        if (outputArrayIndex + 1 < outputArray.size) {
            PermutationIterator(inputArray, outputArray, outputArrayIndex + 1)
        } else {
            null
        }

    private var currentInputArrayIndex = 0

    private var beforeFirstNext = true

    constructor(inputArray: A, outputArray: A) : this(inputArray, outputArray, 0)

    override fun hasNext(): Boolean {
        return (subPermutationIterator != null && subPermutationIterator.hasNext())
                || (currentInputArrayIndex < inputArray.size - 1)
                || (beforeFirstNext && inputArray.size > 0)
    }

    override fun next(): A {
        if (beforeFirstNext) {
            beforeFirstNext = false
            subPermutationIterator?.next()
            return outputArray
        }

        if (subPermutationIterator != null) {
            if (subPermutationIterator.hasNext()) {
                subPermutationIterator.next()
                return outputArray
            } else {
                subPermutationIterator.reset()
            }
        }
        if (currentInputArrayIndex < inputArray.size - 1) {
            currentInputArrayIndex++
            outputArray[outputArrayIndex] = inputArray[currentInputArrayIndex]
        } else {
            throw NoSuchElementException("Input array exhausted, check hasNext() prior to using next()")
        }
        return outputArray
    }

    private fun reset() {
        subPermutationIterator?.reset()
        currentInputArrayIndex = 0
        outputArray[outputArrayIndex] = inputArray[0]
    }
}

