package com.benmanwaring.permutations.arrays

internal class WrappedArray<T>(val charArray: Array<T>) : ArrayInterface<T> {

    override val size: Int get() = charArray.size

    override fun get(index: Int): T {
        return charArray[index]
    }

    override fun set(index: Int, value: T) {
        charArray[index] = value
    }
}
