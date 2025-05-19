import java.util.*;
import java.io.*;

class EILINKED {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String name = reader.next();
            int numCourses = reader.nextInt();
            int totalScore = 0;
            for (int j = 0; j < numCourses; j++) {
                totalScore += reader.nextInt();
            }
            double averageScore = (double) totalScore / numCourses;
            students.add(new Student(name, averageScore, i));
        }

        Collections.sort(students);

        for (int i = 0; i < Math.min(2, students.size()); i++) {
            System.out.println(students.get(i).name);
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        double averageScore;
        int index;

        public Student(String name, double averageScore, int index) {
            this.name = name;
            this.averageScore = averageScore;
            this.index = index;
        }

        @Override
        public int compareTo(Student other) {
            if (Double.compare(other.averageScore, this.averageScore) != 0) {
                return Double.compare(other.averageScore, this.averageScore);
            } else {
                return Integer.compare(this.index, other.index);
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
