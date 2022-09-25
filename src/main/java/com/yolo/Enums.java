package com.yolo;

public class Enums {

    public enum Piece{
        NoPiece,

        WhiteKing(1),
        WhiteQueen(1),
        WhiteBishop(1),
        WhiteKnight(1),
        WhiteRook(1),
        WhitePawn(1),

        BlackKing(2),
        BlackQueen(2),
        BlackBishop(2),
        BlackKnight(2),
        BlackRook(2),
        BlackPawn(2);

        int group;
        Piece(){
            this.group = 0;
        }

        Piece(int group){
            this.group = group;
        }
    }

    public enum AnsiColor{
        RED_ON_WHITE("\033[31;49m"),
        RED_ON_BLACK("\033[31;49m"),
        BLUE_ON_WHITE("\033[34;49m"),
        BLUE_ON_BLACK("\033[34;49m"),
        YELLOW_ON_WHITE("\033[33;49m"),
        YELLOW_ON_BLACK("\033[33;49m"),
        BORDER_COLOR("\033[35;49m"),
        DEFAULT;

        final String START;
        final String REST;


        AnsiColor(String start){
            this.START = start;
            this.REST = "\033[0m";
        }

        AnsiColor(){
            this.START = "\033[0m";
            this.REST = "\033[0m";
        }


    }

}
