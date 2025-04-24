import java.io.*;
import java.util.*;

public class EIUPH014 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n = reader.nextInt();
            if (n == 0)
                break;

            int[] num = new int[n];
            for (int i = 0; i < n; i++)
                num[i] = reader.nextInt();

            int count = 0;
            while (count <= 1000) {
                if (allEqual(num)) {
                    str.append(count).append("\n");
                    break;
                }

                int[] next = new int[n];
                for (int i = 0; i < n - 1; i++) {
                    next[i] = Math.abs(num[i] - num[i + 1]);
                }
                next[n - 1] = Math.abs(num[n - 1] - num[0]);

                num = next;
                count++;
            }

            if (count > 1000) {
                str.append("-1\n");
            }
        }

        System.out.print(str);
    }

    static boolean allEqual(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[0])
                return false;
        }
        return true;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
