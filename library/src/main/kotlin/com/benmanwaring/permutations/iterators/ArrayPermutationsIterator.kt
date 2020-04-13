package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.WrappedArray

internal class ArrayPermutationsIterator<T>(private val permutations: Iterator<WrappedArray<T>>) :
    Iterator<Array<T>> {

    constructor(
        inputArray: Iterable<T>,
        length: Int,
        arrayFactory: (length: Int, initialValue: T) -> Array<T>
    ) : this(
        PermutationIterator(
            inputArray,
            WrappedArray(arrayFactory.invoke(length, inputArray.first()))
        )
    )

    override fun hasNext(): Boolean {
        return permutations.hasNext()
    }

    override fun next(): Array<T> {
        return permutations.next().output()
    }
}

