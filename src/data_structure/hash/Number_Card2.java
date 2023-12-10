package data_structure.hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//숫자 카드2
public class Number_Card2 {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < n; i++){
            CountHashMap(tokenizer, map);
        }

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < m; i++){
            ExecuteCountHasMap(tokenizer, map, sb);
        }

        System.out.println(sb.toString());
        reader.close();

    }

    private static void ExecuteCountHasMap(StringTokenizer tokenizer, Map<Integer, Integer> map, StringBuilder sb) {
        int content = Integer.parseInt(tokenizer.nextToken());
        if(map.containsKey(content)){
            sb.append(map.get(content) + " ");
        }
        else{
            sb.append("0 ");
        }
    }

    private static void CountHashMap(StringTokenizer tokenizer, Map<Integer, Integer> map) {
        int content = Integer.parseInt(tokenizer.nextToken());
        if(map.containsKey(content)){
            int count = map.get(content) + 1;
            map.put(content, count);
        }
        else{
            map.put(content, 1);
        }
    }
}
