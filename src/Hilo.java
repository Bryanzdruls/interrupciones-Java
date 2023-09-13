import java.util.Scanner;

public class Hilo extends Thread {
    private boolean pausado = false;
    private final Object lock = new Object();

    public void pausarHilo() {
        pausado = true;
    }

    public void reanudarHilo() {
        pausado = false;
        synchronized (lock) {
            lock.notify(); // Notifica para reanudar el hilo
        }
    }

    @Override
    public void run() {
        int contador = 0;
        while (true) {
            synchronized (lock) {
                while (pausado) {
                    try {
                        System.out.println("Hilo Pausado");
                        lock.wait(); // Espera hasta que se reanude
                        System.out.println("Hilo Reanudado");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            contador++;
            System.out.println("Contador: " + contador);

            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
