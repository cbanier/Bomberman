package fr.ubx.poo.game;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static fr.ubx.poo.game.WorldEntity.Empty;

public class WorldFromFile extends World{
    private static WorldEntity[][] createRaw(String file){
        try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            String lineValue = in.readLine();
            int width = lineValue.length();

            ArrayList<char[]> Lines = new ArrayList<>();
            while (lineValue != null){
                Lines.add(lineValue.toCharArray());
                lineValue = in.readLine();
            }
            WorldEntity[][] map = new WorldEntity[width][Lines.size()];
            for (int i=0;i<width;i++){
                for (int j=0;j<Lines.size();j++){
                    map[i][j] = WorldEntity.fromCode(Lines.get(i)[j]).orElse(Empty);
                }
            in.close();
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WorldFromFile(String file) {
        super(Objects.requireNonNull(createRaw(file)));
    }
}
