import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static char[][] board;
    private static int result = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(reader.readLine());
            board = new char[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = reader.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (j + 1 < N) {
                        swap(i, j, i, j + 1);
                        check();
                        swap(i, j, i, j + 1);
                    }

                    if (i + 1 < N) {
                        swap(i, j, i + 1, j);
                        check();
                        swap(i, j, i + 1, j);
                    }
                }
            }

            System.out.println(result);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static void check() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }

    }
}
