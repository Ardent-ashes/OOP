

import java.util.Scanner;

class recursion{
   String st;
int palindrome(int n)
 {
    if(2*n>=st.length() || (2*n+1)>=st.length())
    {
        return 1;
    }

    if(st.charAt(n)==st.charAt(st.length()-1-n))
    {
        return palindrome(n+1);
    }
    else
    {
        return 0;
    }
    
}
}

public class prime{
    public static void main(String [] args){


        recursion pc = new recursion();
        Scanner sc = new Scanner(System.in);
        pc.st=sc.next();
        int r=pc.palindrome(0);
        System.out.println(r);
        
}
}

