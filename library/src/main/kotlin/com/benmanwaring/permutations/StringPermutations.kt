package com.benmanwaring.permutations

fun String.permutations(length: Int): Iterable<String> {
    return asIterable().permutations(length)
}

fun String.permutations(range: Iterable<Int>): Iterable<String> {
    return asIterable().permutations(range)
}

