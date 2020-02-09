package com.bushemi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Map2DTest {

    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 300;

    @Test
    public void mapSizeShouldReturnMultiplyXAndY() {
        //given
        Map2D map = new Map2D(SIZE_X, SIZE_Y);

        //when
        long mapSize = map.getMapSize();

        //then
        assertEquals(SIZE_X * SIZE_Y, mapSize);
    }

    @Test
    public void maxXShouldReturnSIZE_X() {
        //given
        Map2D map = new Map2D(SIZE_X, SIZE_Y);

        //when
        long maxX = map.getMaxX();

        //then
        assertEquals(SIZE_X , maxX);
    }

    @Test
    public void maxYShouldReturnSIZE_Y() {
        //given
        Map2D map = new Map2D(SIZE_X, SIZE_Y);

        //when
        long maxY = map.getMaxY();

        //then
        assertEquals(SIZE_Y, maxY);
    }
}
