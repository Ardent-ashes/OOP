import java.util.Scanner;

class Recursion {
    String st;

    void permute(char[] s, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(s));
        } else {
            for (int i = l; i < r; i++) {
                char temp = s[l];
                s[l] = s[i];
                s[i] = temp;

                permute(s, l + 1, r);

                temp = s[l];
                s[l] = s[i];
                s[i] = temp;
            }
        }
    }
}

public class prime {
    public static void main(String[] args) {
        Recursion pc = new Recursion();
        Scanner sc = new Scanner(System.in);
        pc.st = sc.next();
        pc.permute(pc.st.toCharArray(), 0, pc.st.length());
    }
}
