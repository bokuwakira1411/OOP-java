package HW2;

import java.util.HashSet;
import java.util.Scanner;

public class String_blowup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String output = blowup(str);
        System.out.println(output);
        int n = maxRun(str);
        System.out.println(n);
        String a = sc.next();
        String b = sc.next();
        int len = sc.nextInt();
        boolean result = stringIntersect(a, b,len);
        System.out.println(result);
    }

    public static String blowup(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) && i != str.length()) {
                if (i + 1 < str.length() && (str.charAt(i + 1) <= 'z' && str.charAt(i + 1) >= 'a')) {
                    for (int j = 0; j < c - '0'; j++) {
                        result.append(str.charAt(i + 1));
                    }
                }
            } else if (!Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int maxRun(String str) {
        int m = 1;
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                if (cnt > m) {
                    m = cnt;
                }
                cnt = 1;
            }
        }
        return m;
    }
    public static boolean stringIntersect(String a, String b, int len){
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= a.length() - len; i++){
            String s = a.substring(i, i + len);
            set.add(s);
        }
        for(int i = 0; i < b.length() - len; i++){
            String s = b.substring(i, i + len);
            if(set.contains(s)){
                return true;
            }
        }
        return false;
    }
}
