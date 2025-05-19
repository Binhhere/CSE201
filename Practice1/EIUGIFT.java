import java.io.*;
import java.util.*;

class EIUGIFT {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = reader.nextInt();
        }
        Arrays.sort(prices);

        int i = 0, j = n - 1;
        int tongMax = -1;
        int hieuMin = 1511300503;

        while (i < j) {
            int tong = prices[i] + prices[j];

            if (tong > k) {
                j--;
            } else {
                int hieu = Math.abs(prices[i] - prices[j]);

                if (tong > tongMax || tong == tongMax && hieu < hieuMin) {
                    tongMax = tong;
                    hieuMin = hieu;
                }
                i++;
            }
        }
        if (tongMax == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(tongMax + " " + hieuMin);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
