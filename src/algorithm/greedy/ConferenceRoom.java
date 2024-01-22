package algorithm.greedy;

import java.util.*;
import java.io.*;

//회의실 배정
public class ConferenceRoom {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Time> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            Time time = new Time(start, end);
            list.add(time);
        }

        Collections.sort(list);

        int count = 1;
        int nEnd = list.get(0).getEnd();
        for(int i = 1; i < n; i++){
            Time time = list.get(i);
            if(time.getStart() >= nEnd){
                count++;
                nEnd = time.getEnd();
            }
        }

        System.out.println(count);
        reader.close();
    }

    private static class Time implements Comparable<Time>{

        private int start;
        private int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart(){
            return this.start;
        }

        public int getEnd(){
            return this.end;
        }

        @Override
        public int compareTo(Time other){
            if(this.end == other.end){
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

    }
}
