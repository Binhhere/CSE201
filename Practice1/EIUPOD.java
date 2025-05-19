import java.io.*;
import java.util.*;
 
 class EIUPOD {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder str = new StringBuilder();
        
        int n = reader.nextInt();
        HashMap<Integer, DateOfBirth> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int day = reader.nextInt();
            int month = reader.nextInt();
            int year = reader.nextInt();
            int doB = year * 10000 + month * 100 + day;
            if (hashMap.get(doB) == null) {
                DateOfBirth db = new DateOfBirth(year, month, day, doB);
                hashMap.put(doB, db);
            } else {
                DateOfBirth existedDB = hashMap.get(doB);
                existedDB.count++;
            }
        }
        List<DateOfBirth> dbb = new ArrayList<>(hashMap.values());
        dbb.sort((s1, s2) -> {
            int compare = s1.year - s2.year;
            if (compare == 0) {
                compare = s1.month - s2.month;
                if (compare == 0) {
                    compare = s1.date - s2.date;
                }
            }
            return compare;
        });
 
        for (DateOfBirth dateOfBirth : dbb) {
            str.append(dateOfBirth.Output()).append("\n");
        }
        System.out.println(str);
    }
 
    public static class DateOfBirth {
        public int year;
        public int month;
        public int date;
        public int doB;
        public int count = 1;
 
        public DateOfBirth(int year, int month, int date, int doB) {
            this.doB = doB;
            this.year = year;
            this.month = month;
            this.date = date;
 
        }
 
        public String Output() {
            StringBuilder str = new StringBuilder();
            if (date < 10) {
                str.append(0).append(date).append("/");
            } else {
                str.append(date).append("/");
            }
            if (month < 10) {
                str.append(0).append(month).append("/");
            } else {
                str.append(month).append("/");
            }
            str.append(year);
            str.append(" " + count);
            return str.toString();
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
    }}