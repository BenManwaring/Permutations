package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.WrappedMutableList

internal class ListPermutationsIterator<T>(private val permutations: Iterator<WrappedMutableList<T>>) :
    Iterator<List<T>> {

    constructor(
        inputArray: Iterable<T>,
        length: Int,
        mutableListFactory: (length: Int, initialValue: T) -> MutableList<T>
    ) : this(
        PermutationIterator(
            inputArray,
            WrappedMutableList(mutableListFactory.invoke(length, inputArray.first()))
        )
    )

    override fun hasNext(): Boolean {
        return permutations.hasNext()
    }

    override fun next(): List<T> {
        return permutations.next().output()
    }
}

