package com.greatlearning.dsa.lab3.FindPairWithGivenSumInBST;

import java.util.HashSet;
import java.util.Set;

public class FindPairOfSum {
    static Node root;

    public FindPairOfSum()
    {
        root = null;
    }

    class Node
    {
        int data;
        Node left,right;

        public Node(int data)
        {
            super();
            this.data = data;
        }
    }

    void insertKey(int key)
    {
        root = insertNode(root,key);
    }

    Node insertNode(Node root, int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        if(key<root.data)
        {
            root.left = insertNode(root.left,key);
        }
        else if(key>root.data)
        {
            root.right = insertNode(root.right,key);
        }
        return root;
    }

    //Inorder Traversal
    void inOrder()
    {
        inOrderRect(root);
    }

    void inOrderRect(Node root)
    {
        if(root!=null)
        {
            inOrderRect(root.left);
            System.out.print(root.data + " ");
            inOrderRect(root.right);
        }
    }
    public static void main(String[] args) {
        FindPairOfSum tree = new FindPairOfSum();
        tree.insertKey(40);
        tree.insertKey(20);
        tree.insertKey(60);
        tree.insertKey(10);
        tree.insertKey(30);
        tree.insertKey(50);
        tree.insertKey(70);
        tree.inOrder();
        System.out.println();
        int sum = 60;
        tree.findPairWithGivenSum(root,sum);
    }
    void findPairWithGivenSum(Node root,int sum)
    {
        Set<Integer> set = new HashSet<>();
        if(!findPairUtil(root,sum,set))
            System.out.println("Pairs do not exist" + "\n");
    }

    private boolean findPairUtil(Node root, int sum, Set<Integer> set)
    {
        if(root == null)
            return false;

        if(findPairUtil(root.left,sum,set))
            return true;

        if(set.contains(sum - root.data))
        {
            System.out.println("Pair is found (" + (sum - root.data) + "," + root.data + ")");
            return true;
        }else
            set.add(root.data);
        return false;
    }
}
