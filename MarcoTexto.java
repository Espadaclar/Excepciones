import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * creamos nuestra propia 'Excepcion' para que sea capturada si la direccion
 * email <= 3 caracteres.
 * * ----------- CREAMOS LA CL PARA CREAR NUESTRA PROPIA EXCEPCION ----------esta
 * cl se recomienda tener dos constructores, uno que pertenceCca a la cl de la
 * que hereda -- y otro más que reciba por parámetro un String
 *
 * ES RECOMENDABLE QUE LA CL HEREDE DE LA CL Exception
 *
 * una vez creados los const, nos vamos al mt donde se crea el email y le
 * ponemos como lanzador de una excepcion con la clausula 'throws' --> 
 * --> comprobarDireccionEmail() throws Longitud_mail_erronea *
 * 
 * dentro del condigo de este mt, hacemos una llamada a la cl, de nuestraExcepcion y la colocamos
 * donde el mt haga saltar al programa donde no se cumpla una condicion.
 * @author franciscoJavier
 */
public class MarcoTexto extends JFrame {

    private boolean validaDentroFrame;// ------ facilita comentario sobre la validez de la direcció email.
    private String textoParaValidar;

    public static void main(String[] args) {
        MarcoTexto marco = new MarcoTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MarcoTexto() {
        textoParaValidar = "";

        LaminaTexto lamina = new LaminaTexto();
        add(lamina);

        setBounds(100, 100, 900, 600);
        setVisible(true);
        setTitle("MarcoTexto");

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image image = icono.getImage("../icono2.gif");
        setIconImage(image);
    }

}

///////////////////////////////////////////////////////////////////////////CLASE PARA CREAR LAMINA DE DIBUJO
class LaminaTexto extends JPanel {

    JLabel dato2 = new JLabel();
    private JTextField campo1;//--- almacena el texto que se escriva en el cuadro de texto.
    private int cont;// ----------- cuenta las @ en la direccion  email.

    public LaminaTexto() {
        //asignamos el tipo de Layout a la lamina.
        setLayout(new BorderLayout());

        //***************************************************************************
        JPanel laminaPegada = new JPanel();// ----------------1º LAMINA PARA PEGAR, ZONA NORTE, DE LaminaTexto()
        JLabel dato = new JLabel("Direccion email.-");// ------ETIQUETA
        laminaPegada.add(dato);
        campo1 = new JTextField(25);// -----------------------CUADRO DE TEXTO
        laminaPegada.add(campo1);
        JButton boton = new JButton("Validar_Direccion."); // ------------BOTON
        laminaPegada.add(boton);

        Oyente oyente = new Oyente();// -----------------------INSTANCIA OBJETO OYENTE
        boton.addActionListener(oyente);// ------------------- OB.OYENT A LA ESCUCHA
        //****************************************************
        JPanel laminaPegada2 = new JPanel();// ----------------2º LAMINA PARA PEGAR, ZONA SUR, DE LaminaTexto()          
        //JLabel dato2 = new JLabel(textoParaValidar);// ------dependiendo de la validez de la direccion, muesta un texto u otro.            
        laminaPegada2.add(dato2);//cuadro de texto declarado como atributo.

        add(laminaPegada, BorderLayout.NORTH);// ------------- PEGAMOS laminaPegada SOBRE LaminaTexto()
        add(laminaPegada2, BorderLayout.EAST);// ------------- PEGAMOS laminaPegada2 SOBRE LaminaTexto()
    }

    // ************ CLASE INTERNA Y OYENTE
    private class Oyente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comprobarDireccionEmail();
            } catch (Exception c) {
                System.out.println("Error dirección con pocos caracteres.");
                c.printStackTrace();
            }
        }

        /**
         * una vez creados los const de la cl Longitud_mail_erronea extends Exception, nos vamos al mt donde se crea el email y le
         * ponemos como lanzador de una excepcion con la clausula 'throws' --> 
         */
        public void comprobarDireccionEmail() throws Longitud_mail_erronea {
            String aux = campo1.getText();// ---------- aux, variable que almacena la direccion email dada por el usuario.
            cont = 0;
            char[] valor = aux.toCharArray(); // ---- valor, almacena  cada uno de los caracteres de la direccion.

            if (valor.length <= 3) {
                // --llamada a la cl, de nuestraExcepcion con la clausula ‘throw’  
                // ---¡¡¡ RECORDEMOS QUE ESTA CLAUSULA ES PARa LANZAR UNA EXCEPCION DE FORMA MANUAL  EN EL PUNTO DEL CÓDIGO QUE QUERAMOS,!!!
                // ---y la colocamos  donde el mt haga saltar al programa donde no se cumpla una condicion
                throw new Longitud_mail_erronea("Direccion demasiado corta");
            } else {
                for (int i = 0; i < valor.length; i++) {
                    if (valor[i] == '@') {
                        cont++;
                    }
                }
                if (cont == 0 || cont > 1) {
                    dato2.setText("Dirección incorrecta, " + cont + " @.");
                } else {
                    dato2.setText("Direccion correcta.");
                }
            }
        }
    }
}

/**
 * ----------- CREAMOS LA CL PARA CREAR NUESTRA PROPIA EXCEPCION ----------esta
 * cl se recomienda tener dos constructores, uno que pertenceCca a la cl de la
 * que hereda -- y otro más que reciba por parámetro un String
 *
 * ES RECOMENDABLE QUE LA CL HEREDE DE LA CL Exception
 */
class Longitud_mail_erronea extends Exception {

    public Longitud_mail_erronea() { }

    public Longitud_mail_erronea(String msj_error) {
        super(msj_error);
    }
}
