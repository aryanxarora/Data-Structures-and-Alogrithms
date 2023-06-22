/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanbox;

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
            System.out.print(node.key + " ");
            print(node.left);
            print(node.right);
        }
    }
    
    public boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        if(Math.abs(left - right) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        return Math.max(left, right) + 1;
    }
    
    public void getMinNode(Node node){
        if(node.left == null){
            System.out.println("Minimum node: " + node.key);
        } else {
            getMinNode(node.left);
        }
    }
    
    public Node sortedArraytoBalancedBST(int[] arr, int left, int right){
        if(left > right){
            return null;
        }
        
        int mid = left + (right - left)/2;
        Node root = new Node(arr[mid]);
        root.left = sortedArraytoBalancedBST(arr, left, mid-1);
        root.right = sortedArraytoBalancedBST(arr, mid + 1, right);
        
        return root;
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

//        tree.root = new Node(10);
//        tree.root.left = new Node(5);
//        tree.root.right = new Node(30);
        
//        tree.print(tree.root);
//        
//        if(tree.isBST(tree.root) == 1){
//            System.out.println("Is BST");
//        } else {
//            System.out.println("Not BST");
//        }

        tree.root = new Node (1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        if(tree.isBalanced(tree.root)){
            System.out.println("Tree is Balanced");
        } else {
            System.out.println("Tree is Not Balanced");
        }
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node bst = tree.sortedArraytoBalancedBST(arr, 0, arr.length - 1);
        tree.print(bst);
        System.out.println("");
        tree.getMinNode(bst);
    }
    
}