package com.company;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(-4, -3); //konstruktor do 1 punktu
        Point point2 = new Point(4, 3); // konstruktor do 2 punktu
        Point point3 =new Point(1,2);
        //Point point3 =new Point(); //czyli byłoby takie jak domyślny
        Segment segment = new Segment(point1, point2); // klasa w której tworze 2 punkty
        System.out.println(segment.segmentLength());
        System.out.println(segment);
        segment.rotate(120); //przykłądowe
        System.out.println(segment);
        System.out.println(segment.segmentLength());
        segment.rotate(120);
        System.out.println(segment);
        System.out.println(segment.segmentLength());
        segment.rotate(120);
        System.out.println(segment);
        System.out.println(segment.segmentLength());
        segment.rotate(360);
        System.out.println(segment);
        System.out.println(segment.segmentLength());
    }
}
