package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalCnt = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        MyQueue myQueue = new MyQueue();

        for(int i = 0; i < totalCnt; i++){
            executeQueue(myQueue, reader.readLine(), output);
        }

        System.out.print(output.toString());
        reader.close();
    }

    private static void executeQueue(MyQueue myQueue, String input, StringBuilder output){
        StringTokenizer tokenizer = new StringTokenizer(input);
        String calculate = tokenizer.nextToken();

        switch(calculate){
            case "push":
                Integer value = Integer.parseInt(tokenizer.nextToken());
                myQueue.push(value);
                break;

            case "pop":
                output.append(myQueue.pop()).append("\n");
                break;

            case "size":
                output.append(myQueue.size()).append("\n");
                break;

            case "empty":
                output.append(myQueue.empty()).append("\n");
                break;

            case "front":
                output.append(myQueue.front()).append("\n");
                break;

            case "back":
                output.append(myQueue.back()).append("\n");
                break;
        }
    }

    private static class MyQueue {
        private static final Queue<Integer> queue = new LinkedList<>();
        private static Integer lastNum;

        public MyQueue(){}

        public void push(Integer value){
            lastNum = value;
            queue.add(value);
        }

        public int pop(){
            if(queue.isEmpty()){
                return -1;
            } else {
                return queue.poll();
            }
        }

        public int size(){
            return queue.size();
        }

        public int empty(){
            return queue.isEmpty() ? 1 : 0;
        }

        public int front(){
            if(queue.isEmpty()){
                return -1;
            } else {
                return queue.peek();
            }
        }

        public int back(){
            if(queue.isEmpty()){
                return -1;
            } else {
                return lastNum;
            }
        }
    }
}
