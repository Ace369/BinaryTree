import java.util.ArrayList;
/**
 *	Binary Tree of Comparable values.
 *	The tree only has unique values. It does not add duplicate values.
 *	
 *	@author	Aditi Chamarthy
 *	@since	May 14, 2024
 */
public class BinaryTree<E extends Comparable<E>> {

	private TreeNode<E> root;		// the root of the tree
	
	private final int PRINT_SPACES = 3;	// print spaces between tree levels
										// used by printTree()
	
	/**	constructor for BinaryTree */
	public BinaryTree() {
		root = null;
	}
	
	/**	Field accessors and modifiers */
	
	/**	Add a node to the tree
	 *	@param value		the value to put into the tree
	 */
	 //Complete
	public void add(E value) {
		if(root == null){
			root = new TreeNode<E>(value, null, null);
		}
		else{
			boolean next = true;
			TreeNode<E> now = root;
			while(next){
				if(value.compareTo(now.getValue()) > 0){
					if(now.getRight() == null){
						now.setRight(new TreeNode<E>(value, null, null));
						next = false;
					}
					else{
						now = now.getRight();
					}
				}
				else if(value.compareTo(now.getValue()) < 0){
					if(now.getLeft() == null){
						now.setLeft(new TreeNode<E>(value, null, null));
						next = false;
					}
					else{
						now = now.getLeft();
					}
				}
			}
		}
	}
	
	/**
	 *	Print Binary Tree Inorder
	 */
	public void printInorder() {
		ArrayList<TreeNode<E>> nodeList = new ArrayList<TreeNode<E>>();
		TreeNode<E> temp = root;
		while(nodeList.size() > 0 || temp != null){
			while(temp != null){
				nodeList.add(temp);
				temp = temp.getLeft();
			}
			do{
				temp = nodeList.get(nodeList.size()-1);
				nodeList.remove(nodeList.size()-1);
				System.out.print(temp.getValue() + " ");
			}while(temp != null && temp.getRight() == null && nodeList.size() > 0);
			
			temp = temp.getRight();
		} 
		
		
	}
	
	/**
	 *	Print Binary Tree Preorder
	 */
	public void printPreorder() {
		ArrayList<TreeNode<E>> nodeList = new ArrayList<TreeNode<E>>();
		TreeNode<E> temp = root;
		while(nodeList.size() > 0 || temp != null){
			while(temp != null){
				System.out.print(temp.getValue() + " ");
				nodeList.add(temp);
				temp = temp.getLeft();
			}
			do{
				temp = nodeList.get(nodeList.size()-1);
				nodeList.remove(nodeList.size()-1);
			}while(temp != null && temp.getRight() == null && nodeList.size() > 0);
			
			temp = temp.getRight();
		}
	}
	
	/**
	 *	Print Binary Tree Postorder
	 */
	public void printPostorder() {
		ArrayList<TreeNode<E>> nodeList = new ArrayList<TreeNode<E>>();
		TreeNode<E> temp = root;
		nodeList.add(temp);
		while(nodeList.get(nodeList.size()-1) == temp && temp != null){
			nodeList.add(temp);
			if(temp.getLeft() != null && nodeList.get(nodeList.size()-1) == temp.getLeft()){
				temp = temp.getLeft();
			}
			else if(temp.getRight() != null && nodeList.get(nodeList.size()-1) == temp.getRight()){
				temp = temp.getRight();
			}
			else{
				temp = nodeList.get(nodeList.size()-1);
				nodeList.remove(nodeList.size()-1);
				System.out.print(temp.getValue() + " ");
				

			}
		}
	}
		
	/**	Return a balanced version of this binary tree
	 *	@return		the balanced tree
	 */
	public BinaryTree<E> makeBalancedTree() {
		BinaryTree<E> balancedTree = new BinaryTree<E>();

		return balancedTree;
	}
	
	/**
	 *	Remove value from Binary Tree
	 *	@param value		the value to remove from the tree
	 *	Precondition: value exists in the tree
	 */
	public void remove(E value) {
		root = remove(root, value);
	}
	/**
	 *	Remove value from Binary Tree
	 *	@param node			the root of the subtree
	 *	@param value		the value to remove from the subtree
	 *	@return				TreeNode that connects to parent
	 */
	public TreeNode<E> remove(TreeNode<E> node, E value) {
		return null;
	}
	

	/*******************************************************************************/	
	/********************************* Utilities ***********************************/	
	/*******************************************************************************/	
	/**
	 *	Print binary tree
	 *	@param root		root node of binary tree
	 *
	 *	Prints in vertical order, top of output is right-side of tree,
	 *			bottom is left side of tree,
	 *			left side of output is root, right side is deepest leaf
	 *	Example Integer tree:
	 *			  11
	 *			/	 \
	 *		  /		   \
	 *		5			20
	 *				  /	  \
	 *				14	   32
	 *
	 *	would be output as:
	 *
	 *				 32
	 *			20
	 *				 14
	 *		11
	 *			5
	 ***********************************************************************/
	public void printTree() {
		printLevel(root, 0);
	}
	
	/**
	 *	Recursive node printing method
	 *	Prints reverse order: right subtree, node, left subtree
	 *	Prints the node spaced to the right by level number
	 *	@param node		root of subtree
	 *	@param level	level down from root (root level = 0)
	 */
	private void printLevel(TreeNode<E> node, int level) {
		if (node == null) return;
		// print right subtree
		printLevel(node.getRight(), level + 1);
		// print node: print spaces for level, then print value in node
		for (int a = 0; a < PRINT_SPACES * level; a++) System.out.print(" ");
		System.out.println(node.getValue());
		// print left subtree
		printLevel(node.getLeft(), level + 1);
	}
	
	
}
