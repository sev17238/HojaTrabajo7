/*
 * ejemplo con referencia: http://www.juliocesar.in/2013/09/arbol-binario-y-recorridos-preorden.html
 */
package ht7;

/**
 *
 * @author SDiego
 */
public class BinaryNode<E>{
    
    //private E valor;
    Association<String,String> as;
    private BinaryNode<E> parent;
    private BinaryNode<E> left;
    private BinaryNode<E> right;  
    
    /**
     * Primer constructor. Únicamente asigna valor
     */
    public BinaryNode(String Ing,String Esp) {
        as = new Association(Ing,Esp); //valores del nodo asociaados
        
    }
    
    /**
     * Segundo constructor
     * @param Ing
     * @param Esp
     * @param ni Nodo Izquierdo
     * @param nd Nodo derecho
     */
    public BinaryNode(String Ing, String Esp, BinaryNode<E> ni, BinaryNode<E> nd) {
        as = new Association(Ing,Esp); //valores del nodo asociaados
        if (ni != null) left = ni;
        if (nd != null) right = nd;
    }
    
    /**
     * Tercer constructor
     * @param Ing
     * @param Esp
     * @param IngLeft
     * @param EspLeft
     * @param IngRight
     * @param EspRight
     */
    public BinaryNode(String Ing, String Esp, String IngLeft,String EspLeft,String IngRight,String EspRight) {
        as = new Association(Ing,Esp); //valores del nodo asociaados
        if (IngLeft!= null && EspLeft != null) {
            left = new BinaryNode<>(IngLeft,EspLeft);
        }
        if (IngRight!= null && EspRight != null) {
            right = new BinaryNode<>(IngRight,EspRight);
        }
    }
    
    
     /**
     * Indica si el nodo tiene hijos
     * @return 
     */
    public boolean hasChildren() {
        return (left != null && right != null);
    }
    
    /**
     * Nodo leaf cuando no tiene hijos
     * @return 
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }
    
    /**
     * Devuelve el valor del nodo
     * @return 
     */
    public Association getAsociacion() {
        return as;
    }
    
    /**
     * Devuelve la palabra en espanol
     * @return 
     */
    public String getEspanol() {
       return as.getValue();
    }
    
    /**
     * Recorrido pre orden RID
     */
    public void preOrden() {
        System.out.print(getEspanol() + " ");
        if (left != null)
            left.preOrden();
        if (right != null)
            right.preOrden();
    }
    
    /**
     * Recorrido en orden IRD
     */
    public void enOrden() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print(left.getEspanol() + " ");
            else
                left.enOrden();
        System.out.print(getEspanol() + " ");
        if (right != null)
            if (right.isLeaf())
                System.out.print(right.getEspanol() + " ");
            else
                right.enOrden();
    }
    
    /**
     * Recorrido post orden IDR
     */
    public void postOrden() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print(left.getEspanol() + " ");
            else
                left.postOrden();        
        if (right != null)
            if (right.isLeaf())
                System.out.print(right.getEspanol() + " ");
            else
                right.postOrden();
        System.out.print(getEspanol() + " ");
    }
}
