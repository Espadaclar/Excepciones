
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * En esta cl se calcula la superficie de una figura geométrica elegida por medio de un índice y se halla el ¡¡¡peso ideal??'
 * de una persona según su altura.
 * DATO. -->si a la hora de seleccionar el índice de una figura lo hacemos con letras, salta una Excepción.
 *          y el programa pasa a la segunda parte ejecutandose pidiendo datos sobre la altura del usuario.
 * 
 * En esta cl se explica el funcionamiento de la CLÁUSULA FINALLY
 * ---CLÁUSULA FINALLY.
 * Principalmente sirve para cerrar los recursos de una BBDD. 
 * Si estamos trabajando con una BBDD tenemos que cerrar el acceso a ella cuando hemos 
 * terminado la consulta o cuando se ha producido un error en tiempo de ejecución, ya que si no estaríamos
 * ocupando una entrada a la BBDD que no estamos utilizando y que otro usuario puede que necesite.
 *  -------***** . Es recomendable cerrarla con el mt ‘close()’
 * 
 *  CLAUSULA       FINALLY. Siempre se ejecuta el codigo que contenga, independientemente de si se ejecuta
 * el 'try' porque todo va bien, o si se ejecuta 'catch' si ha habido una 'Excepción'.
 * ----- Es por esto por lo que el cierre de la conexión a una BBDD se hace dentro de esta clausula. linea 42 a 46.
 * 
 * @author Usuario
 */
public class Clausula_Finally {

    private static int num;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("De qué figura quiere conocer el area; \n1 Cuadrado.\n2 Rectángulo.\n3 Triangulo.\n4 Círculo.");
        Scanner entrada = new Scanner(System.in);

        try {
            num = entrada.nextInt();           
        } catch (Exception e) {
            System.out.println("Error de datos, solo enteros.");
        }
        finally{//------------------- CLAUSULA       FINALLY. Siempre se ejecuta
            // mt para el cierre de la conexión de la cl Scanner con los datos pedidos en consola.
            entrada.close();
        }
        switch (num) {
            case 1:
            int lado = Integer.parseInt(JOptionPane.showInputDialog("Longitud del lado."));
            System.out.println("Superficie total del cuadrado " + lado * lado);
            break;
            case 2:
            int altura2 = Integer.parseInt(JOptionPane.showInputDialog("Longitud de altura."));
            int base2 = Integer.parseInt(JOptionPane.showInputDialog("Longitud de la base."));
            System.out.println("Superficie total del rectangulo " + altura2 * base2);
            break;
            case 3:
            int altura3 = Integer.parseInt(JOptionPane.showInputDialog("Longitud de altura."));
            int base3 = Integer.parseInt(JOptionPane.showInputDialog("Longitud de la base."));
            System.out.println("Superficie total del triangulo " + (altura3 * base3) / 2);
            break;
            case 4:
            float radio4 = Float.parseFloat(JOptionPane.showInputDialog("Longitud del radio."));
            System.out.println("Superficie total del Círculo " + Math.PI * Math.pow(radio4, 2));
            break;

            default:
            System.out.println("La opción no es correcta.");
        }

        // -------------------------------  **************************** --------------------------------
        System.out.println("Introduce tu altura, calculamos el peso ideal.");

        float pesoIdeal = Float.parseFloat(JOptionPane.showInputDialog("Introducir altura para calculo de peso."));
        System.out.println("Si eres hombre, el peso ideal es. " + (pesoIdeal - 120));
        System.out.println("Si eres mujer, el peso ideal es. " + (pesoIdeal - 130));
    }

}
