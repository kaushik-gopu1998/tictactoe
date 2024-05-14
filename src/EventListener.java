import com.lld.tictactoe.exception.InvalidRequestException;
import com.lld.tictactoe.model.Marker;

public interface EventListener {
    void listen(int r, int c,EventEmitter eventEmitter) throws InvalidRequestException;
}
