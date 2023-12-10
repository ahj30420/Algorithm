package data_structure.hash;

import java.io.*;
import java.util.*;

//듣보잡
public class Unheard_Of {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            set.add(reader.readLine());
        }

        for(int i = 0; i < m; i++){
            String content = reader.readLine();
            if(set.contains(content)){
                list.add(content);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }

        reader.close();
    }
}
