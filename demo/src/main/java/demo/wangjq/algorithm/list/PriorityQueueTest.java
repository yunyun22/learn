package demo.wangjq.algorithm.list;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by AMD on 2018/6/7.
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(2);
        priorityQueue.add(9);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(90);


//        while (!priorityQueue.isEmpty()) {
//            Integer i = priorityQueue.poll();
//            System.out.println("the current index:" + i);
//        }

        Iterator<Integer> iterator = priorityQueue.iterator();

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("the current index:" + i);
        }


        while (!priorityQueue.isEmpty()) {
            Integer i = priorityQueue.poll();
            System.out.println("the current index:" + i);
        }


    }

}



