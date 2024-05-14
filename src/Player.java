import com.lld.tictactoe.exception.InvalidRequestException;
import com.lld.tictactoe.model.Marker;

public class Player implements EventEmitter{
    private String name;
    private Marker marker;
    private EventListener listener;
    public Player(String theName, Marker theMarker, EventListener theListener){
        name=theName;
        marker=theMarker;
        listener=theListener;
    }
    @Override
    public void press(int r, int c) throws InvalidRequestException {
        listener.listen(r, c,this);
    }
    public Marker getMarker(){
        return marker;
    }
    public String getName(){
        return name;
    }
}
