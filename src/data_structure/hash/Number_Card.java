package data_structure.hash;

import java.util.*;
import java.io.*;

//숫자 카드
public class Number_Card {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;

        int n = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            set.add(tokenizer.nextToken());
        }

        int m = Integer.parseInt(reader.readLine());

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < m; i++){
            if(set.contains(tokenizer.nextToken())){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
        reader.close();

    }
}
