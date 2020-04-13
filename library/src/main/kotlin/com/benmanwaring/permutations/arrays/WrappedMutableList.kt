package com.benmanwaring.permutations.arrays

internal class WrappedMutableList<T>(private val array: MutableList<T>) : ArrayInterface<T> {

    override val size: Int get() = array.size

    override fun set(index: Int, value: T) {
        array[index] = value
    }

    fun output(): List<T> {
        return array
    }
}
