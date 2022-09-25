package com.yolo;
import com.yolo.Enums.Piece;

public class Tile {
    char row;
    char column;
    Piece piece;

    Tile(char row,char column,Piece piece){
        this.row = row;
        this.column = column;
        this.piece = piece;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
