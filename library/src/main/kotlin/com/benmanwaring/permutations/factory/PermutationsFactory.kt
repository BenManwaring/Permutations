package com.benmanwaring.permutations.factory

internal interface PermutationsIterable<T> {

    fun create(length: Int): Iterator<T>
}
