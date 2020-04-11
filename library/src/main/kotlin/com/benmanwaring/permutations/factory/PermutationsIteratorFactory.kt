package com.benmanwaring.permutations.factory

import com.benmanwaring.permutations.arrays.ArrayInterface
import com.benmanwaring.permutations.iterators.PermutationsIterator

internal interface PermutationsIteratorFactory<T, R> {

    fun create(inputArray: ArrayInterface<T>, length: Int): PermutationsIterator<T, R, *>
}
