package data_structure.queue;

import java.util.*;
import java.io.*;

public class Printer_Queue {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(reader.readLine());

        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(reader.readLine());

            int pages = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            java.util.Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(reader.readLine());

            for(int j = 0; j < pages; j++){
                int content = Integer.parseInt(st.nextToken());
                queue.add(new int[] {j, content});
            }

            int count = 0;

            while(true){
                int[] ct = queue.poll();
                boolean check = true;

                for(int[] ctQ : queue){
                    if(ctQ[1] > ct[1]){
                        check = false;
                        break;
                    }
                }

                if(check){
                    count++;
                    if(ct[0] == target) { break; }
                } else{
                    queue.add(ct);
                }

            }

            reader.close();
            System.out.println(count);
        }

    }
}
