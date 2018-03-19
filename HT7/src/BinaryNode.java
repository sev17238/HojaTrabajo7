/*
 * ejemplo con referencia: http://www.juliocesar.in/2013/09/arbol-binario-y-recorridos-preorden.html
 */


/**
 * 
 * @author David Soto 17555
 * @author Diego Sevilla 17238
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
    
    public BinaryNode getLeft(){
        return left;
    }
    
    public BinaryNode getRight(){
        return right;
    }
    
    public void setLeft(BinaryNode left){
        this.left = left;
    }
    
    public void setRight(BinaryNode right){
        this.right=right;
    }
    
    /**
     * Recorrido pre orden RID
     */
    public void preOrder() {
        System.out.print(getEspanol() + " ");
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }
    
    /**
     * Recorrido en orden IRD
     */
    public void inOrder() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print(left.getEspanol() + " ");
            else
                left.inOrder();
        System.out.print(getEspanol() + " ");
        if (right != null)
            if (right.isLeaf())
                System.out.print(right.getEspanol() + " ");
            else
                right.inOrder();
    }
    
    /**
     * Recorrido post orden IDR
     */
    public void postOrder() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print(left.getEspanol() + " ");
            else
                left.postOrder();        
        if (right != null)
            if (right.isLeaf())
                System.out.print(right.getEspanol() + " ");
            else
                right.postOrder();
        System.out.print(getEspanol() + " ");
    }
    
    public String search(String value){
        if (value.equals(this.as.getKey())){
            
            return this.as.theValue;
        }else if (value.compareTo(this.as.getKey()) < 0) {
            
            if (left == null){
                return "*" + value + "*";
            }else{
                return left.search(value);
            }
        }else if(value.compareTo(this.as.getKey()) > 0) {
            
            if (right == null){
                return "*" + value + "*";
            }else{
                return right.search(value);

            }
        }
        
        return "*" + value + "*";
    }
}
