package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface
import java.util.*

internal abstract class PermutationsIterator<T, R, A : ArrayInterface<T>>(
    inputArray: ArrayInterface<T>,
    private val holdingArray: A
) : Permutations<T>(inputArray, holdingArray), Iterator<R> {

    var initialIncrement = holdingArray.size > 0

    override fun hasNext(): Boolean {
        return initialIncrement || super.hasNext()
    }

    override fun next(): R {
        if (initialIncrement) {
            initialIncrement = false
        } else {
            if (!increment()) {
                throw NoSuchElementException("Iterable exhausted: use has next to check element available prior to using next")
            }
        }
        return unwrap(holdingArray)
    }

    abstract fun unwrap(holdingArray: A): R
}

