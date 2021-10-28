package com.example.datastructures

fun main() {
    findPathsToLeafNodes(buildTree()).forEach { println(it) }
}

private fun findPathsToLeafNodes(node: Node<Int>, result: MutableList<List<Int>> = mutableListOf(), path: MutableList<Int> = mutableListOf()): MutableList<List<Int>> {
    path.add(node.value)
    if (!node.hasChildren()) {
        result.add(path.map { it })
        path.removeLast()
    } else {
        node.children.forEach { findPathsToLeafNodes(it, result, path) }
        path.removeLast()
    }
    return result
}

private fun buildTree(): Node<Int> {
    val root = Node(1)
    val nodeTwo = Node(2)
    val nodeThree = Node(3)
    val nodeFour = Node(4)
    val nodeFive = Node(5)
    val nodeSix = Node(6)
    val nodeSeven = Node(7)
    val nodeEight = Node(8)
    val nodeNine = Node(9)
    val nodeTen = Node(10)
    val nodeEleven = Node(11)

    root.addChild(nodeTwo)
    nodeTwo.addChild(nodeFive)
    nodeTwo.addChild(nodeSix)
    nodeTwo.addChild(nodeSeven)

    root.addChild(nodeThree)
    nodeThree.addChild(nodeEight)

    root.addChild(nodeFour)
    nodeFour.addChild(nodeNine)
    nodeFour.addChild(nodeTen)
    nodeFour.addChild(nodeEleven)

    return root
 }

class Node<T>(var value: T) {
    var parent: Node<T>? = null
    var children: MutableList<Node<T>> = mutableListOf()

    fun addChild(node: Node<T>) {
        node.parent = this
        children.add(node)
    }

    fun hasChildren(): Boolean = children.size >= 1
}