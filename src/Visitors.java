import java.util.List;
import java.util.Map;
import java.util.Random;

public class Visitors {
    private static int id=1;
    private String name;
    private Map <Integer,Integer>preference;
    private List<Facility> amusementFacilities;
    private boolean occupied;

    public Visitors( List<Facility> amusementFacilities, boolean occupied) {
        Random random = new Random();
        int counter=0;
        int  preferValue= random.nextInt(0,101)/100;
        for (Facility facilities: amusementFacilities){
            this.preference.put((int) facilities.getId(),preferValue);
            counter+=preferValue;
            if (counter>100){
                break;
            }

        }
        this.amusementFacilities = amusementFacilities;
        this.occupied =false;
    }
    public void usedFacilities(Facility facility){
        this.preference.remove(facility);
    }

}
