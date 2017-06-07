package june_07_thread;

/**
 * Created by DoDo on 2017-06-07.
 */
public class Interrupt {
    public static void main(String[]args){
        Thread thread = new Thread(){
            @Override
            public void run() {
                int i = 10;
            while (i!=0&&!isInterrupted()){
                for(long x = 0; x<250000000l;x++);
                System.out.printf("thread1: %d%n",i--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Count over");
            }
        };
        thread.start();
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0; i < 10; i++)
                {
                    for(long x = 0; x<250000000l;x++);
                    System.out.printf("thread2: %o%n",i);
                }
                thread.interrupt();
            }
        };
        thread2.start();
    }
}
