public class HideCharacter {
    public void hideKarakter(String input) {
        Boolean flag = true;
        if (input.length() <= 2) {
            flag = false;
        }

        String[] arrNama = input.split(" ");
        StringBuilder hasil = new StringBuilder();

        for(int i=0;i<arrNama.length;i++)
        {
            for(int j=0;j<arrNama[i].length(); j++)
            {
                if(j==0)
                {
                    hasil.append(arrNama[i].charAt(j) + "***");
                }
                if (j==arrNama[i].length()-1)
                {
                    hasil.append(arrNama[i].charAt(j));
                }
            }
            hasil.append(" ");
        }

        if(flag) System.out.print(new String(hasil));
        else System.out.print(input);
    }
}
