package com.yolo;

import static com.yolo.Enums.Piece.*;
import com.yolo.Enums.Piece;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.List;

public class Board {
    ArrayList<Tile> atlas;
    char[] rows = "87654321".toCharArray();
    char[] columns = "ABCDEFGH".toCharArray();

    public Board(){ // Created default board

        atlas = new ArrayList<>();

        for (int i=0;i!=rows.length;i++){
            for (int c=0;c!=columns.length;c++){
                atlas.add(new Tile(rows[i],columns[c],NoPiece));
            }
        }

        fillBoard();

    }

    private void fillBoard(){
        for (int i=0;i!=atlas.size();i++){
            if (atlas.get(i).row == '2'){
                atlas.get(i).piece = WhitePawn;
            }else if (atlas.get(i).row == '7'){
                atlas.get(i).piece = BlackPawn;
            }
        }

        findTile('1','A').piece = WhiteRook;
        findTile('1','H').piece = WhiteRook;
        findTile('1','B').piece = WhiteKnight;
        findTile('1','G').piece = WhiteKnight;
        findTile('1','C').piece = WhiteBishop;
        findTile('1','F').piece = WhiteBishop;
        findTile('1','D').piece = WhiteQueen;
        findTile('1','E').piece = WhiteKing;

        findTile('8','A').piece = BlackRook;
        findTile('8','H').piece = BlackRook;
        findTile('8','B').piece = BlackKnight;
        findTile('8','G').piece = BlackKnight;
        findTile('8','C').piece = BlackBishop;
        findTile('8','F').piece = BlackBishop;
        findTile('8','D').piece = BlackQueen;
        findTile('8','E').piece = BlackKing;


    }

    public Tile findTile(char row,char column){

        for (int i=0;i!=atlas.size();i++){
            if (atlas.get(i).row == row && atlas.get(i).column == column){
                return atlas.get(i);
            }
        }

        throw new Error("Could not find Tile with row : "+row+" and column : "+column+" ! ");
    }

    @Override
    public String toString() {
        String map = "";

        Enums.AnsiColor ansi = Enums.AnsiColor.BORDER_COLOR;

        for (int i=-3;i!=columns.length+3;i++){ // TOP BORDERS
            if (0<=i && i<columns.length){
                map+=getAnsi(String.valueOf(columns[i]),ansi);
            }else{
                map+=getAnsi(".",ansi);
            }
        }
        map+="\n";


        boolean isBlack = false;

        for (int i=0;i!=atlas.size();i++){

            if (atlas.get(i).column=='A'){ // LEFT REAR BORDERS
                isBlack=!isBlack;

                ansi = Enums.AnsiColor.BORDER_COLOR;
                map+=getAnsi(atlas.get(i).row+"  ",ansi);

            }

            if (atlas.get(i).piece.group==0){
                if (isBlack){
                    ansi = Enums.AnsiColor.YELLOW_ON_BLACK;
                }else{
                    ansi = Enums.AnsiColor.YELLOW_ON_WHITE;
                }
            }
            else if(atlas.get(i).piece.group==1){
                if (isBlack){
                    ansi = Enums.AnsiColor.BLUE_ON_BLACK;
                }else{
                    ansi = Enums.AnsiColor.BLUE_ON_WHITE;
                }
            }
            else if(atlas.get(i).piece.group==2){
                if (isBlack){
                    ansi = Enums.AnsiColor.RED_ON_BLACK;
                }else{
                    ansi = Enums.AnsiColor.RED_ON_WHITE;
                }
            }


            map+= getAnsi(Integer.toHexString(atlas.get(i).piece.ordinal()),ansi);


            if(atlas.get(i).column=='H'){ // RIGHT REAR BORDERS
                ansi = Enums.AnsiColor.BORDER_COLOR;
                map+=getAnsi("  " + atlas.get(i).row ,ansi);
                map+="\n";
            }

            isBlack = !isBlack;
        }


        ansi = Enums.AnsiColor.BORDER_COLOR;
        for (int i=-3;i!=columns.length+3;i++){ // BOTTOM BORDERS
            if (0<=i && i<columns.length){
                map+=getAnsi(String.valueOf(columns[i]),ansi);
            }else{
                map+=getAnsi(".",ansi);
            }
        }

        map+="\n";

        return map;
    }

    private static String getAnsi(String text, Enums.AnsiColor color){
        return color.START+text+color.REST;
    }

}
