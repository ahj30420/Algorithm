package data_structure.string;

import java.util.*;
import java.io.*;

//단어의 개수
public class Number_words {
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);

        String content = scan.nextLine();
        String[] result = content.split(" ");
        int count = 0;

        for (String s : result) {
            if(!s.isEmpty()){
                count++;
            }
        }

        System.out.println(count);

    }
}
