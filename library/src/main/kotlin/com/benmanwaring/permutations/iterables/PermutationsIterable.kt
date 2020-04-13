package com.benmanwaring.permutations.iterables

internal interface PermutationsIterable<T> {

    fun create(length: Int): Iterator<T>
}
