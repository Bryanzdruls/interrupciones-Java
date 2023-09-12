import java.util.Scanner;

public class Hilo extends Thread{
    @Override
    public void  run(){
        int i=0;
        while (!Thread.interrupted()){
            System.out.println(i);
            i++;

        }
    }
}
