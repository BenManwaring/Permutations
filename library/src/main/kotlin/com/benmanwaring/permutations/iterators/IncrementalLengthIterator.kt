package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface
import com.benmanwaring.permutations.factory.PermutationsIteratorFactory
import java.util.*

internal class IncrementalLengthIterator<T, R>(
    private val inputArray: ArrayInterface<T>,
    private val permutationsIteratorFactory: PermutationsIteratorFactory<T, R>,
    private val minLength: Int,
    private val maxLength: Int
) : Iterator<R> {

    private var currentLength = minLength

    private var subPermutationsIterator: PermutationsIterator<T, R, *> =
        permutationsIteratorFactory.create(inputArray, currentLength)

    private var initialIncrement = true

    private fun increment(): Boolean {
        return when {
            subPermutationsIterator.hasNext() -> {
                true
            }
            currentLength < maxLength -> {
                currentLength++
                subPermutationsIterator =
                    permutationsIteratorFactory.create(inputArray, currentLength)
                true
            }
            else -> {
                currentLength = minLength
                subPermutationsIterator =
                    permutationsIteratorFactory.create(inputArray, currentLength)
                false
            }
        }
    }

    override fun hasNext(): Boolean {
        return when {
            initialIncrement -> {
                true
            }
            subPermutationsIterator.hasNext() -> {
                true
            }
            currentLength < maxLength -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun next(): R {
        if (initialIncrement) {
            initialIncrement = false
        } else {
            if (!increment()) {
                throw NoSuchElementException("Iterable exhausted: use has next to check element available prior to using next")
            }
        }
        return subPermutationsIterator.next()
    }
}

