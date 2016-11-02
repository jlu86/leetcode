package Week2.BinaryTreeVerticalOrderTraversal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Show Company Tags
Show Tags
Show Similar Problems

 * @author jielu
 *
 */

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class TreeWidth {
		int leftMostWidth;
		int rightMostWidth;
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		
		// Get the number of rows of the result, num(rows) = max depth of the
		// tree
		int rows = getDepth(root);

		// Get the number of columns of the result, num(columns) = widest left
		// width + widest right width + 1 (root)
		TreeWidth width = getWidth(root);
		int columns = width.leftMostWidth + width.rightMostWidth + 1;

		// Construct the result matrix and fill the value from the given tree
		TreeNode[][] result = new TreeNode[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = null;
			}
		}
		fillResultMatrix(result, root, 0, width.leftMostWidth);

		// Compute the result
		for (int j = 0; j < columns; j++) {
			List<Integer> column = new ArrayList<>();
			for (int i = 0; i < rows; i++) {
				TreeNode node = result[i][j];
				if (node != null) {
					if (node.left != null && node.right != null) {
						// two nodes share the same row and column
						column.add(node.left.val);
						column.add(node.right.val);
					} else {
						column.add(node.val);
					}
				}
			}

			list.add(column);
		}

		return list;
	}

	/**
	 * Fill the value of node to result[row][column] and fill the child tree
	 * recursively
	 */
	public void fillResultMatrix(TreeNode[][] result, TreeNode node, int row, int column) {
		if (node == null) {
			return;
		}

		TreeNode newTreeNode = null;
		// TreeNode newTreeNode = new TreeNode(node.val);
		if (result[row][column] != null) {
			// already filled left child before
			newTreeNode = new TreeNode(Integer.MIN_VALUE);
			newTreeNode.left = new TreeNode(result[row][column].val);
			newTreeNode.right = node;
		} else {
			newTreeNode = new TreeNode(node.val);
		}

		result[row][column] = newTreeNode;

		fillResultMatrix(result, node.left, row+1, column-1);
		fillResultMatrix(result, node.right, row+1, column+1);
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

	public TreeWidth getWidth(TreeNode root) {
		TreeWidth width = new TreeWidth();
		if (root == null) {
			width.leftMostWidth = -1;
			width.rightMostWidth = -1;
		} else {
			TreeWidth leftWidth = getWidth(root.left);
			TreeWidth rightWidth = getWidth(root.right);

			// Compute the leftmost width
			if (leftWidth.leftMostWidth >= rightWidth.leftMostWidth - 2) {
				width.leftMostWidth = leftWidth.leftMostWidth + 1;
			} else {
				width.leftMostWidth = rightWidth.leftMostWidth - 1;
			}
			// Compute the rightmost width
			if (rightWidth.rightMostWidth >= leftWidth.rightMostWidth - 2) {
				width.rightMostWidth = rightWidth.rightMostWidth + 1;
			} else {
				width.rightMostWidth = leftWidth.rightMostWidth - 1;
			}
		}

		return width;
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		TreeNode node20 = new TreeNode(20);
		node20.left = node15;
		node20.right = node7;
		TreeNode node9 = new TreeNode(9);
		TreeNode node3 = new TreeNode(3);
		node3.left = node9;
		node3.right = node20;
		
		List<List<Integer>> result = solution.verticalOrder(node3);
		assertEquals(4, result.size());	
	}

	@Test
	public void test2() {
		Solution solution = new Solution();
		TreeNode node4 = new TreeNode(4);
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node8 = new TreeNode(8);
		TreeNode node3 = new TreeNode(3);
		
		node3.left = node9;
		node3.right = node8;
		node9.left = node4;
		node9.right = node0;
		node8.left = node1;
		node8.right = node7;
		
		List<List<Integer>> result = solution.verticalOrder(node3);
		assertEquals(5, result.size());
	}
	
	@Test
	public void test3() {
		Solution solution = new Solution();
		TreeNode node4 = new TreeNode(4);
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node8 = new TreeNode(8);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		
		node3.left = node9;
		node3.right = node8;
		node9.left = node4;
		node9.right = node0;
		node8.left = node1;
		node8.right = node7;
		node0.right = node2;
		node1.left = node5;
		
		List<List<Integer>> result = solution.verticalOrder(node3);
		assertEquals(5, result.size());
	}
}
