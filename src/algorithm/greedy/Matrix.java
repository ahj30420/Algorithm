package algorithm.greedy;

import java.util.*;
import java.io.*;

//행렬
public class Matrix {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = target.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < m; j++){
                b[i][j] = target.charAt(j) - '0';
            }
        }

        int result = 0;
        boolean pos = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]){
                    if(i+2 >= n || j+2 >= m){
                        result = -1;
                        pos = false;
                        break;
                    } else{
                        for(int k = i; k <= i+2; k++){
                            for(int z = j; z <= j+2; z++){
                                if(a[k][z] == 1) { a[k][z] = 0;}
                                else{a[k][z] = 1;}
                            }
                        }
                    }
                    result++;
                }
            }
            if(pos == false){break;}
        }

        System.out.println(result);
        reader.close();
    }
}
