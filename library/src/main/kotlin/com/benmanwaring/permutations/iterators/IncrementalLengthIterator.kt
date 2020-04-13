package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.iterables.PermutationsIterable

internal class IncrementalLengthIterator<T>(
    private val permutationsFactory: PermutationsIterable<T>,
    private val range: Iterable<Int>
) : Iterator<T> {

    private var rangeIterator: Iterator<Int>? = null

    private var permutations: Iterator<T>? = null

    private fun getRangeIterator(): Iterator<Int> {
        var safeRangeIterator = rangeIterator
        if (safeRangeIterator == null) {
            safeRangeIterator = range.iterator()
            rangeIterator = safeRangeIterator
        }
        return safeRangeIterator
    }

    private fun getPermutations(): Iterator<T> {
        var safePermutations = permutations
        if (safePermutations == null) {
            if (!getRangeIterator().hasNext()) {
                throw NoSuchElementException("Range exhausted, check hasNext() prior to using next()")
            }
            safePermutations = permutationsFactory.create(getRangeIterator().next())
            permutations = safePermutations
        }
        return safePermutations
    }

    override fun hasNext(): Boolean {
        return getRangeIterator().hasNext() || getPermutations().hasNext()
    }

    override fun next(): T {
        if (!getPermutations().hasNext()) {
            permutations = null
        }
        return getPermutations().next()
    }
}

