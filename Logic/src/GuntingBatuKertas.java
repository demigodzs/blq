public class GuntingBatuKertas {
    public void calculateWinner(int jarakAwal, String[] langkahA, String[] langkahB)
    {
        Boolean isWinnerA = false;
        int lajuA = 0;
        int lajuB = jarakAwal;
        for(int i=0; i<langkahA.length; i++)
        {
            if (langkahA[i].equals("G") && langkahB[i].equals("B")) {
                lajuA -= 1;
                lajuB += 2;
            } else if (langkahA[i].equals("B") && langkahB[i].equals("G")) {
                lajuA += 2;
                lajuB -= 1;
            } else if (langkahA[i].equals("G") && langkahB[i].equals("K")) {
                lajuA += 2;
                lajuB -= 1;
            } else if (langkahA[i].equals("K") && langkahB[i].equals("G")) {
                lajuA -= 1;
                lajuB += 2;
            } else if (langkahA[i].equals("B") && langkahB[i].equals("K")) {
                lajuA -= 1;
                lajuB += 2;
            } else if (langkahA[i].equals("K") && langkahB[i].equals("B")) {
                lajuA += 2;
                lajuB -= 1;
            }

            if(lajuB-lajuA == 0 || lajuA > lajuB)
            {
                isWinnerA = true;
                break;
            }
        }

        if(isWinnerA) System.out.print("The Winner is A");
        else System.out.print("Draw");
    }    
}
