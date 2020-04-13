package com.benmanwaring.permutations.arrays

internal interface ArrayInterface<T> : Iterable<T> {

    val size: Int

    operator fun set(index: Int, value: T)
}
