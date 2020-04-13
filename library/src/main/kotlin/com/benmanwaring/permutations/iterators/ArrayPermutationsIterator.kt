package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.WrappedArray

internal class ArrayPermutationsIterator<T>(private val permutations: Iterator<WrappedArray<T>>) :
    Iterator<Array<T>> {

    constructor(
        inputArray: Array<T>,
        length: Int,
        arrayInit: (length: Int, initialValue: T) -> Array<T>
    ) : this(
        PermutationIterator(
            WrappedArray(inputArray),
            WrappedArray(arrayInit.invoke(length, inputArray.first()))
        )
    )

    override fun hasNext(): Boolean {
        return permutations.hasNext()
    }

    override fun next(): Array<T> {
        return permutations.next().output()
    }
}

