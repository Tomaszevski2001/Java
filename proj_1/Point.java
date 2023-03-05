package com.company;

public class Point
{     // prywatne wspołrzedne do tego idzie geter i seter
    private double x; //wspołrzędna x punktu
    private double y; //współdzedna y punktu

    /////////////////////////////// KONSTRUKTORY ///////////////////////////////

    public Point()    //konstruktor domyslny domyslnie przypisuje mu wspołedne takie jakie chce
    {
        this(1,1);
    }

    public Point(double x, double y) //zeby moc stworzyc obiekt po to zeby dac mu wspołrzedne
    {
        this.x = x;
        this.y = y;
    } //konstruktor ze wspołrzednymi

    /////////////////////////////// GLOWNE ///////////////////////////////

    public void translate(double vx, double vy)
    { // przesuniecie o wektor o wspolrzednych [vx, vy]
        this.x += vx;
        this.y += vy;
    }

    public void rotate(double radians)
    { // obrot punktu wokol srodka ukladu wspolrzednych
        double x = this.x;
        double y = this.y;
        this.x = x * Math.cos(radians) - y * Math.sin(radians);
        this.y = x * Math.sin(radians) + y * Math.cos(radians);
    }

    /////////////////////////////// GETTERY / SETTERY / toString() ///////////////////////////////
//
    @Override
    public String toString()
    {              // this x nasza wspolrzedna
        String displayX = Double.toString(this.x).split("\\.")[1].length() < 3 ?
                Double.toString(this.x)
                : Double.toString(Math.round((this.x * 1000.0)) / 1000.0);
        String displayY = Double.toString(this.y).split("\\.")[1].length() < 3 ? Double.toString(this.y)
                : Double.toString(Math.round((this.y * 1000.0)) / 1000.0);

        return "(" +displayX + " " + displayY + ")";
    }
    //getery i setery wygenerowane dla naszych wspołrzędnych punktów
    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    //ustawianie punkty mozemy wywolac puynkt.set point w main
    public void setPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setPoint(Point point)
    {
        x = point.x;
        y = point.y;
    }
}
