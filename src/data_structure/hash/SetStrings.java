package data_structure.hash;

import java.util.*;
import java.io.*;

//문자열 집합
public class SetStrings {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        Set<String> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            set.add(reader.readLine());
        }

        for(int i = 0; i < m; i++){
            if(set.contains(reader.readLine())){
                count++;
            }
        }

        System.out.println(count);
        reader.close();

    }
}
