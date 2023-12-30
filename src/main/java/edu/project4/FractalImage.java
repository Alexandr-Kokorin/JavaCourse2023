package edu.project4;

public record FractalImage(Pixel[][] data, int width, int height) {

    public static FractalImage create(int width, int height) {
        Pixel[][] data = new Pixel[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = new Pixel(0, 0, 0, 0);
            }
        }
        return new FractalImage(data, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel pixel(World world, Point point) {
        int x = (int) (width - Math.floor((((world.x() + world.width()) - point.x()) / world.width()) * width));
        int y = (int) (height - Math.floor((((world.y() + world.height()) - point.y()) / world.height()) * height));
        return contains(x, y) ? data[y][x] : null;
    }
}
