package com.yolo;

import static com.yolo.Enums.Piece.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    ArrayList<Tile> atlas;
    char[] rows = "12345678".toCharArray();
    char[] columns = "ABCDEFGH".toCharArray();

    public Board(){

        atlas = new ArrayList<>();

        for (int i=0;i!=rows.length;i++){
            for (int c=0;c!=columns.length;c++){
                atlas.add(new Tile(rows[i],columns[c],NoPiece));
            }
        }
    }


    @Override
    public String toString() {
        String map = "";


        for (int i=-4;i!=columns.length+4;i++){
            if (0<=i && i<columns.length){
                map+=columns[i];
            }else{
                map+=".";
            }
        }
        map+="\n";

        for (int i=0;i!=atlas.size();i++){

            if (atlas.get(i).column=='A'){
                map += atlas.get(i).row+" : ";
            }

            map+=atlas.get(i).piece.ordinal();

            if(atlas.get(i).column=='H'){
                map += " : " + atlas.get(i).row +"\n";

            }
        }

        for (int i=-4;i!=columns.length+4;i++){
            if (0<=i && i<columns.length){
                map+=columns[i];
            }else{
                map+=".";
            }
        }
        map+="\n";




        return map;
    }
}
