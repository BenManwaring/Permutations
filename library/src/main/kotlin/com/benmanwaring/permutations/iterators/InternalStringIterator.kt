package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface
import com.benmanwaring.permutations.arrays.WrappedCharArray
import com.benmanwaring.permutations.factory.PermutationsIteratorFactory

internal class InternalStringIterator : PermutationsIterator<Char, String, WrappedCharArray> {

    constructor(inputArray: CharArray, length: Int) : this(WrappedCharArray(inputArray), length)

    private constructor(inputArray: ArrayInterface<Char>, length: Int) : super(
        inputArray,
        WrappedCharArray(CharArray(length) { inputArray[0] })
    )

    override fun unwrap(holdingArray: WrappedCharArray): String {
        return holdingArray.toString()
    }

    companion object {

        val FACTORY = object :
            PermutationsIteratorFactory<Char, String> {
            override fun create(
                inputArray: ArrayInterface<Char>,
                length: Int
            ): InternalStringIterator {
                return InternalStringIterator(
                    inputArray,
                    length
                )
            }
        }
    }
}

