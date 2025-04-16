package Practice1;

import java.io.*;
import java.util.*;

class EIKMAX {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int n = reader.nextInt();
        int k = reader.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(reader.nextInt());
        }

        list.sort((n1, n2) -> Integer.compare(n2, n1));

        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i) + " ");
        }
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
