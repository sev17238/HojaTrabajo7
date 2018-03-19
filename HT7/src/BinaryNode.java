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
    Association<String,String> value;
    private BinaryNode<E> parent;
    private BinaryNode<E> left;
    private BinaryNode<E> right;  
    
    /**
     * Primer constructor. Únicamente asigna valor
     */
    public BinaryNode(String Ing,String Esp) {
        value = new Association(Ing,Esp); //valores del nodo asociaados
        parent = null;
        left = null;
        right = null;
        
    }
    
    /**
     * Segundo constructor
     * @param Ing
     * @param Esp
     * @param ni Nodo Izquierdo
     * @param nd Nodo derecho
     */
    public BinaryNode(String Ing, String Esp, BinaryNode<E> ni, BinaryNode<E> nd) {
        value = new Association(Ing,Esp); //valores del nodo asociaados
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
        value = new Association(Ing,Esp); //valores del nodo asociaados
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
        return value;
    }
    
    /**
     * Devuelve la palabra en espanol
     * @return 
     */
    public String getEspanol() {
       return value.getValue();
    }
    /**
     * Devuelve la palabra en ingles
     * @return 
     */
    public String getEnglish(){
        return value.getKey();
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
                System.out.print("("+left.getEnglish() + ", "+ left.getEspanol()+")\n");
            else
                left.inOrder();
        System.out.print("("+getEnglish() + ", "+getEspanol()+")\n");
        if (right != null)
            if (right.isLeaf())
                System.out.print("("+right.getEnglish() + ", "+ right.getEspanol()+")\n");
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
    /**
     * Busca una palabra en ingles dentro del arbol y devuelve su traduccion si la hay
     * @param value la palabra a buscar
     * @return La traduccion al español de la palabra si existe en el arbol
     */
    public String search(String value){
        if (value.equals(this.value.getKey())){
            
            return this.value.theValue;
        }else if (value.compareTo(this.value.getKey()) < 0) {
            
            if (left == null){
                return "*" + value + "*";
            }else{
                return left.search(value);
            }
        }else if(value.compareTo(this.value.getKey()) > 0) {
            
            if (right == null){
                return "*" + value + "*";
            }else{
                return right.search(value);

            }
        }
        
        return "*" + value + "*";
    }
}
