package com.benmanwaring.permutations

import com.benmanwaring.permutations.iterables.PermutationsIterable
import com.benmanwaring.permutations.iterators.ListPermutationsIterator
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator

inline fun <reified T> Iterable<T>.permutations(length: Int): Iterable<List<T>> {
    return permutations(length, mutableListFactory())
}

fun <T> Iterable<T>.permutations(
    length: Int,
    mutableListFactory: (length: Int, initialValue: T) -> MutableList<T>
): Iterable<List<T>> {
    if (length < 1) {
        return emptyList()
    }

    return Iterable { ListPermutationsIterator(this, length, mutableListFactory) }
}

inline fun <reified T> Iterable<T>.permutations(range: Iterable<Int>): Iterable<List<T>> {
    return permutations(range, mutableListFactory())
}

fun <T> Iterable<T>.permutations(
    range: Iterable<Int>,
    mutableListFactory: (length: Int, initialValue: T) -> MutableList<T>
): Iterable<List<T>> {
    return object : Iterable<List<T>>, PermutationsIterable<List<T>> {
        override fun iterator(): Iterator<List<T>> {
            return IncrementalLengthIterator(this, range)
        }

        override fun create(length: Int): Iterator<List<T>> {
            return permutations(length, mutableListFactory).iterator()
        }
    }
}

inline fun <reified T> mutableListFactory(): (length: Int, initialValue: T) -> MutableList<T> {
    return { length, initialValue -> MutableList(length) { initialValue } }
}

