package data_structure.string;

import java.util.*;
import java.io.*;

//잃어버린 괄호
public class LoseParentheses {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "-");

        int sum = Integer.MAX_VALUE;

        while(tokenizer.hasMoreTokens()){
            int temp = 0;

            StringTokenizer subtokenizer = new StringTokenizer(tokenizer.nextToken(), "+");

            while(subtokenizer.hasMoreTokens()){
                temp += Integer.parseInt(subtokenizer.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else{
                sum -= temp;
            }

        }

        System.out.println(sum);
        reader.close();

    }
}
