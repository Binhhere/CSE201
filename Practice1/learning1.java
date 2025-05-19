import java.io.*;
import java.util.*;

class learning1 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        reader.nextInt(); // bỏ qua 0
        int m = reader.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String command = reader.next();
            if (command.equals("insertAt")) {
                int position = reader.nextInt();
                int value = reader.nextInt();
                linkedList.insertAt(position, value);
            } else if (command.equals("getAt")) {
                int position = reader.nextInt();
                Integer result = linkedList.getAt(position);
                if (result == null) {
                    str.append("null\n");
                } else {
                    str.append(result).append("\n");
                }
            }
        }

        System.out.print(str);
    }

    static class LinkedList<T extends Number> {
        private static class LinkedNode<U extends Number> {
            U number;
            LinkedNode<U> next;

            public LinkedNode(U number) {
                this.number = number;
            }
        }

        LinkedNode<T> head = null;

        public void insertAt(int position, T number) {
            LinkedNode<T> newNode = new LinkedNode<>(number); //number lúc này là value lấy ở trên

            if (position == 0 || head == null) {
                newNode.next = head;
                head = newNode;
                return;
            }

            LinkedNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current.next == null)
                    break;
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        public T getAt(int position) {
            LinkedNode<T> current = head;
            int i = 0;
            while (current != null) {
                if (i == position)
                    return current.number;
                current = current.next;
                i++;
            }
            return null;
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
