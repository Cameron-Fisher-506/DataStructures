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

    fun add(value: Int) {
        if (storage.isEmpty()) {
            storage = Array(1) { 0 }
        }

        if (size == storage.size) {
            val tempArray: Array<Int> = Array(storage.size + 1) { 0 }
            for (i in storage.indices) {
                tempArray[i] = storage[i]
            }
            storage = tempArray
        }

        storage[size] = value
        size++
    }
}
