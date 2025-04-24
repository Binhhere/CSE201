import java.io.*;
import java.util.*;

public class EIPICNIC {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] count = new int[5]; // count[1] = nhóm 1 người, ..., count[4] = nhóm 4 người

        for (int i = 0; i < n; i++) {
            int groupSize = reader.nextInt();
            count[groupSize]++;
        }

        int cars = count[4]; // nhóm 4 người → 1 xe/nhóm

        // nhóm 3 người ghép với 1 người nếu có
        int min31 = Math.min(count[3], count[1]);
        cars += count[3];
        count[1] -= min31;

        // nhóm 2 người → 2 nhóm = 1 xe
        cars += count[2] / 2;
        count[2] = count[2] % 2;

        // nếu còn 1 nhóm 2 người → cần thêm 1 xe
        if (count[2] == 1) {
            cars += 1;
            count[1] -= Math.min(2, count[1]);
        }

        // nhóm 1 người còn lại → 4 người / xe
        if (count[1] > 0) {
            cars += (count[1] + 3) / 4;
        }

        System.out.println(cars);
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
