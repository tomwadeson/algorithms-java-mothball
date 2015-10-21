package datastructures.trees

import spock.lang.*

class TreeSpec extends Specification {
    
    def root = 
        node("F",
            node("B",
                node("A"),
                node("D",
                    node("C"),
                    node("E"))),
            node("G",
                null,
                node("I",
                    node("H"),
                    null)))
                
        
    
    def tree = new Tree(root)

    void "should execute a pre-order traversal from the root"() {
        when:
        def traversal = tree.traversePreOrder()
        
        then:
        traversal == ["F", "B", "A", "D", "C", "E", "G", "I", "H"]
    }

    void "should execute an in-order traversal from the root"() {
        when:
        def traversal = tree.traverseInOrder()
        
        then:
        traversal == ["A", "B", "C", "D", "E", "F", "G", "H", "I"]
    }

    void "should execute a post-order traversal from the root"() {
        when:
        def traversal = tree.traversePostOrder()
        
        then:
        traversal == ["A", "C", "E", "D", "B", "H", "I", "G", "F"]
    }
    
    Node<String> node(String data) {
        node(data, null, null)
    }
    
    Node<String> node(String data, Node<String> left, Node<String> right) {
        new Node<String>(data, left, right)
    }
}