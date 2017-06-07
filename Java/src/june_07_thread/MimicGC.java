package june_07_thread;

/**
 * Created by DoDo on 2017-06-07.
 */
public class MimicGC{
    public static void main(String[] args){
        GC gc = new GC();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory =0;
        for(int i = 0; i <20; i ++){
            requiredMemory = (int)(Math.random() * 10) *20;
            if(gc.freeMemory()< requiredMemory || gc.freeMemory()>gc.totalMemory()*0.4){
                gc.interrupt();
            }
            gc.usedMemory += requiredMemory;
            System.out.printf("UsedMemory : %d%n", gc.usedMemory);
        }
    }


    static class GC extends Thread{
        final static int MAX_MEMORY = 10000;
        int usedMemory = 0;
        @Override
        public void run() {
            super.run();
            while(true){
                try{
                    Thread.sleep(10*1000);
                }catch(InterruptedException e){
                    System.out.println("GC AWAKEN by Interrupt");
                }
                gc();
                System.out.printf("Gc works, usedMemory: %d%n",totalMemory()-usedMemory);
            }

        }
        public void gc(){
            usedMemory -= 300;
            if(usedMemory<0) usedMemory = 0;
        }
        public int totalMemory(){return MAX_MEMORY;}
        public int freeMemory() {return MAX_MEMORY-usedMemory;}
    }
}
