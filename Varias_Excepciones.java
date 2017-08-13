import javax.swing.JOptionPane;

/**
 *---CAPTURAR VARIAS EXCEPCIONES.
 *   Sucede cuando un mt, pude lanzar varios tipos de excepciones, todas ellas diferentes,
 * En el ej; vemos la excepción que mandaría si hacemos la división entre ‘0’. AritmeticException,
 * O si ponemos texto en la división, manda la excepción’. NumberFormatException

 * @author franciscoJavier
 */
public class Varias_Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CAPTURA DE EXCEPCIONES.
        // AMBAS SON EXCEPCIONES ‘NO CONTROLADAS’ Y NO ES RECOMENDABLE UTILIZAR EL CODIGO ‘try catch
        //       Aún así podemos codificalo y evitar que el programa se pare.
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

    /**
     * Realiza una división pidiendo las cifras por medio de ventanas emergentes.
     */
    public static void division(){
        // JOptionPane.showInputDialog(" ,,,") solos acepta String, por lo que lo pasamos a entero.
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce dividendo."));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce divisor."));

        System.out.println("El resultado de dividir " +num1+ " entre " +num2+ " es " +num1/num2);
    }

}
