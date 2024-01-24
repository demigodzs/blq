public class Palindrome {
    public void palindrome(String kata) {
        kata = kata.replaceAll("\\s", "").toLowerCase();
        int panjang = kata.length();
        Boolean flag = true;

        for (int i = 0; i < panjang / 2; i++) {
            if (kata.charAt(i) != kata.charAt(panjang - 1 - i)) {
                flag = false;
            }
        }

        if(flag) System.out.print(kata + " adalah palindrome.");
        else System.out.print(kata + " bukan palindrome.");
    }
}
