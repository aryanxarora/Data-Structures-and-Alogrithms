/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

/**
 *
 * @author 2219549
 */

class Node {
    int key;
    Node left, right;
    
    Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    
    Node root;
    
    public BinaryTree(){
        root = null;
    }
    
    public void addNode(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        } else {
            Node pointer = root;
            while(true){
                if(newNode.key > pointer.key){
                    if(pointer.right == null){
                        pointer.right = newNode;
                        break;
                    } else {
                        pointer = pointer.right;
                    }
                }
                else if(newNode.key < pointer.key){
                    if(pointer.left == null){
                        pointer.left = newNode;
                        break;
                    } else {
                        pointer = pointer.left;
                    }
                }
            }
        }
    }
    
    public int isBST(Node node){
        if(node == null){
            return 1;
        } else {
            if(node.left != null && node.left.key < node.key){
                node = node.left;
            } else {
                return 0;
            }
            if(node.right != null && node.right.key > node.key){
                node = node.right;
            } else {
                return 0;
            }
        }
        return 1;
    }
    
    // pre-order traversal
    public void print(Node node){
        if(node == null){
            return;
        } else {
            System.out.println(node.key + " ");
            print(node.left);
            print(node.right);
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
//        tree.addNode(10);
//        tree.addNode(6);
//        tree.addNode(20);
//        tree.addNode(4);
//        tree.addNode(8);
//        tree.addNode(2);
//        tree.addNode(3);
//        tree.addNode(9);
//        tree.addNode(15);
//        tree.addNode(25);
//        tree.addNode(17);
//        tree.addNode(23);
//        tree.addNode(30);

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(30);
        
        tree.print(tree.root);
        
        if(tree.isBST(tree.root) == 1){
            System.out.println("Is BST");
        } else {
            System.out.println("Not BST");
        }
    }
    
}
