package com.example.datastructures

fun main() {
    val queue: Queue<Int> = Queue()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()

    println(queue.front() ?: "Empty")
    println(queue.back() ?: "Empty")
}

/**
 * Computational Complexity
 *
 * enqueue: O(1)
 * dequeue: O(1)
 * front: O(1)
 * back: O(1)
 */
class Queue<T> {
    private val storage: ArrayList<T> = arrayListOf()

    fun enqueue(value: T) = storage.add(value)

    fun dequeue(): T? = storage.removeFirstOrNull()

    fun front(): T? = storage.firstOrNull()

    fun back(): T? = storage.lastOrNull()
}