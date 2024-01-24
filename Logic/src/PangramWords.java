import java.util.HashSet;
import java.util.Set;

public class PangramWords {
    public void isPangram(String input) {
        Set<Character> letterSet = new HashSet<>();

        String lowercaseInput = input.toLowerCase();

        for (char c : lowercaseInput.toCharArray()) {
            if (Character.isLetter(c)) {
                letterSet.add(c);
            }
        }

        if(letterSet.size() == 26) System.out.print("Pangram");
        else System.out.print("Bukan pangram");
    }
}
