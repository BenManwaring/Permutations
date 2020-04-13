package com.benmanwaring.permutations.arrays

import com.benmanwaring.permutations.iterators.PermutationIterator

internal class UnwrappedStringPermutations(private val iterator: Iterator<WrappedCharArray>) :
    Iterator<String> {

    constructor(inputArray: CharArray, length: Int) : this(
        PermutationIterator(
            WrappedCharArray(inputArray),
            WrappedCharArray(length, inputArray[0])
        )
    )

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun next(): String {
        return iterator.next().output()
    }
}

