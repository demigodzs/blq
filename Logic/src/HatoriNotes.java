public class HatoriNotes {
    public void calculateHatoriNotes(String[] arrNotes)
    {
        int totalGunung = 0;
        int totalLembah = 0;
        int counter = 0;
        Boolean flagNaek = false;
        if(arrNotes[0].equals("N")) 
        {
            counter = 1;
            flagNaek = true;
        }
        else 
        {
            counter = -1;
            flagNaek = false;
        }
        for(int i=1; i<arrNotes.length; i++)
        {
            if(arrNotes[i].equals("N")) counter++;
            else counter--;

            if(counter==0 && flagNaek.equals(true))
            {
                totalGunung++;
                if(i+1 != arrNotes.length)
                {
                    if(arrNotes[i+1].equals("T")) flagNaek = false;
                    else flagNaek = true;
                }
            }
            else if(counter==0 && flagNaek.equals(false))
            {
                totalLembah++;
                if(i+1 != arrNotes.length)
                {
                    if(arrNotes[i+1].equals("T")) flagNaek = false;
                    else flagNaek = true;
                }
            }
        }

        System.out.println("Total Gunung yang di lewati Hatori: " + totalGunung);
        System.out.print("Total Lembah yang di lewati Hatori: " + totalLembah);
    }
}
