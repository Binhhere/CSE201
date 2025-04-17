package Practice1;

import java.util.*;
import java.io.*;

class learning {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        String line1 = reader.next();
        String line2 = reader.next();
        int again = 0;

        for (int i = 0; i < Math.min(line1.length(), line2.length()); i++) {
            if (line1.endsWith(line2.substring(0, i))) {
                again = i;
            }
        }
        System.out.print(line1.length() + line2.length() - again);
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
