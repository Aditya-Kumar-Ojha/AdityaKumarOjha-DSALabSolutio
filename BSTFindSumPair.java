/**
 * 
 */
package com.GreatLearning.demo;

import java.util.HashSet;

/**
 * @author akojha
 *
 */
public class BSTFindSumPair {

	/**
	 * @param args
	 */
	
	static class Node {
        int NodeData;
        Node leftNode, rightNode;
    };
    
    static Node NewNode(int NodeData)
    {
        Node tempNode = new Node();
        tempNode.NodeData =NodeData;
        tempNode.leftNode = null;
        tempNode.rightNode = null;
        return tempNode;
    }
 
    static Node insert(Node root, int key)
    {
        if (root == null)
            return NewNode(key);
        if (key < root.NodeData)
            root.leftNode = insert(root.leftNode, key);
        else
            root.rightNode = insert(root.rightNode, key);
        return root;
    }
 
    static boolean findpair(Node root, int sum,
                                HashSet<Integer> set)
    {
        if (root == null)
            return false;
 
        if (findpair(root.leftNode, sum, set))
            return true;
 
        if (set.contains(sum - root.NodeData)) {
            System.out.println("\n Pair is found ("
                               + (sum - root.NodeData) + ", "
                               + root.NodeData + ")");
            return true;
        }
        else
            set.add(root.NodeData);
 
        return findpair(root.rightNode, sum, set);
    }
 
    static void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findpair(root, sum, set))
            System.out.print("Pairs do not exit"
                             + "\n");
    }
 
    // Driver code
    public static void main(String[] args) {
		// TODO Auto-generated method stub

        Node root = null;
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 50);
        root = insert(root, 70);
      
 
        int sum = 100;
        findPair(root, sum);
    }
}
