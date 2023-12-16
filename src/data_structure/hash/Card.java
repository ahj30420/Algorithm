package data_structure.hash;

import java.util.*;
import java.io.*;

//카드
public class Card {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for(int i = 0; i < n; i++){
            long elem = Long.parseLong(reader.readLine());
            if(map.containsKey(elem)){
                int count = map.get(elem) + 1;
                map.put(elem,count);
            } else{
                map.put(elem,1);
            }
        }

        int maxValue = 0;
        long maxKey = 0;

        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            long key = entry.getKey();
            int value = entry.getValue();

            if(value > maxValue || (value == maxValue && key < maxKey)){
                maxValue = value;
                maxKey = key;
            }
        }

        System.out.println(maxKey);
        reader.close();

    }
}
