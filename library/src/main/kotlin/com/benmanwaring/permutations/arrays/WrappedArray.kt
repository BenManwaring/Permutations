package com.benmanwaring.permutations.arrays

internal class WrappedArray<T>(private val array: Array<T>) : ArrayInterface<T> {

    override val size: Int get() = array.size

    override fun set(index: Int, value: T) {
        array[index] = value
    }

    override fun iterator(): Iterator<T> {
        return array.iterator()
    }

    fun output(): Array<T> {
        return array
    }
}
