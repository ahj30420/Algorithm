package data_structure.string;

import java.io.*;

//숫자의 합
public class Sum_Numbers {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String content = reader.readLine();
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += content.charAt(i) - '0';
        }

        System.out.println(sum);

        reader.close();

    }
}
