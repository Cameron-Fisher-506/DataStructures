package com.example.datastructures

fun main() {
    val doublyLinkedList = DoublyLinkedList()

    doublyLinkedList.addFirst(DNode("Cameron"))
    doublyLinkedList.addFirst(DNode("Tyson"))
    doublyLinkedList.addFirst(DNode("Shane"))

    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }

    doublyLinkedList.addFirst(DNode("Simone"))
    doublyLinkedList.addFirst(DNode("Fallon"))
    doublyLinkedList.addFirst(DNode("Ma"))

    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }
    doublyLinkedList.getFirstOrNull()?.let {
        println(doublyLinkedList.remove(it).element)
    }

}

class DoublyLinkedList {
    private val header: DNode = DNode()
    private val trailer: DNode = DNode()
    var size: Int = 0

    init {
        header.next = trailer
        trailer.previous = header
    }

    fun isEmpty(): Boolean = size == 0

    fun getFirstOrNull(): DNode? = if (!isEmpty()) header.next else null

    fun getLastOrNull(): DNode? = if (!isEmpty()) trailer.previous else null

    fun getPrevious(n: DNode): DNode? = if (n != header) n.previous else header

    fun getNext(n: DNode): DNode? = if (n != trailer) n.next else trailer

    fun addBefore(n: DNode, p: DNode) {
        val b = getPrevious(p)

        n.previous = b
        n.next = p
        p.previous = n
        b?.next = n
        size++
    }

    fun addAfter(n: DNode, p: DNode) {
        val a = getNext(p)

        n.next = a
        n.previous = p
        p.next = n
        a?.previous = n
        size++
    }

    fun addFirst(n: DNode) {
        addAfter(n, header)
    }

    fun addLast(n: DNode) {
        addBefore(n, trailer)
    }

    fun hasPrevious(n: DNode): Boolean = n != header

    fun hasNext(n: DNode): Boolean = n != trailer

    fun remove(n: DNode): DNode {
        val p = getPrevious(n)
        val m = getNext(n)

        m?.previous = p
        p?.next = m
        n.previous = null
        n.next = null
        size--
        return n
    }
}

class DNode(var element: String = "", var previous: DNode? = null, var next: DNode? = null)