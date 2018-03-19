/*
 * Ver referencia de BinaryNode, 
 * metodo addNodo() sacado de: https://serprogramador.es/programar-arboles-binarios-parte-1-introduccionclasesagregar-nodo/
 */


/**
 *
 * @author David Soto 17551
 * @author Diego Sevilla 17238
 */
public class BinaryTree2<E extends Comparable<E>> {
    private BinaryNode<E> raiz;
    
    // Tipos de recorrido
    public enum recorrido {PREORDER, INORDER, POSTORDER}
    
    /**
     * Constructor por default con nodo raíz
     * @param r 
     */
    public BinaryTree2(BinaryNode<E> r) {
        raiz = r;
    }
    
    /**
     * Devuelve el nodo raíz del árbol
     * @return 
     */
    public BinaryNode<E> getRaiz() {
        return raiz;
    }
    
    public void setRaiz(BinaryNode<E> raiz) {
        this.raiz = raiz;
    }
    
    private void addNodo( BinaryNode nodo, BinaryNode raiz ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             * ==== EDITO =====
             * Muchas gracias a @Espectro por la corrección de esta línea
             */
            this.setRaiz(nodo);
        }
        else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if ( nodo.getAsociacion().getKey().compareTo(raiz.getAsociacion().getKey()) < 0 ) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                if (raiz.getLeft() == null) {
                    raiz.setLeft(nodo);
                }
                else {
                    addNodo( nodo , raiz.getLeft() );
                }
            }else  {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                if (raiz.getRight() == null) {
                    raiz.setRight(nodo);
                }
                else {
                    addNodo( nodo, raiz.getRight() );
                }
            }
        }
    } 
    public void addNodo( BinaryNode nodo ) {
        this.addNodo( nodo , this.raiz );
    }
    
    /**
     * Permite recorrer el árbol en el órden indicado
     * @param tipo 
     */
    public void recorrer(recorrido tipo) {
        switch(tipo) {
            case PREORDER:
                System.out.println("Recorrido PREORDER");
                raiz.preOrder();
                break;
            case INORDER:
                System.out.println("Recorrido IN-ORDER");
                raiz.inOrder();
                break;
            case POSTORDER:
                System.out.println("Recorrido POSTORDER");
                raiz.postOrder();
                break;
        }
        System.out.println();
    }
    /**
     * Verifica que exista una raiz en el arbol para realizar la busqueda
     * @param palabra la palabra a buscar
     * @return La traduccion de la palabra si existe en el arbol
     */
    public String buscarPalabra(String palabra){
        if (raiz == null){
            
            return "*" + palabra + "*";
        }else{
            return raiz.search(palabra);
        }
    }
}
