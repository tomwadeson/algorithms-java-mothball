package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    
    private final Node<T> root;
    
    public Tree(Node<T> root) {
        this.root = root;
    }
    
    public List<T> traversePreOrder() {
        return traversePreOrder(root, new ArrayList<>());
    }
    
    private List<T> traversePreOrder(Node<T> root, List<T> traversal) {
        if (root == null)
            return traversal;
        
        traversal.add(root.getData());
        traversePreOrder(root.getLeft(), traversal);
        traversePreOrder(root.getRight(), traversal);
        
        return traversal;
    }
    
    public List<T> traverseInOrder() {
        return traverseInOrder(root, new ArrayList<>());
    }
    
    private List<T> traverseInOrder(Node<T> root, List<T> traversal) {
        if (root == null)
            return traversal;
        
        traverseInOrder(root.getLeft(), traversal);
        traversal.add(root.getData());
        traverseInOrder(root.getRight(), traversal);
        
        return traversal;
    }
    
    public List<T> traversePostOrder() {
        return traversePostOrder(root, new ArrayList<>());
    }
    
    private List<T> traversePostOrder(Node<T> root, List<T> traversal) {
        if (root == null)
            return traversal;
        
        traversePostOrder(root.getLeft(), traversal);
        traversePostOrder(root.getRight(), traversal);
        traversal.add(root.getData());
        
        return traversal;
    }
}