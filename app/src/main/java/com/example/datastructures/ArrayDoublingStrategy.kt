package com.example.datastructures

fun main() {
    val arrayDoublingStrategy: ArrayDoublingStrategy = ArrayDoublingStrategy()
    arrayDoublingStrategy.add(10)
    arrayDoublingStrategy.add(20)
    arrayDoublingStrategy.add(30)
    arrayDoublingStrategy.add(40)
    arrayDoublingStrategy.add(40)

    arrayDoublingStrategy.removeAll()
    println(arrayDoublingStrategy.size())
}

class ArrayDoublingStrategy {
    private var storage: Array<Int> = Array(0) { 0 }
    private var size: Int = 0

    fun add(value: Int) {
        if (storage.isEmpty()) {
            storage = Array(1) { 0 }
        }

        if (size == storage.size) {
            val tempArray: Array<Int> = Array(storage.size * 2) { 0 }
            for (i in storage.indices) {
                tempArray[i] = storage[i]
            }
            storage = tempArray
        }

        storage[size] = value
        size++
    }

    fun removeAtOrNull(index: Int): Int? {
        return when {
            size == 0 -> null
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
            size == 0 -> null
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

    fun removeAll() {
        for (i in storage.indices) { storage[i] = 0 }
        size = 0
    }
}
