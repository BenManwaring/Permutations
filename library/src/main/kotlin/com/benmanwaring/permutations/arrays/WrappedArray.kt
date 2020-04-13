package com.benmanwaring.permutations.arrays

internal class WrappedArray<T>(private val array: Array<T>) : ArrayInterface<T> {

    override val size: Int get() = array.size

    override fun get(index: Int): T {
        return array[index]
    }

    override fun set(index: Int, value: T) {
        array[index] = value
    }

    fun output(): Array<T> {
        return array
    }
}
