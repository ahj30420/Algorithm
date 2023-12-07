package data_structure.queue;

import java.util.*;

public class Card2 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        java.util.Queue<Integer> queue = new LinkedList<>();

        int n = scan.nextInt();

        for(int i = 1; i <= n; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
