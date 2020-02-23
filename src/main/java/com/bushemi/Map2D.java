package com.bushemi;

import java.util.Random;

/**
 * For creating or changing map of MapCell objects.
 */
public class Map2D {
    private static Random RANDOM = new Random();
    private MapCell[][] map;
    private long mapSize;
    private int maxX;
    private int maxY;
    private boolean areAllPassable;

    /**
     * Create empty map.
     *
     * @param lengthX maximum X
     * @param lengthY maximum Y
     */
    public Map2D(int lengthX, int lengthY) {
        map = new MapCell[lengthX][lengthY];
        mapSize = lengthX * lengthY;
        maxX = lengthX;
        maxY = lengthY;
        initNewMap(lengthX, lengthY);
        areAllPassable = true;
    }

    private void initNewMap(int lengthX, int lengthY) {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                map[x][y] = new MapCell(x, y);
            }
        }
    }

    /**
     * Get map cell from map.
     *
     * @param x int
     * @param y int
     * @return MapCell object.
     */
    public MapCell getMapCell(int x, int y) {
        if ((x >= 0) && (x < maxX) && (y >= 0) && (y < maxY)) {
            return map[x][y];
        }
        throw new RuntimeException("not valid coordinates.");
    }

    /**
     * Get Map size.
     *
     * @return long
     */
    public long getMapSize() {
        return mapSize;
    }

    /**
     * Get maximum X for current map.
     *
     * @return int maximum X
     */
    public int getMaxX() {
        return map.length;
    }

    /**
     * Gget maximum Y for current map.
     *
     * @return int maximum Y
     */
    public int getMaxY() {
        return map[1].length;
    }

    /**
     * Resets map and generates new obstacles.
     *
     * @param percentOfTotalCells int
     */
    public void regenerateObstacles(int percentOfTotalCells) {
        if (percentOfTotalCells > 0 && percentOfTotalCells < 100) {
            if (!areAllPassable) {
                initNewMap(maxX, maxY);
            }
            long totalObstacleCount = Math.round(mapSize * ((double) percentOfTotalCells / 100));
            for (long obstacleCount = 0; obstacleCount < totalObstacleCount; ) {
                int newX = RANDOM.nextInt(maxX);
                int newY = RANDOM.nextInt(maxY);
                MapCell mapCell = map[newX][newY];
                if (mapCell.isPassable()) {
                    mapCell.setPassable(false);
                    obstacleCount++;
                }
            }
        }
    }
}
