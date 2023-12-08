package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue {

    static int last = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        java.util.Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());

        for(int i = 0; i < n; i++){
            executeQueue(queue,reader.readLine());
        }

        reader.close();
    }

    private static void executeQueue(java.util.Queue queue, String line) {
        if(line.contains(" ")){
            int index = line.lastIndexOf(" ");
            last = Integer.parseInt(line.substring(index+1));

            queue.add(last);
        }
        else{
            switch(line){
                case "pop":
                    Integer content = (Integer) queue.poll();
                    if(content == null){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(content);
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;

                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(queue.peek());
                    }
                    break;

                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(last);
                    }
                    break;
            }
        }
    }
}
