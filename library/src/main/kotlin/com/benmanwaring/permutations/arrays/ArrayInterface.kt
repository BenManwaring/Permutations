package com.benmanwaring.permutations.arrays

internal interface ArrayInterface<T> {

    val size: Int

    operator fun get(index: Int): T

    operator fun set(index: Int, value: T)
}
