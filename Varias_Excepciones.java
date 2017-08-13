import javax.swing.JOptionPane;

/**
 *
 * @author franciscoJavier
 */
public class Varias_Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        division();
        }
        catch(NumberFormatException z){
            System.out.println("Has introducido texto en vez de nº enteros.  ");
            System.out.println("______________________________________________");
            System.out.println(" --- Datos de la excepción ---' ");
            //Tambien podemos aplicar mt, a la cl ArithmeticException
            System.out.println(z.getMessage());
            System.out.println(z.getClass());
        }
        catch(ArithmeticException f){
            System.out.println("has dividido por 0 ");
            System.out.println("______________________________________________");
            System.out.println("--- Datos de la excepción ---' ");
            //Tambien podemos aplicar mt, a la cl ArithmeticException
            System.out.println(f.getMessage());
            System.out.println(f.getClass());
        }
    }
    
    public static void division(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo."));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce divisor."));
        
        System.out.println("El resultado de dividir " +num1+ " entre " +num2+ " es " +num1/num2);
    }
    
}
