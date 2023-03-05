package com.company;

public class Segment {
    private Point point1; // pierwszy punkt bo odcinek ma 2 punktyy
    private Point point2; //drugi punkt bo odcinek ma 2 punktyy



    /////////////////////////////// KONSTRUKTORY ///////////////////////////////

    public Segment ()  //domyslny konstruktor  randomowe
    {
        this(new Point( 0,0 ), new Point( 0,0 ) );
    }

    public Segment(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;

    }

    public Segment(double x1, double y1, double x2, double y2) { //przyjmuje wspolrzedne
        this.( new Point(x1, y1), new Point(x2, y2) );
    }

    /////////////////////////////// GLOWNE ///////////////////////////////
//przesuwa sie tylko konce o wektor
    public void translate(double vx, double vy) { // przesuniecie o wektor o wspolrzednych [vx, vy]
        point1.translate(vx, vy);       // wywoluje to w odcinku w punkcie 20 linijka przesunela 2 punkty
        point2.translate(vx, vy);
    }

    public void rotate(double degrees) { // obrot odcinka wokol jego srodka o zadana liczbe stopni
        Point middlePoint = getMiddlePoint(); //get middle zwraca srodek
        double radians = this.degreesToRadians(degrees); //zmiana stopni na radiany
        translate(-middlePoint.getX(), -middlePoint.getY()); //obwrot odcinka czyli pierwsze o jakis kont o srodek ukłądu
        point1.rotate(radians);// punkt 1 obracam
        point2.rotate(radians); // punkt 2 obracam
        translate(middlePoint.getX(), middlePoint.getY()); // powrot do miejsca
    }

    public double segmentLength() { // zwraca dlugosc odcinkaZ
        double powerX = Math.pow((point2.getX() - point1.getX()), 2);
        double powerY = Math.pow((point2.getY() - point1.getY()), 2);

        return Math.round(Math.sqrt(powerX + powerY) * 1000.0) / 1000.0;
    }

    /////////////////////////////// POMOCNICZE ///////////////////////////////

    private double degreesToRadians(double degrees) { // zamiana stopni na radiany
        return degrees * Math.PI / 180;
    } //jesli wpisze sie stopnie zwroci radiany

    private double arithmeticMean(double a, double b)
    { // srednia arytmetyczna
        return (a + b) / 2;
    }

    private Point getMiddlePoint()
    { // zwraca punkt bedacy srodkiem odcinka srodek arytmetyczny punktu
        double x = arithmeticMean(point1.getX(), point2.getX());
        double y = arithmeticMean(point1.getY(), point2.getY());

        return new Point(x, y);
    }

    /////////////////////////////// GETTERY / SETTERY / toString() ///////////////////////////////

    //nadpisuje metode tostring
    @Override
    public String toString()
    {
        return "Odcinek o końcach " + point1 + " " + "oraz " + point2;
    }

    public Point getPoint1()
    {
        return point1;
    }

    public void setPoint1(Point point1)
    {
        this.point1 = point1;
    }

    public Point getPoint2()
    {
        return point2;
    }

    public void setPoint2(Point point2)
    {
        this.point2 = point2;
    }

    public void setSegment(double x1, double y1, double x2, double y2)
    { // ustawia nam punkty w odcinku
        point1.setPoint(x1, y1);
        point2.setPoint(x2, y2);
    }

    public void setSegment(Point point1, Point point2)
    {
        this.point1.setPoint(point1);
        this.point2.setPoint(point2);
    }
}


