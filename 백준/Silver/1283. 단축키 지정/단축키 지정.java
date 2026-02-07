import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            Set<Character> used = new HashSet<>();

            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                String result = assignShortcut(line, used);
                System.out.println(result);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String assignShortcut(String line, Set<Character> used) {
        String[] words = line.split(" ");
        int index = 0;

        for (String word : words) {
            char c = Character.toLowerCase(word.charAt(0));
            if (!used.contains(c)) {
                used.add(c);
                return mark(line, index);
            }
            index += word.length() + 1;
        }

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == ' ') {
                continue;
            }

            char lower = Character.toLowerCase(ch);
            if (!used.contains(lower)) {
                used.add(lower);
                return mark(line, i);
            }
        }

        return line;
    }

    private static String mark(String line, int idx) {
        return line.substring(0, idx)
                + "[" + line.charAt(idx) + "]"
                + line.substring(idx + 1);
    }
}