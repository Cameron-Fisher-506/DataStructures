package com.example.datastructures

fun main() {
    val singlyLinkedList = SinglyLinkedList<String>()
    singlyLinkedList.addFirst(SNode("Cameron"))
    singlyLinkedList.addFirst(SNode("Tyson"))
    singlyLinkedList.addFirst(SNode("Shane"))

    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
}

class SinglyLinkedList<T> {
    var head: SNode<T>? = null
    var size: Int = 0

    fun addFirst(n: SNode<T>) {
        n.next = head
        head = n
        size++
    }

    fun removeFirstOrNull(): SNode<T>? {
        val temp = head ?: return null
        head = temp.next
        temp.next = null
        size--
        return temp
    }

    fun isEmpty(): Boolean = size == 0
}

class SNode<T>(var element: T, var next: SNode<T>? = null)