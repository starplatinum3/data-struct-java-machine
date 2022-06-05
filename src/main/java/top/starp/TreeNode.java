package top.starp;

public class TreeNode implements TreePrintUtil.TreeNode
//节点结构
{

	public  void printFamily(){
		System.out.println("value");
		System.out.println(value);
		System.out.println("left.value");
		System.out.println(left==null?"null":left.value);
		System.out.println("right.value");
		System.out.println(right==null?"null":right.value);
	}

	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value)
	{
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}


	@Override
	public String getPrintInfo() {

		return toString();
	}

	@Override
	public TreePrintUtil.TreeNode getLeftChild() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public TreePrintUtil.TreeNode getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}
}
