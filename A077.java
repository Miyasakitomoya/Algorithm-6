package À„∑®6º∂;

import java.util.Scanner;

//Data structure to store a Binary Search Tree node


public class A077
{
// Recursive function to insert an key into BST
public static Node insert(Node root, int key) 
{
   // if the root is null, create a new node an return it
   if (root == null) {
       return new Node(key);
   }

   // if given key is less than the root node, recurse for left subtree
   if (key < root.data) {
       root.left = insert(root.left, key);
   }

   // if given key is more than the root node, recurse for right subtree
   else {
       root.right = insert(root.right, key);
   }

   return root;
}

// Helper function to find maximum value node in given BST
public static Node findMaximum(Node root) {
   while (root.right != null) {
       root = root.right;
   }

   return root;
}

// Recursive function to find in-order predecessor for given key in a BST
public static Node findPredecessor(Node root, Node prec, int key)
{
   // base case
   if (root == null) {
       return prec;
   }

   // if node with key's value is found, the predecessor is maximum value
   // node in its left subtree (if any)
   if (root.data == key) {
       if (root.left != null) {
           return findMaximum(root.left);
       }
   }

   // if given key is less than the root node, recurse for left subtree
   else if (key < root.data) {
       return findPredecessor(root.left, prec, key);
   }

   // if given key is more than the root node, recurse for right subtree
   else {
       // update predecessor to current node before recursing 
       // in right subtree
       prec = root;
       return findPredecessor(root.right, prec, key);
   }
   return prec;
}

// main function
public static void main(String[] args)
{
    Node root = null;
    
    /* Construct below tree
          15
         /  \
        /    \
       10     20
      / \     / \
     /   \   /   \
    8    12 16   25
    */

    int[] keys = {8, 10, 12, 15, 16, 20, 25};

    for (int key : keys) {
        root = insert(root, key);
    }

    // find in-order predecessor for each key
	     Scanner br=new Scanner(System.in);
	     int x=br.nextInt();
        Node prec = findPredecessor(root, null, x);

        if (prec != null) {
            System.out.println(prec.data);
        } else {
            System.out.println("no");
        }
    }
}