package com.benmanwaring.permutations.arrays

internal class WrappedCharArray(private val charArray: CharArray) : ArrayInterface<Char> {

    override val size: Int get() = charArray.size

    override fun get(index: Int): Char {
        return charArray[index]
    }

    override fun set(index: Int, value: Char) {
        charArray[index] = value
    }

    override fun toString(): String {
        return String(charArray)
    }
}
