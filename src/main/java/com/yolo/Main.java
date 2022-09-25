package com.yolo;

import static com.yolo.Enums.Piece.*;

public class Main {
    static Board main_board;
    public static void main(String[] args) {
        main_board = new Board();
        System.out.println("This is the board : \n"+main_board.toString());
    }
}