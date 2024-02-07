package algorithm.DFS;

import java.io.*;
import java.util.*;

//영역 구하기
public class AreasFind {

    private static ArrayList<Integer> result = new ArrayList<>();
    private static int[][] map;
    private static int m,n,k;
    private static int count = 0;
    private static int area;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(reader.readLine());

            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int j = leftY; j < rightY; j++){
                for(int z = leftX; z < rightX; z++){
                    map[j][z] = 1;
                }
            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                area = 0;
                int target = dfs(i,j);
                if(target != 0){
                    result.add((target));
                    count++;
                }
            }
        }

        Collections.sort(result);

        System.out.println(count);

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+ " ");
        }

        reader.close();
    }

    private static int dfs(int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || map[i][j] == 1){
            return 0;
        } else{
            map[i][j] = 1;
            area++;
            dfs(i+1,j);
            dfs(i-1,j);
            dfs(i,j-1);
            dfs(i,j+1);
            return area;
        }
    }

}
