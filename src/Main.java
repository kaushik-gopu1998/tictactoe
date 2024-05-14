import com.lld.tictactoe.exception.InvalidRequestException;
import com.lld.tictactoe.model.Grid;
import com.lld.tictactoe.model.Marker;

public class Main {
    public static void main(String[] args) throws InvalidRequestException {
        Grid grid = new Grid(3);
        EventListener tic_tac_toe = new TicTacToe(grid);
        EventEmitter player1 = new Player("Kaushik", Marker.O, tic_tac_toe);
        EventEmitter player2 = new Player("Rakesh", Marker.X, tic_tac_toe);
        player1.press(0,0);
        player2.press(0,1);
        player1.press(1,1);
        player2.press(0,2);
        player1.press(2,2);
    }
}
