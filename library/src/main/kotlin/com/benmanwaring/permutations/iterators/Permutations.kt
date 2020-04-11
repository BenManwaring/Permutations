package com.benmanwaring.permutations.iterators

import com.benmanwaring.permutations.arrays.ArrayInterface

internal open class Permutations<T> private constructor(
    private val inputArray: ArrayInterface<T>,
    private val outputArray: ArrayInterface<T>,
    private val outputArrayIndex: Int
) {

    private val subPermutations: Permutations<T>? = if (outputArrayIndex + 1 < outputArray.size) {
        Permutations(inputArray, outputArray, outputArrayIndex + 1)
    } else {
        null
    }

    private var currentInputArrayIndex = 0

    constructor(inputArray: ArrayInterface<T>, holdingArray: ArrayInterface<T>) :
            this(inputArray, holdingArray, 0)

    open fun hasNext(): Boolean {
        return when {
            subPermutations != null && subPermutations.hasNext() -> {
                true
            }
            currentInputArrayIndex < inputArray.size - 1 -> {
                true
            }
            else -> {
                false
            }
        }
    }

    fun increment(): Boolean {
        return when {
            subPermutations != null && subPermutations.increment() -> {
                true
            }
            currentInputArrayIndex < inputArray.size - 1 -> {
                currentInputArrayIndex++
                outputArray[outputArrayIndex] = inputArray[currentInputArrayIndex]
                true
            }
            else -> {
                currentInputArrayIndex = 0
                outputArray[outputArrayIndex] = inputArray[currentInputArrayIndex]
                false
            }
        }
    }
}

