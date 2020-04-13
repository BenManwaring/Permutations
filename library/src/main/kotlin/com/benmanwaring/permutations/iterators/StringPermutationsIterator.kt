package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.WrappedCharArray

internal class StringPermutationsIterator(private val iterator: Iterator<WrappedCharArray>) :
    Iterator<String> {

    constructor(charArray: CharArray, length: Int) : this(
        PermutationIterator(
            WrappedCharArray(charArray),
            WrappedCharArray(length, charArray.first())
        )
    )

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun next(): String {
        return iterator.next().output()
    }
}

