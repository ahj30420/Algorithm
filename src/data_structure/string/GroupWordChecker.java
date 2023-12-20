package data_structure.string;

import java.util.*;
import java.io.*;

//그룹 단어 체커
public class GroupWordChecker {
    public static void main(String[] args) throws IOException{

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(reader.readLine());
       int count = 0;

       for(int i = 0; i < n; i++){
           String target = reader.readLine();
           if(IsGroupWord(target)){
               count++;
           }
       }

       System.out.println(count);
       reader.close();

    }

    private static boolean IsGroupWord(String target) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet,-1);
        for(int i = 0; i < target.length(); i++){
            char value = target.charAt(i);
            int index = value - 'a';

            if(alphabet[index] == -1 || alphabet[index] == i-1){
                alphabet[index] = i;
            } else{
                return false;
            }
        }
        return true;
    }

}
