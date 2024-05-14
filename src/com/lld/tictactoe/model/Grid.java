package com.lld.tictactoe.model;

import com.lld.tictactoe.exception.InvalidRequestException;

public class Grid {
    private int n;
    private char grid[][];
    private int cellsUnMarked;
    public Grid(int n){
        this.n=n;
        grid = new char[n][n];
        cellsUnMarked = n*n;
        initialise();
    }
    public synchronized void setMarker(int r, int c, char marker) throws InvalidRequestException {
        if(r<0 || r>=n || c<0 || c>=n || grid[r][c]!='.') throw  new InvalidRequestException("Marker cannot be set for the given row and column");
        grid[r][c]=marker;
        cellsUnMarked--;
    }
    public boolean isDone(){
        return cellsUnMarked==0;
    }
    public void displayGrid(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void reset(){
        initialise();
    }
    public void initialise(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = '.';
            }
        }
    }
    public char[][] getGrid(){
        return grid;
    }
}
