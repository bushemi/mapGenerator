package com.bushemi;

public class Map2D {
    private MapCell[][] map;
    private long mapSize;
    private int maxX;
    private int maxY;

    public Map2D(int lengthX, int lengthY) {
        map = new MapCell[lengthX][lengthY];
        for (int x = 0; x < lengthX; x++) {
            for (int y = 0; y < lengthY; y++) {
                map[x][y] = new MapCell(x, y);
            }
        }
    }

    public MapCell getMapCell(int x, int y) {
        if ((x > 0) && (x < maxX) && (y > 0) && (y < maxY)) {
            return map[x][y];
        }
        throw new RuntimeException("not valid coordinates.");
    }
}
