import com.lld.tictactoe.exception.InvalidRequestException;
import com.lld.tictactoe.model.Grid;
import com.lld.tictactoe.model.Marker;

public class TicTacToe implements EventListener{
    private Grid grid;
    private EventEmitter lastPlayed;
    public TicTacToe(Grid theGrid){
        grid=theGrid;
    }
    @Override
    public void listen(int r, int c,EventEmitter eventEmitter) throws InvalidRequestException {
        if(lastPlayed!=null && lastPlayed==eventEmitter){
            throw new InvalidRequestException("This player turn was already completed!!");
        }
        lastPlayed=eventEmitter;
        grid.setMarker(r, c, ((Player) eventEmitter).getMarker()==Marker.O?'O':'X');
        if(isWinner(eventEmitter)){
            System.out.println(((Player) eventEmitter).getName()+" is a winner!");
            grid.displayGrid();
            grid.reset();
        } else if (grid.isDone()) {
            System.out.println("Game drawn");
            grid.reset();
        }else{
            System.out.println("********* Current status of the grid ********");
            grid.displayGrid();
        }
    }
    private boolean isWinner(EventEmitter eventEmitter) {
        char marker = ((Player) eventEmitter).getMarker()==Marker.O?'O':'X';
        final char[][] board = grid.getGrid();
        //check all rows
        for(int i=0;i<board.length;i++){
            int count=0;
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==marker) count++;
            }
            if(count==board[0].length) return true;
        }
        //check all columns
        for(int j=0;j<board[0].length;j++){
            int count=0;
            for(int i=0;i<board.length;i++){
                if(board[i][j]==marker) count++;
            }
            if(count==board.length) return true;
        }
        //check all diagonals
        int count=0;
        for(int i=0;i<board.length;i++){
            if(board[i][i]==marker) count++;
        }
        if(count==board.length) return true;
        count=0;
        for(int i=board.length-1,j=0;i>=0;i--,j++){
            if(board[i][j]==marker) count++;
        }
        if(count==board.length) return true;
        return false;
    }
}
