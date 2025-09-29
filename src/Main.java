import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = screenSize.width;
        int alto = screenSize.height;

        //Realiza aquí el bucle para abrir las ventanas que quieras (recomiendo for)
        Scanner sc = new Scanner(System.in);
        int objetivo = new Random().nextInt(101);
        int j = 0;
        System.out.println("Quieres saber la solucion?");
        String respuesta = sc.nextLine();
            //String respuesta = "yes"
                    if(respuesta.equals("yes")){
                        System.out.println("Respuesta" + objetivo);
                    }else{
                        System.out.println("sigue adivinando el numero");

                    }
        trastada(ancho, alto, j);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for (int j = 0; j < 20; j++) {
                }
            }
        });

        //Aquí deberás hacer otro bucle para que el usuario acierte el número (recomiendo do-while)
        while (true) {
            String intentoStr = JOptionPane.showInputDialog(null, "Adivina el número (0-100):", "Adivina", JOptionPane.QUESTION_MESSAGE);
            if (intentoStr == null) {
                int opt = JOptionPane.showConfirmDialog(null, "¿Cerrar todo y salir?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    return;
                } else {
                    continue;
                }
            }
            int intento;
            try {
                intento = Integer.parseInt(intentoStr.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (intento < 0 || intento > 100) {
                JOptionPane.showMessageDialog(null, "Número entre 0 y 100.", "Aviso", JOptionPane.WARNING_MESSAGE);
                continue;
            }
            if (intento == objetivo) {
                JOptionPane.showMessageDialog(null, "¡Correcto! Era " + objetivo, "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if (Math.abs(intento - objetivo) <= 3) {
                JOptionPane.showMessageDialog(null, "Muy cerca.", "Pista", JOptionPane.INFORMATION_MESSAGE);
            } else if (intento < objetivo) {
                JOptionPane.showMessageDialog(null, "Demasiado bajo.", "Pista", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Demasiado alto.", "Pista", JOptionPane.INFORMATION_MESSAGE);
            }

            //Para cerrar todas las ventanas y finalizar el programa descomenta la siguiente linea
            //System.exit(0);
        }
    }

    public static void trastada(int ancho, int alto,int j){
        JFrame frame = new JFrame("¡Ups!");
        frame.setSize(200, 100);

        // Colocar en posición aleatoria dentro de los límites
        int x = (int) (Math.random() * (ancho - frame.getWidth()));
        j = (int) (Math.random() * (alto - frame.getHeight()));
        frame.setLocation(x, j);

        if(j % 2 == 0){
            frame.add(new JLabel("Tu PC tiene sueño... 😴", SwingConstants.CENTER));
        }else {
            frame.add(new JLabel("Tu PC está pensando... 🤔", SwingConstants.CENTER));
        }

        frame.setVisible(true);
    }
}