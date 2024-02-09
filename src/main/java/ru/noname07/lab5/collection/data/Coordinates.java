package ru.noname07.lab5.collection.data;

import java.util.Scanner;

import ru.noname07.lab5.collection.Valid;

public class Coordinates implements Valid {
    private Double x;
    private Float y;

    public Coordinates(double x, Float y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordinates() { // TODO take into account all the "mistakes"
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(System.in);

        System.out.println("Create new `Coordinates`");

        Double x; Float y;
        do {
            System.out.print("x >");
            x = Double.parseDouble(localScanner.nextLine());
        } while (x.isNaN() || x == null || x.isInfinite());

        do {
            System.out.print("y >");
            y = Float.parseFloat(localScanner.nextLine());
        } while (y.isNaN() || y == null || y.isInfinite());

        System.out.println("`Coordinates` was created");

    }

    public Double getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }

    @Override
    public boolean isValid() {
        if (this.x == null || this.x == 0)
            return false;
        if (this.y == 0 || this.y > 715 || this.y == null)
            return false;

        return true;
    }

}