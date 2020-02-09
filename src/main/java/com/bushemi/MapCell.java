package com.bushemi;

public class MapCell {
    private int x = 0;
    private int y = 0;
    private boolean isPassable = true;

    public MapCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MapCell(int x, int y, boolean isPassable) {
        this.x = x;
        this.y = y;
        this.isPassable = isPassable;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean passable) {
        isPassable = passable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapCell mapCell = (MapCell) o;

        if (x != mapCell.x) return false;
        return y == mapCell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "MapCell{" +
                "x=" + x +
                ", y=" + y +
                ", isPassable=" + isPassable +
                '}';
    }
}
