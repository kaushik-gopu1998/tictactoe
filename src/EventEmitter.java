import com.lld.tictactoe.exception.InvalidRequestException;

public interface EventEmitter {
    void press(int r, int c) throws InvalidRequestException;
}
