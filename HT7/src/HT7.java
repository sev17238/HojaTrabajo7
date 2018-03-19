


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author David Soto 17551
 * @author Diego Sevilla 17238
 */
public class HT7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int decision = 0; 
        
        BinaryNode<String> nod = null;
        BinaryTree2<String> tree = new BinaryTree2<String>(nod);
        
        Scanner teclado = new Scanner(System.in);
        
        
            System.out.println("Ingrese el nombre del archivo.txt que quiere leer para su diccionario: ");
            String file = teclado.nextLine();
            
            BufferedReader br = new BufferedReader(new FileReader(file));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = "";              
                                                
                String ingles = "";
                String espanol = "";
                
                //Ciclo principal en donde se lee cada linea del .txt donde estan las asociaciones de ingles y espanol
                while ((line=br.readLine())!=null) {
                    sb.append(line);
                    sb.append(System.lineSeparator()); 
                    line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                       //por substring
                    for(int i=1;i<line.length();i++){
                        String iter = line.substring((i-1), i); 
                        if(iter.equals(",")){
                            espanol = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de "|"
                            ingles = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de "|"       
                        }
                    }
                    
                    BinaryNode<String> node = new BinaryNode<String>(ingles,espanol); //se crea un nuevo nodo con cada linea
                    tree.addNodo(node); //el nodo se agrega al arbol
                    
                    System.out.println(ingles +", "+ espanol); //PRUEBA para ver que los datos se esten leyendo bien                    
                }
                
                while(decision != 2){                               
                System.out.println("Ingrese la oracion en ingles que quiere traducir: ");
                String oracion = teclado.nextLine();
                
                System.out.println("\n");
                tree.recorrer(BinaryTree2.recorrido.INORDER); //PRUEBA de recorridos
                
                //tree.traduccion(oracion); //En este metodo se debe de hacer el reemplazo 
                                            //de las palabras en ingles por las de espanol.
                    
                System.out.println("QUe desea hacer? \n1. Traducir otra oracion \n2. Salir ");
                decision = teclado.nextInt();
                }
                
            }
            finally{
                br.close();
            }  
        
        
    }
    
}
