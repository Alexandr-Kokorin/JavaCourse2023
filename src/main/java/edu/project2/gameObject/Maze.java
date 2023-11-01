package edu.project2.gameObject;

public final class Maze {

    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new Cell[height][width];
    }

    public void addCell(int row, int col, Type type) {
        grid[row][col] = new Cell(new Coordinate(row, col), type);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
