package data_structure.string;

import java.io.*;

//OX 퀴즈
public class OX_Quiz {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            String content = reader.readLine();
            for(int j = 0; j < content.length(); j++) {
                char target = content.charAt(j);

                if (target == 'O') {
                    count++;
                    sum += count;
                } else {
                    count = 0;
                }
            }
            sb.append(sum).append("\n");
            count = 0;
            sum = 0;
        }

        System.out.println(sb.toString());
        reader.close();

    }
}
