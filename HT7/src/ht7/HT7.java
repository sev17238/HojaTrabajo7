
package ht7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Diego Sevilla 17238 - David Soto 17551
 */
public class HT7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int decision = 0; 
        String file = "";
        BinaryTree<String> tree = new BinaryTree(); // Objeto de tipo BinaryTree de nuestra implementacion.
        //Association<String,String> as = new Association("","") ;
        Scanner teclado = new Scanner(System.in);
        //ciclo principal donde se ejecutan las instrucciones del programa
        while(decision != 2){
            BufferedReader br = new BufferedReader(new FileReader(file));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = "";
                
                
                System.out.println("¿Que Implementacion de la interface Map desea usar? (Escriba solo el numero) \n\t1. HashMap \n\t2. TreeMap \n\t3. LinkedHashMap");
                String entry = teclado.nextLine();
                
                Map<String, String> imp = null;
                String ingles = "";
                String espanol = "";
                
                //AHORA LOS KEYS SERAN EL NOMBRE DE LA CARTA 
                //EL VALUE CONTENDRA A LA CARTA EN SI
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
                    
                    cards.getCartasDisp().put(key, card); //para poner en una coleccion todas las cartas disponibles
                }
                               

                    switch(decision2)
                    {
                        case 1:
                          
                            break;
                        case 2:
                            try
                            {
                               
                            }
                            catch (NullPointerException e)
                            {
                                
                            }
                            break;
                        case 3:
                         
                            break;
                        case 4:
                            
                            break;
                        case 5: // se muestran las cartas disponibles
                            
                            break;
                        case 6:                           
                            
                            break;
                        case 7:
                            
                            break;
                    }
                
            }
            finally{
                br.close();
            }  
        }
        
    }
    
}
