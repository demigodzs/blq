public class ManholeGame {
    public void findMinimumSteps(String[] track) {
        int stamina = 0;
        boolean isFailed = false;

        StringBuilder steps = new StringBuilder();
        for (int i = 0; i < track.length; i++) {
            if(i+1 != track.length)
            {
                if(track[0].equals("O"))
                {
                    isFailed = true;
                    break;
                }
                
                if(track[i+1].equals("O"))
                {
                    if(stamina >= 2)
                    {
                        stamina -= 2;
                        steps.append("J ");
                        i = i+2;
                    }
                    else
                    {
                        isFailed = true;
                        break;
                    }
                }
                else
                {
                    stamina += 1;
                    steps.append("W ");
                }
            }

            if(i>= track.length-3 && stamina >= 2)
            {
                steps.append("J");
                break;
            }
            
        }

        if(isFailed) System.out.print("FAILED");
        else System.out.print(steps.toString().trim());
    }
}
