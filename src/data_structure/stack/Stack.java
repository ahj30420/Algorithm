package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {
   public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder builder = new StringBuilder();
       Integer totalCnt = Integer.parseInt(reader.readLine());

       MyStack myStack = new MyStack();

       for(int i = 0; i < totalCnt; i++){
           executeStack(myStack, reader.readLine(), builder);
       }

       System.out.println(builder.toString());
       reader.close();
   }

   private static void executeStack(MyStack myStack, String input, StringBuilder builder){
       StringTokenizer tokenizer = new StringTokenizer(input);
       String calculate = tokenizer.nextToken();

       switch(calculate){
           case "push":
               int value = Integer.parseInt(tokenizer.nextToken());
               myStack.push(value);
               break;

           case "pop":
               builder.append(myStack.pop()).append("\n");
               break;

           case "size":
               builder.append(myStack.size()).append("\n");
               break;

           case "empty":
               builder.append(myStack.empty()).append("\n");
               break;

           case "top":
               builder.append(myStack.top()).append("\n");
               break;
       }
   }

   private static class MyStack {
       private final static java.util.Stack<Integer> stack = new java.util.Stack<>();

       public void push(int value){
           stack.push(value);
       }

       public int pop(){
           if(stack.isEmpty()){
               return -1;
           } else{
               return stack.pop();
           }
       }

       public int size(){
           return stack.size();
       }

       public int empty(){
           if(stack.isEmpty()){
               return 1;
           } else{
               return 0;
           }
       }

       public int top(){
           if(stack.isEmpty()){
               return -1;
           } else{
               return stack.peek();
           }
       }
   }
}
