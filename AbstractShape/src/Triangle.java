public class Triangle extends AbstractShape{
    // first point of the triangle
    private Point myPoint1;
    // second point of the triangle
    private Point myPoint2;
    // third point of the triangle
    private Point myPoint3;
    public Triangle(){ // The constructor that has no parameter passed in
        this.myPoint1 = new Point(0, 0);
        this.myPoint2 = new Point(1, 1);
        this.myPoint3 = new Point(2, 2);
    }

    public Triangle(final Point x, final Point y, final Point z){ // The constructor that allows user to accept parameters
        this.myPoint1 = x;
        this.myPoint2 = y;
        this.myPoint3 = z;
    }


    public String toString() {
        String type = "{Type=" + this.getType() + ", ";
        String point1 = String.format("Point1=[Point X=%d, Y=%d], ", myPoint1.getX(), myPoint1.getY());
        String point2 = String.format("Point2=[Point X=%d, Y=%d], ", myPoint2.getX(), myPoint2.getY());
        String point3 = String.format("Point3=[Point X=%d, Y=%d]}", myPoint3.getX(), myPoint3.getY());

        return type + point1 + point2 + point3;
    }
    @Override
    public String getType() {
        return "Triangle";
    }

    @Override
    public double getPerimeter() { // Distance between two points (x1, y1) and (x2, y2) = √((x2 - x1)^2 + (y2 - y1)^2

        double mySide1 = Math.sqrt(Math.pow(myPoint2.getX() - myPoint1.getX(),2) + Math.pow(myPoint2.getY() - myPoint1.getY(),2));
        double mySide2 = Math.sqrt(Math.pow(myPoint3.getX() - myPoint2.getX(),2) + Math.pow(myPoint3.getY() - myPoint2.getY(),2));
        double mySide3 = Math.sqrt(Math.pow(myPoint3.getX() - myPoint1.getX(),2) + Math.pow(myPoint3.getY() - myPoint1.getY(),2));
        return mySide1 + mySide2 + mySide3;
    }

    @Override
    public double getArea() { // Calculate the area
        // Calculate the semi-perimeter (s): s = (a + b + c) / 2
        double s = this.getPerimeter() / 2;
        // Calculate the area using Heron's formula:
        // Area = √(s * (s - a) * (s - b) * (s - c))
        double mySide1 = Math.sqrt(Math.pow(myPoint2.getX() - myPoint1.getX(),2) + Math.pow(myPoint2.getY() - myPoint1.getY(),2));
        double mySide2 = Math.sqrt(Math.pow(myPoint3.getX() - myPoint2.getX(),2) + Math.pow(myPoint3.getY() - myPoint2.getY(),2));
        double mySide3 = Math.sqrt(Math.pow(myPoint3.getX() - myPoint1.getX(),2) + Math.pow(myPoint3.getY() - myPoint1.getY(),2));
        return Math.sqrt(s * (s - mySide1) * (s - mySide2) * (s - mySide3));
    }
}
