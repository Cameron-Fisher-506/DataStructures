package com.example.datastructures

fun main() {
    val singlyLinkedList = SinglyLinkedList()
    singlyLinkedList.addFirst(SNode("Cameron"))
    singlyLinkedList.addFirst(SNode("Tyson"))
    singlyLinkedList.addFirst(SNode("Shane"))

    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
    println(singlyLinkedList.removeFirstOrNull()?.element)
}

class SinglyLinkedList() {
    var head: SNode? = null
    private var size: Long = 0

    fun addFirst(n: SNode) {
        n.next = head
        head = n
        size++
    }

    fun removeFirstOrNull(): SNode? {
        val temp = head ?: return null
        head = temp.next
        temp.next = null
        size--
        return temp
    }
}

class SNode(var element: String = "", var next: SNode? = null)