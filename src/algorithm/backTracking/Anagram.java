package algorithm.backTracking;

import java.util.*;
import java.io.*;

// 애너그램
public class Anagram {

    static List<Character>[] words;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        words = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            words[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String word = reader.readLine();
            for (int j = 0; j < word.length(); j++) {
                words[i].add(word.charAt(j));
            }
            Collections.sort(words[i]);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[words[i].size()];
            backTracking(i, 0, new StringBuilder());
        }

        reader.close();
    }

    private static void backTracking(int suq, int depth, StringBuilder builder) {
        if (depth == words[suq].size()) {
            System.out.println(builder.toString());
            return;
        }

        char prev = '\0';
        for (int i = 0; i < words[suq].size(); i++) {
            if (!visited[i] && !words[suq].get(i).equals(prev)) {
                builder.append(words[suq].get(i));
                visited[i] = true;
                backTracking(suq, depth + 1, builder);
                visited[i] = false;
                builder.deleteCharAt(builder.length() - 1);
                prev = words[suq].get(i);
            }
        }
    }
}
