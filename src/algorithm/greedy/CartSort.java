package algorithm.greedy;

import java.util.*;

//카드 정렬
public class CartSort {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.offer(sc.nextInt());
        }

        int result = 0;
        while(pq.size() != 1){
           int newBundles = pq.poll() + pq.poll();
           pq.offer(newBundles);
           result += newBundles;
        }

        System.out.println(result);
    }
}
