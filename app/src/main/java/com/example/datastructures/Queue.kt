package com.example.datastructures

fun main() {
    val queue: Queue<Int> = Queue()

    queue.enqueue(50)
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    println(queue.front() ?: "Empty")
    println(queue.back() ?: "Empty")
}

/**
 * Computational Complexity
 *
 * enqueue: O(1)
 * dequeue: O(n) we have to shift the elements to the front of the queue
 * front: O(1)
 * back: O(1)
 */
class Queue<T> {
    private val storage: SLinkedList<T> = SLinkedList()

    fun enqueue(element: T) = storage.addLast(element)

    fun dequeue(): T? = storage.removeFirstOrNull()?.element

    fun front(): T? = storage.head?.element

    fun back(): T? = storage.tail?.element

    fun size(): Int = storage.size

    fun isEmpty(): Boolean = storage.size == 0
}

class SLinkedList<T> {
    var head: SLLNode<T>? = null
    var tail: SLLNode<T>? = null
    var size: Int = 0

    fun addLast(element: T) {
        val node = SLLNode(element)
        if (size == 0) {
            head = node
        } else {
            tail?.next = node
        }
        tail = node
        size++
    }

    fun removeFirstOrNull(): SLLNode<T>? {
        val temp = head ?: return null

        head = temp.next
        temp.next = null
        size--
        if (size == 0) { tail = null }
        return temp
    }

    fun isEmpty(): Boolean = size == 0
}

class SLLNode<T>(var element: T, var next: SLLNode<T>? = null)