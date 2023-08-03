import java.util.Scanner;

public class IsPalindromStr {
        static boolean isPalindrome(String str) {
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }


        public static void main(String[] args) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Enter the word : ");
            String word = inp.next();
            System.out.println(isPalindrome(word));
        }
}