package com.benmanwaring.permutations.arrays

internal class WrappedCharArray(private val charArray: CharArray) : ArrayInterface<Char> {

    constructor(length: Int, initialValue: Char) : this(CharArray(length) { initialValue })

    override val size: Int get() = charArray.size

    override fun set(index: Int, value: Char) {
        charArray[index] = value
    }

    override fun iterator(): Iterator<Char> {
        return charArray.iterator()
    }

    fun output(): String {
        return String(charArray)
    }
}
