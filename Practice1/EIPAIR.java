import java.io.*;
import java.util.*;

class EIPAIR {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int T = reader.nextInt();

        for (int i = 0; i < T; i++) {
            int n = reader.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int price = reader.nextInt();
                map.put(price, map.getOrDefault(price, 0) + 1);
            }

            long sumCouple = 0;
            for (int count : map.values()) {
                if (count >= 2) {
                    sumCouple += (long) count * (count - 1) / 2;
                }
            }

            str.append(sumCouple).append("\n"); 
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
                } catch (IOException e) {}
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
