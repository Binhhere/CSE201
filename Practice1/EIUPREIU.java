import java.io.*;
import java.util.*;

class EIUPREIU {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        StringBuilder str = new StringBuilder();

        if (n % 2 != 0 || n > 1000) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            // Chữ E
            if (i == 0) {
                str.append(" ");
                for (int j = 0; j < n / 2; j++) str.append("_");
            } else if (i == n / 2 || i == n - 1) {
                str.append("|");
                for (int j = 0; j < n / 2; j++) str.append("_");
            } else {
                str.append("|");
                for (int j = 0; j < n / 2; j++) str.append(" ");
            }

            str.append(" "); // khoảng cách giữa E và I

            // Chữ I (luôn là " |")
            str.append(" |");

            str.append(" "); // khoảng cách giữa I và U

            // Chữ U
            if (i == n - 1) {
                str.append("|");
                for (int j = 0; j < n / 2; j++) str.append("_");
                str.append("|");
            } else {
                str.append("|");
                for (int j = 0; j < n / 2; j++) str.append(" ");
                str.append("|");
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
