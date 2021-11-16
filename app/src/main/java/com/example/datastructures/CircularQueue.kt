package com.example.datastructures

fun main() {
    val circularQueue: CircularQueue = CircularQueue(3)
    circularQueue.enqueue(15)
    circularQueue.enqueue(5)
    circularQueue.enqueue(235)

    println(circularQueue.dequeue())
    circularQueue.enqueue(325)
    println(circularQueue.dequeue())
    println(circularQueue.dequeue())
}

class CircularQueue(var size: Int = 0) {
    private var front: Int = -1
    private var rear: Int = -1
    private var storage: Array<Int> = Array(size) { 0 }

    private fun isEmpty(): Boolean = front == -1

    private fun isFull(): Boolean = front == (rear + 1) % size

    fun peek(): Int = front

    fun enqueue(element: Int) {
        if (!isFull()) {
            if (front == -1) {
                front = 0
            }
            rear = (rear + 1) % size
            storage[rear] = element
        }
    }

    fun dequeue(): Int {
        if (!isEmpty()) {
            val element = storage[front]
            storage[front] = 0

            if (front == rear) {
                front = -1
                rear = -1
            } else {
                front = (front + 1) % size
            }
            return element
        }
        return -1
    }
}