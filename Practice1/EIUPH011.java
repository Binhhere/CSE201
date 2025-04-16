import java.util.*;
import java.io.*;

class EIUPH011 {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int n = reader.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean again = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    again = true;
                    break;
                }
            }
            if (!again) {
                System.out.print(array[i] + " ");
            }
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
