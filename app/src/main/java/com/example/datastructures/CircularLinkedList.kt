package com.example.datastructures

fun main() {
    val circularLinkedList = CircularLinkedList()
    circularLinkedList.add(CNode("Cameron"))
    circularLinkedList.add(CNode("Tyson"))
    circularLinkedList.add(CNode("Shane"))

    println(circularLinkedList.advance())
    println("Cursor: ${circularLinkedList.cursor?.element}")

    println(circularLinkedList.remove()?.element)
    println(circularLinkedList.remove()?.element)
    println(circularLinkedList.remove()?.element)
    println(circularLinkedList.remove()?.element)
}

class CircularLinkedList {
    var cursor: CNode? = null
    var size: Int = 0

    fun advance() {
        cursor = cursor?.next
    }

    fun add(n: CNode) {
        if (cursor == null) {
            n.next = n
            cursor = n
        } else {
            n.next = cursor?.next
            cursor?.next = n
        }
        size++
    }

    fun remove(): CNode? {
        val nodeToRemove = cursor?.next
        if (nodeToRemove == cursor) {
            cursor = null
        } else {
            cursor?.next = nodeToRemove?.next
            nodeToRemove?.next = null
        }
        size--
        return nodeToRemove
    }
}

class CNode(var element: String = "", var next: CNode? = null)
