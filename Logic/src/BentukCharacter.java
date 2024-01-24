public class BentukCharacter {
    public void bentukCharacter(String input) {
        StringBuilder inputTemporary = new StringBuilder(input);
        inputTemporary.reverse();
        String reversedInput = inputTemporary.toString();
        int midIndex = reversedInput.length() / 2;
        Boolean flag = false;
        if(reversedInput.length() % 2 != 0)
        {
            flag = true;
        }

        for (int i = 0; i < reversedInput.length(); i++) {
            for (int j = 0; j < reversedInput.length(); j++) {
                if(j==midIndex)
                {
                    if(flag) System.out.print(reversedInput.charAt(i));
                    else System.out.print(reversedInput.charAt(i) + "*");
                }
                else 
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
