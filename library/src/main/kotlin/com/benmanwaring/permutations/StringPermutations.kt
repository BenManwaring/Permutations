package com.benmanwaring.permutations

import com.benmanwaring.permutations.iterables.PermutationsIterable
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator
import com.benmanwaring.permutations.iterators.StringPermutationsIterator

fun String.permutations(length: Int): Iterable<String> {
    if (length < 1) {
        return emptyList()
    }

    return Iterable { StringPermutationsIterator(asIterable(), length) }
}

fun String.permutations(range: Iterable<Int>): Iterable<String> {
    return object : Iterable<String>, PermutationsIterable<String> {
        override fun iterator(): Iterator<String> {
            return IncrementalLengthIterator(this, range)
        }

        override fun create(length: Int): Iterator<String> {
            return this@permutations.permutations(length).iterator()
        }
    }
}

