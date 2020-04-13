package com.benmanwaring.permutations

import com.benmanwaring.permutations.iterables.PermutationsIterable
import com.benmanwaring.permutations.iterators.ArrayPermutationsIterator
import com.benmanwaring.permutations.iterators.IncrementalLengthIterator

class Permutations<T>(
    private val inputArray: Array<T>,
    private val arrayFactory: (length: Int, initialValue: T) -> Array<T>
) : PermutationsIterable<Array<T>> {

    fun iterable(length: Int): Iterable<Array<T>> {
        if (length < 1) {
            return emptyList()
        }

        return object : Iterable<Array<T>> {
            override fun iterator(): Iterator<Array<T>> {
                return ArrayPermutationsIterator(inputArray, length, arrayFactory)
            }
        }
    }

    override fun create(length: Int): Iterator<Array<T>> {
        return iterable(length).iterator()
    }

    fun iterable(range: Iterable<Int>): Iterable<Array<T>> {
        return object : Iterable<Array<T>> {
            override fun iterator(): Iterator<Array<T>> {
                return IncrementalLengthIterator(this@Permutations, range)
            }
        }
    }

    companion object {

        inline fun <reified T> create(inputArray: Array<T>): Permutations<T> {
            return Permutations(inputArray) { length, initialValue -> Array(length) { initialValue } }
        }

        fun createBinary(inputArray: Array<Boolean> = arrayOf(false, true)): Permutations<Boolean> {
            return create(inputArray)
        }
    }
}

