package data_structure.string;

import java.io.*;
import java.util.*;

//문자열 반복
public class Repeat_String {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(reader.readLine());

        for(int i = 0; i < testcase; i++){
            RepeatString(reader, sb);
        }

        System.out.println(sb.toString());
        reader.close();

    }

    private static void RepeatString(BufferedReader reader, StringBuilder sb) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int num = Integer.parseInt(tokenizer.nextToken());
        String content = tokenizer.nextToken();
        for(int j = 0; j < content.length(); j++){
            char target = content.charAt(j);
            for(int k = 0; k < num; k++){
                sb.append(target);
            }
        }
        sb.append("\n");
    }
}
