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
 * Computational Complexity
 *
 * top(): O(1)
 * push(element: T): O(1)
 * pop(): O(1)
 */
class Stack<T> {
    private val storage: SinglyLinkedList<T> = SinglyLinkedList()

    fun top(): T? = storage.head?.element

    fun push(element: T) {
        storage.addFirst(SNode(element))
    }

    fun pop(): T? = storage.removeFirstOrNull()?.element

    fun size(): Int = storage.size

    fun isEmpty(): Boolean = storage.isEmpty()
}