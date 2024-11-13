package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DequeImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalCnt = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        MyDeque myDeque = new MyDeque();

        for(int i = 0; i < totalCnt; i++){
            executeDeque(myDeque, reader.readLine(), output);
        }

        System.out.print(output.toString());
        reader.close();
    }

    private static void executeDeque(MyDeque myDeque, String input, StringBuilder output){
        StringTokenizer tokenizer = new StringTokenizer(input);
        String calculate = tokenizer.nextToken();
        Integer value = null;

        switch(calculate){
            case "push_front":
                value = Integer.parseInt(tokenizer.nextToken());
                myDeque.offerFirst(value);
                break;

            case "push_back":
                value = Integer.parseInt(tokenizer.nextToken());
                myDeque.offerLast(value);
                break;

            case "pop_front":
                output.append(myDeque.pollFirst()).append("\n");
                break;

            case "pop_back":
                output.append(myDeque.pollLast()).append("\n");
                break;

            case "size":
                output.append(myDeque.size()).append("\n");
                break;

            case "empty":
                output.append(myDeque.empty()).append("\n");
                break;

            case "front":
                output.append(myDeque.front()).append("\n");
                break;

            case "back":
                output.append(myDeque.back()).append("\n");
                break;
        }
    }

    private static class MyDeque {
        private static final Deque<Integer> deque = new ArrayDeque<>();

        public void offerFirst(Integer value){
            deque.offerFirst(value);
        }

        public void offerLast(Integer value){
            deque.offerLast(value);
        }

        public int pollFirst(){
            if(deque.isEmpty()){
                return -1;
            } else{
                return deque.pollFirst();
            }
        }

        public int pollLast(){
            if(deque.isEmpty()){
                return -1;
            } else{
                return deque.pollLast();
            }
        }

        public int size(){
            return deque.size();
        }

        public int empty(){
            return deque.isEmpty() ? 1 : 0;
        }

        public int front(){
            if(deque.isEmpty()){
                return -1;
            } else {
                return deque.getFirst();
            }
        }

        public int back(){
            if(deque.isEmpty()){
                return -1;
            } else {
                return deque.getLast();
            }
        }
    }
}
