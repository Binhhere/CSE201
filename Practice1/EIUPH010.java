import java.io.*;
import java.util.*;

public class EIUPH010 {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] count = new int[1000000];
        int maxFreq = 0;
        int minNum = 0;

        for (int i = 0; i < n; i++) {
            int x = reader.nextInt();
            count[x]++;
            if (count[x] > maxFreq) {
                maxFreq = count[x];
                minNum = x;
            } else if (count[x] == maxFreq && x < minNum) {
                minNum = x;
            }
        }

        System.out.println(minNum + " " + maxFreq);
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
