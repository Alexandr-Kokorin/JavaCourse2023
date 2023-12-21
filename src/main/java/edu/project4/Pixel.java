package edu.project4;

public class Pixel {

    private int red;
    private int green;
    private int blue;
    private int hitCount;
    private double normal;

    public Pixel(int r, int g, int b, int hitCount) {
        red = r;
        green = g;
        blue = b;
        this.hitCount = hitCount;
        normal = 0;
    }

    public void mixColor(int r, int g, int b) {
        red = (red + r) / 2;
        green = (green + g) / 2;
        blue = (blue + b) / 2;
    }

    public void incHitCount() {
        hitCount++;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getHitCount() {
        return hitCount;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
