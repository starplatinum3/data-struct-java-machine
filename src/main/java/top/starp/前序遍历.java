package top.starp;//package test;
//前序遍历的递归实现与非递归实现

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 前序遍历 {

static 	TreeNode[] buildTree(   int[] nodeNums){
		TreeNode[] nodes = new TreeNode[nodeNums.length];
		int i = 0;
		for (int nodeNum : nodeNums) {
			nodes[i++] = new TreeNode(nodeNum);
		}
		System.out.println("nodeNums.length");
		System.out.println(nodeNums.length);

//		for (int j = 0; j < nodeNums.length; j++) {
//			nodes[j] = new TreeNode(nodeNums[j]);
//		}
		for (int j = 0; j < nodeNums.length; j++) {
			if (j * 2 + 1 < nodeNums.length)
				nodes[j].left = nodes[j * 2 + 1];
			if (j * 2 + 2 < nodeNums.length)
				nodes[j].right = nodes[j * 2 + 2];
		}
		return nodes;
	}

	/**
	 * nodeNums.length
	 * 11
	 * preVals
	 * [8, 3, 1, 6, 4, 7, 10, 14]
	 * midVals
	 * [1, 3, 4, 6, 7, 8, 10, 14]
	 * postVals
	 * [1, 4, 7, 6, 3, 14, 10, 8]
	 */
	static void init3(){
		int[] nodeNums = new int[]{8,
				3, 10,
				1, 6, -1, 14,
				-1, nodeNullVal, 4, 7
		};
		TreeNode[] treeNodes = buildTree(nodeNums);
		orderPrint(treeNodes[0]);

	}

	static  void orderPrint(TreeNode root){
		List<Integer> preVals = new ArrayList<>();
		List<Integer> midVals = new ArrayList<>();
		List<Integer> postVals = new ArrayList<>();
//        preOrderRe(node[0]);
		preOrderRe(root, preVals);
		midOrderRe(root, midVals);
		postOrderRe(root, postVals);

		System.out.println("preVals");
		System.out.println(preVals);
		System.out.println("midVals");
		System.out.println(midVals);
		System.out.println("postVals");
		System.out.println(postVals);
	}
    static void init() {
//		List<TreeNode >nodes=new ArrayList<>();
//		nodes.add(new TreeNode(40));
//		nodes.add(40);
//		nodes.add(40);
//		nodes.add(40);

//        int[] nodeNums = new int[]{40, 35, 70, 30, 39, 20, 34, 10, 5};
        int[] nodeNums = new int[]{40,
				35, 70,
				30, 39, -1, -1,
				20, 34, -1, -1, -1, -1, -1, -1,
				10,
				-1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1,
				5};



//		TreeNode[] nodes = new TreeNode[]{new TreeNode(40),};
        TreeNode[] nodes = new TreeNode[nodeNums.length];
        int i = 0;
        for (int nodeNum : nodeNums) {
            nodes[i++] = new TreeNode(nodeNum);
        }
        System.out.println("nodeNums.length");
        System.out.println(nodeNums.length);

//		for (int j = 0; j < nodeNums.length; j++) {
//			nodes[j] = new TreeNode(nodeNums[j]);
//		}
        for (int j = 0; j < nodeNums.length; j++) {
            if (j * 2 + 1 < nodeNums.length)
                nodes[j].left = nodes[j * 2 + 1];
            if (j * 2 + 2 < nodeNums.length)
                nodes[j].right = nodes[j * 2 + 2];
        }


//        没问题吧 建树
//		System.out.println("printFamily");
//		for (TreeNode node : nodes) {
//			System.out.println("===============");
//			node.printFamily();
//		}
        TreePrintUtil.pirnt(nodes[0]);

//        preOrderRe(nodes[0]);

        List<Integer> preVals = new ArrayList<>();
        List<Integer> midVals = new ArrayList<>();
        List<Integer> postVals = new ArrayList<>();
//        preOrderRe(node[0]);
        preOrderRe(nodes[0], preVals);
        midOrderRe(nodes[0], midVals);
        postOrderRe(nodes[0], postVals);

        System.out.println("preVals");
        System.out.println(preVals);
        System.out.println("midVals");
        System.out.println(midVals);
        System.out.println("postVals");
        System.out.println(postVals);
    }

    void init2() {
        TreeNode[] node = new TreeNode[10];//以数组形式生成一棵完全二叉树

        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }

//        List<Integer>preVals=new ArrayList<>();
        preOrderRe(node[0]);
//        preOrderRe(node[0],preVals);
    }

    public static void main(String[] args) {
//        init();
		init3();
    }

    public static void postOrderRe(TreeNode biTree, List<Integer> vals) {//后序遍历递归实现
        if (biTree == null)
            return;
        else {
            postOrderRe(biTree.left, vals);
            postOrderRe(biTree.right, vals);
//			System.out.println(biTree.value);
            if (biTree.value != nodeNullVal) {
                vals.add(biTree.value);
            }

        }
    }


    public static void midOrderRe(TreeNode biTree, List<Integer> vals) {//中序遍历递归实现
        if (biTree == null)
            return;
        else {
            midOrderRe(biTree.left, vals);
//			System.out.println(biTree.value);
//			vals.add(biTree.value);
            if (biTree.value != nodeNullVal) {
                vals.add(biTree.value);
            }
            midOrderRe(biTree.right, vals);
        }
    }


    public static void midOrder(TreeNode biTree) {//中序遍历费递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.println(biTree.value);
                biTree = biTree.right;
            }
        }
    }

    public static void preOrderRe(TreeNode biTree) {//递归实现
        if (biTree.value != -1) {
            System.out.println(biTree.value);
//			vals.add(biTree.value);
        }

//        System.out.println(biTree.value==-1?);
        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    static int nodeNullVal = -1;

    public static void preOrderRe(TreeNode biTree, List<Integer> vals) {//递归实现
        if (biTree.value != -1) {
//			System.out.println(biTree.value);
            vals.add(biTree.value);
        }

//        System.out.println(biTree.value==-1?);
        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree, vals);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree, vals);
        }
    }

    public static void preOrder(TreeNode biTree) {//非递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }

    public static void levelOrder(TreeNode biTree) {//层次遍历
        if (biTree == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(biTree);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.println(currentNode.value);
            if (currentNode.left != null)
                list.add(currentNode.left);
            if (currentNode.right != null)
                list.add(currentNode.right);
        }
    }
}

//class TreeNode//节点结构
//{
//	int value;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int value)
//	{
//		this.value = value;
//	}
//}
//

