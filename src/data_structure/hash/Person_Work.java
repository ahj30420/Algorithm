package data_structure.hash;

import java.io.*;
import java.util.*;

//회사에 있는 사람
public class Person_Work {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String name = tokenizer.nextToken();
            String status = tokenizer.nextToken();
            if(status.equals("enter")){
                set.add(name);
            }
            else{
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);

       Collections.sort(list, Collections.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }

        reader.close();
    }
}
