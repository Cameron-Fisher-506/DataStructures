package com.example.datastructures

fun main() {
    val arrayIncrementalStrategy: ArrayIncrementalStrategy = ArrayIncrementalStrategy()
    arrayIncrementalStrategy.add(10)
    arrayIncrementalStrategy.add(20)
    arrayIncrementalStrategy.add(30)
    arrayIncrementalStrategy.add(40)
    arrayIncrementalStrategy.add(40)
    arrayIncrementalStrategy.add(40)

    println(arrayIncrementalStrategy.storage.size)
    println(arrayIncrementalStrategy.size)
}

class ArrayIncrementalStrategy {
    var storage: Array<Int> = Array(0) { 0 }
    var size: Int = 0

    companion object {
        private const val INCREMENTAL_SIZE = 1
    }

    fun add(value: Int) {
        if (storage.isEmpty()) {
            storage = Array(10) { 0 }
        }

        if (size == storage.size) {
            val tempArray: Array<Int> = Array(storage.size + INCREMENTAL_SIZE) { 0 }
            for (i in storage.indices) {
                tempArray[i] = storage[i]
            }
            storage = tempArray
        }

        storage[size] = value
        size++
    }

    fun remove(index: Int): Int? {
        return when {
            isEmpty() -> null
            index in 0 until size -> {
                val value = storage[index]
                storage[index] = 0

                val tempArray: Array<Int> = Array(storage.size) { 0 }
                var j = 0
                for (i in storage.indices) {
                    if (storage[i] != 0) {
                        tempArray[j] = storage[i]
                        j++
                    }
                }
                storage = tempArray
                size--
                value
            }
            else -> null
        }
    }

    fun size(): Int = size

    fun get(index: Int): Int? {
        return when {
            isEmpty() -> null
            index in 0 until size -> {
                storage[index]
            }
            else -> null
        }
    }

    fun set(index: Int, value: Int) {
        if (index in 0 until size) {
            storage[index] = value
        }
    }

    fun isEmpty(): Boolean = size == 0
}
