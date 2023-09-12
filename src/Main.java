import javax.swing.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.channels.ClosedByInterruptException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args)  {

        Hilo t = new Hilo();
        //hilo Iniciado
        t.start();
        try {
            handleInterrupt(t);

        } catch ( SecurityException e) {
            e.printStackTrace();
        }

        System.out.println("Hilo terminado");
    }
    private static void handleInterrupt(Hilo t) {
        int dec =0;
        while (dec!=3) {
            dec = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer " +
                    "\n1. Interrumpir la ejecucion del hilo" +
                    "\n2. Iniciar hilo" +
                    "\n3. Salir"));
            switch (dec) {
                case 1:
                    t.interrupt();
                    break;
                case 2:
                    t.run();
                    break;
                case 3:
                    System.out.println("Chao");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion incorrecta");
            }
        }
    }


}