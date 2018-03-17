/*
 * Ver referencia de BinaryNode, 
 * metodo addNodo() sacado de: https://serprogramador.es/programar-arboles-binarios-parte-1-introduccionclasesagregar-nodo/
 */
package ht7;

/**
 *
 * @author SDiego
 */
public class BinaryTree2<E extends Comparable<E>> {
    private BinaryNode<E> raiz;
    
    // Tipos de recorrido
    public enum recorrido {PREORDEN, ENORDEN, POSTORDEN}
    
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
            if ( nodo.getValor() <= raiz.getValor() ) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda() );
                }
            }
            else {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha() );
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
            case PREORDEN:
                System.out.println("Recorrido pre orden");
                raiz.preOrden();
                break;
            case ENORDEN:
                System.out.println("Recorrido en orden");
                raiz.enOrden();
                break;
            case POSTORDEN:
                System.out.println("Recorrido post orden");
                raiz.postOrden();
                break;
        }
        System.out.println();
    }
}
