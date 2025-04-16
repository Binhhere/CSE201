import java.util.*;
import java.io.*;

class EIUONCE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int T = reader.nextInt();

        for (int t = 0; t < T; t++) {
            int n = reader.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                int a = reader.nextInt();
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    str.append(num).append(" ");
                }
            }
            str.append("\n");
        }
        System.out.print(str);
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
