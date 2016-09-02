
public class BasicAVL {

	private class AVLNode{
		public int element;
		public int height;
		public AVLNode left, right;
		
		public AVLNode(int element, AVLNode left, AVLNode right){
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private AVLNode root;
	
	public BasicAVL(){
		root = null;
	}
	
	public void insert(int num){
		root = insert(num, root);
	}
	
	public void print(){
		if(root == null)
			System.out.println("Tree is Empty");
		else
			print(root, 0);
	}
	
	private void print(AVLNode nod, int row){
		String space = "    ";
		
		for(int i=0; i<row; i++) System.out.print(space);
			System.out.println(nod.element);
			
			if(nod.left != null) print(nod.left, row+1);
			if(nod.right != null) print(nod.right, row+1);
	}
	
	private AVLNode insert(int num, AVLNode nod){
		if(nod == null)
			nod = new AVLNode(num, null, null);
		else if(num < nod.element){
			nod.left = insert(num, nod.left);
			if(height(nod.left) - height(nod.right) == 2)
				if(num < nod.left.element)
					nod = rotateWithLeftChild(nod);
				else
					nod = doubleSwapLeftChild(nod);
		}else if(num > nod.element){
			nod.right = insert(num, nod.right);
			if(height(nod.right) - height(nod.left) == 2)
				if(num > nod.right.element)
					nod = rotateWithRightChild(nod);
				else
					nod = doubleSwapRightChild(nod);
		}else;
		nod.height = Math.max(height(nod.left), height(nod.right)) + 1;
		return nod;
	}
	
	private AVLNode rotateWithLeftChild(AVLNode nod2){
		AVLNode nod1 = nod2.left;
		nod2.left = nod1.right;
		nod1.right = nod2;
		nod2.height = Math.max(height(nod2.left),  height(nod2.right)) + 1;
		nod1.height = Math.max(height(nod1.left), nod2.height) + 1;
		return nod1;
	}
	
	private AVLNode rotateWithRightChild(AVLNode nod1){
		AVLNode nod2 = nod1.right;
		nod1.right = nod2.left;
		nod2.left = nod1;
		nod1.height = Math.max(height(nod1.left), height(nod1.right)) + 1;
		nod2.height = Math.max(height(nod2.right),  nod1.height) + 1;
		return nod2;
	}
	
	private AVLNode doubleSwapLeftChild(AVLNode nod3){
		nod3.left = rotateWithRightChild(nod3.left);
		return rotateWithLeftChild(nod3);
	}
	
	private AVLNode doubleSwapRightChild(AVLNode nod3){
		nod3.right = rotateWithLeftChild(nod3.right);
		return rotateWithRightChild(nod3);
	}
	
	private int height(AVLNode n){
		return n == null ? -1 : n.height; 
	}
}
