package data_structure.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//절대값 힙
public class AbsoluteHeap {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new AbsoluteComparator());

        for(int i = 0; i < n; i++){
            int content = Integer.parseInt(reader.readLine());
            executeAbsolutePriorityQueue(pq,sb,content);
        }

        System.out.println(sb.toString());
        reader.close();
    }

    private static void executeAbsolutePriorityQueue(PriorityQueue<Integer> pq, StringBuilder sb, int content) {
        if(content == 0){
            if(pq.isEmpty()){
                sb.append("0\n");
            }
            else{
                sb.append(pq.poll()+"\n");
            }
        }
        else{
            pq.add(content);
        }
    }

    static class AbsoluteComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int result = Math.abs(o1) - Math.abs(o2);
            if(result == 0){
                return o1 - o2;
            }
            return result;
        }
    }

}
