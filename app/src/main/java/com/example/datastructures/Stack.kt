package com.example.datastructures

fun main() {
    val stack = Stack<Int>()
    stack.push(1)

    println(stack.top())
    println(stack.pop())
    println(stack.pop())
    println(stack.size())
}

/**
 * top(): O(1)
 * push(value: T): O(1)
 * pop(): O(1)
 */
class Stack<T> {
    private val storage: ArrayList<T> = ArrayList()

    fun top(): T? = storage.lastOrNull()

    fun push(value: T) {
        storage.add(value)
    }

    fun pop(): T? = storage.removeLastOrNull()

    fun size(): Int = storage.size
}