import java.util.*;

class Person {
    char name[] = new char[110];
    String phone;
    String ns;
    char dm[]= new char[18];

    void print() {
        for(int i=0,j=0;i<18;i++)
        {
            if(i==4) dm[i]=' ';
            else if(i==10) dm[i]='-';
            else if(i==14) dm[i]=' ';
            else 
            {
                dm[i]=phone.charAt(j);
                j++;
            }
        }
        phone= new String(dm);
    }
}

public class Problem_1 {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt();
        Person[] list = new Person[k];
        sc.nextLine(); // Consume the newline character after reading the integer

        for (int i = 0; i < k; i++) {
            char[] name = new char[100]; // Initialize name array for each Person object
            String inputLine = sc.nextLine(); // Read the input line and remove leading/trailing whitespace
            int index = 0;
            for (int j = 0; j < inputLine.length(); j++) {
                char ch = inputLine.charAt(j);
                if ((index > 0 && name[index - 1] == ' ') || index == 0) {
                   
                    if (ch == ' ') {
                        continue;
                    }
                }
                
                if(index>0)
                {
                    if ((index != 0 || name[index - 1] != ' ') && (ch >= 'A' && ch <= 'Z')) {
                        ch = (char) (ch + ('a' - 'A')); // Convert uppercase to lowercase
                    }
                }
                if ((index == 0 || name[index - 1] == ' ') && (ch >= 'a' && ch <= 'z')) {
                    ch = (char) (ch - ('a' - 'A')); // Convert lowercase to uppercase
                }
                
                name[index++] = ch;
            }
            int lastIndex = index - 1;
            while (lastIndex >= 0 && name[lastIndex] == ' ') {
                name[lastIndex]='\0';
                lastIndex--;
            }
            
            name[index] = '\0';


            String phone = sc.next();
            //sc.nextLine();
            if (phone.charAt(0) != '+' || phone.charAt(1) != '8' || phone.charAt(2) != '8') {
                //System.out.print(" "+phone.charAt(0)+" "+phone.charAt(1)+" "+phone.charAt(2)+" ");
                phone = "+880" + phone;
            }
            sc.nextLine();

            list[i] = new Person();
            list[i].name = name;
            list[i].phone = phone;
            list[i].ns= new String(list[i].name);
            list[i].print();
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                String ns1 = list[j].ns;
                String ns2 = list[j + 1].ns;
                int minLength = Math.min(ns1.length(), ns2.length());
                boolean swapped = false;
                
                for (int t = 0; t < minLength; t++) {
                    char char1 = ns1.charAt(t);
                    char char2 = ns2.charAt(t);
                    if (char1 != char2) {
                        if (char1 > char2) {
                            // Swap the elements if they are in the wrong order
                            Person temp = list[j];
                            list[j] = list[j + 1];
                            list[j + 1] = temp;
                        }
                        swapped = true;
                        break;
                    }
                }
                
                // If the common prefix is the same but one string is shorter, swap them
                if (!swapped && ns1.length() > ns2.length()) {
                    // Swap the elements if they are in the wrong order
                    Person temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

         String demo = sc.next();

        for (int i = 0; i < k; i++) {
            String nameString = new String(list[i].name);
            boolean found = false;
            for (int j = 0; j < nameString.length(); j++) {
                boolean match = true;
                for (int t = 0; t < demo.length(); t++) {
                    char nameChar = nameString.charAt(j + t);
                    char demoChar = demo.charAt(t);
                    if (nameChar >= 'A' && nameChar <= 'Z') {
                        nameChar += 32;
                    }
                    if (demoChar >= 'A' && demoChar <= 'Z') {
                        demoChar += 32;
                    }
                    if (nameChar != demoChar) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println(nameString + " " + list[i].phone);
            }
        }
    }
}
