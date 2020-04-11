package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface
import com.benmanwaring.permutations.arrays.WrappedArray
import com.benmanwaring.permutations.factory.PermutationsIteratorFactory

internal open class InternalGenericIterator<T>(
    inputArray: ArrayInterface<T>,
    holdingArray: Array<T>
) : PermutationsIterator<T, Array<T>, WrappedArray<T>>(
    inputArray,
    WrappedArray(holdingArray)
) {

    override fun unwrap(holdingArray: WrappedArray<T>): Array<T> {
        return holdingArray.charArray
    }

    companion object {

        fun <T> factory(init: (length: Int, initialValue: T) -> Array<T>): PermutationsIteratorFactory<T, Array<T>> {
            return object : PermutationsIteratorFactory<T, Array<T>> {
                override fun create(
                    inputArray: ArrayInterface<T>,
                    length: Int
                ): InternalGenericIterator<T> {
                    return InternalGenericIterator(
                        inputArray,
                        init.invoke(length, inputArray[0])
                    )
                }
            }
        }
    }
}

