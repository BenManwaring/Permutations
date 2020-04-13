package com.benmanwaring.permutations.arrays

import com.benmanwaring.permutations.iterators.PermutationIterator

internal class UnwrappedArrayPermutations<T>(private val permutations: Iterator<WrappedArray<T>>) :
    Iterator<Array<T>> {

    constructor(
        inputArray: Array<T>,
        length: Int,
        arrayInit: (length: Int, initialValue: T) -> Array<T>
    ) : this(WrappedArray(inputArray), length, arrayInit)

    constructor(
        inputArray: WrappedArray<T>,
        length: Int,
        arrayInit: (length: Int, initialValue: T) -> Array<T>
    ) : this(
        PermutationIterator(
            inputArray,
            WrappedArray(arrayInit.invoke(length, inputArray[0]))
        )
    )

    override fun hasNext(): Boolean {
        return permutations.hasNext()
    }

    override fun next(): Array<T> {
        return permutations.next().output()
    }
}

