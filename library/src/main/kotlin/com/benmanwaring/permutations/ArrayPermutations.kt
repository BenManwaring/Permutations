package com.benmanwaring.permutations

import com.benmanwaring.permutations.iterables.PermutationsIterable
import com.benmanwaring.permutations.iterators.ArrayPermutationsIterator
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator

inline fun <reified T> Array<T>.permutations(length: Int): Iterable<Array<T>> {
    return permutations(length, arrayFactory())
}

fun <T> Array<T>.permutations(
    length: Int,
    arrayFactory: (length: Int, initialValue: T) -> Array<T>
): Iterable<Array<T>> {
    if (length < 1) {
        return emptyList()
    }

    return Iterable { ArrayPermutationsIterator(asIterable(), length, arrayFactory) }
}

inline fun <reified T> Array<T>.permutations(range: Iterable<Int>): Iterable<Array<T>> {
    return permutations(range, arrayFactory())
}

fun <T> Array<T>.permutations(
    range: Iterable<Int>,
    arrayFactory: (length: Int, initialValue: T) -> Array<T>
): Iterable<Array<T>> {
    return object : Iterable<Array<T>>, PermutationsIterable<Array<T>> {
        override fun iterator(): Iterator<Array<T>> {
            return IncrementalLengthIterator(this, range)
        }

        override fun create(length: Int): Iterator<Array<T>> {
            return permutations(length, arrayFactory).iterator()
        }
    }
}

inline fun <reified T> arrayFactory(): (length: Int, initialValue: T) -> Array<T> {
    return { length, initialValue -> Array(length) { initialValue } }
}

