import java.util.Random;

public class Main {

    public static void main(String[] args) {
/*        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for(int i = 0;i < 10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }*/

       /* LoopQueue<Integer> queue = new LoopQueue<>(10);
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }*/

        LoopQueueNoSize<Integer> queue = new LoopQueueNoSize<>(10);
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

       /* int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time:" + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue,time:" + time2 + "s");*/

    }

    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i =0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i =0;i<opCount;i++){
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }
}
