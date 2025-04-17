package Practice1;

import java.util.*;
import java.io.*;

class learning {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {

        int n = reader.nextInt();
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = reader.nextInt();
        }
        Arrays.sort(pages);

        int i = 0;
        while (i < n) {

            int start = i;
            while (i + 1 < n && pages[i + 1] == pages[i] + 1) {
                i++;
            }
            int count = i - start + 1;
            if (count >= 3) {
                str.append(pages[start]).append("-").append(pages[i]).append(" ");
            } else {
                for (int j = start; j <= i; j++) {
                    str.append(pages[j]).append(" ");
                }
            }
            i++;
        }
        System.out.println(str.toString().trim());
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
