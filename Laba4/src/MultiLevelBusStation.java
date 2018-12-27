import java.util.ArrayList;

public class MultiLevelBusStation {
	ArrayList<BusStation<ITransport>> parkingStages;
    private  int countPlaces = 20; 
    public MultiLevelBusStation(int countStages, int pictureWidth, int pictureHeight)
    {
        parkingStages = new ArrayList<BusStation<ITransport>>();
        for(int i =0; i< countStages; ++i)
        {
            parkingStages.add(new BusStation<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }
   

    public BusStation<ITransport> getBusStation(int ind){
   	 if((ind>-1) && (ind < parkingStages.size()))
        {
            return parkingStages.get(ind);
        }
        return null;
    }
}
