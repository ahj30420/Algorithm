import java.util.*;

class Solution {

    static class Word {
        String text;
        int start, end;
        boolean isSpoiler;

        Word(String text, int start, int end, boolean isSpoiler) {
            this.text = text;
            this.start = start;
            this.end = end;
            this.isSpoiler = isSpoiler;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();

        boolean[] isSpoiler = new boolean[n];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isSpoiler[i] = true;
            }
        }

        List<Word> words = new ArrayList<>();
        int i = 0;

        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i - 1;

            String word = message.substring(start, end + 1);

            boolean spoiler = false;
            for (int j = start; j <= end; j++) {
                if (isSpoiler[j]) {
                    spoiler = true;
                    break;
                }
            }

            words.add(new Word(word, start, end, spoiler));
        }

        Set<String> normalWords = new HashSet<>();
        for (Word w : words) {
            if (!w.isSpoiler) {
                normalWords.add(w.text);
            }
        }

        Set<String> revealed = new HashSet<>();
        int answer = 0;

        for (Word w : words) {
            if (!normalWords.contains(w.text) && !revealed.contains(w.text)) {
                answer++;
                revealed.add(w.text);
            }
        }

        return answer;
    }
}