/*
 * ejemplo de DOUGLAS con algunos cambios. Esta en capitulo 12 a partir de pag 284
 */
package ht7;

/**
 *
 * @author SDiego
 * @param <E>
 */
public class BinaryTree<E> extends Association<String,String>
{

        //protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	
	public BinaryTree(){
	// post: constructor that generates an empty node
                super("",""); //valores del nodo asociaados
                //val = null;
		parent = null; 
		left = right = this;
	}
	
	public BinaryTree(String ing,String esp)
	// post: returns a tree referencing value and two empty subtrees
	{
            super(ing,esp);
            //val = value;
            right = left = new BinaryTree<E>();            
            setLeft(left);
            setRight(right);
	}
	
	public BinaryTree(String ing, String esp,BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		super(ing,esp);
                //val = value;                
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	
	public BinaryTree<E> parent(){
            return parent;
        }
	// post: returns reference to parent node, or null
	
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (newLeft == null) return;
		if (left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
        
        public void setRight(BinaryTree<E> newRight)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (newRight == null) return;
		if (right != null && right.parent() == this) right.setParent(null);
		right = newRight;
		right.setParent(this);
	}
	
	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if ( newParent != null) {
		parent = newParent;
		}
	}
	
	/*public Iterator<E> iterator(){
            
        }
	// post: returns an in-order iterator of the elements
	
	public boolean isLeftChild()
	// post: returns true if this is a left child of parent
	
    */
    public void newNode(){
        
    }
        
	
}
