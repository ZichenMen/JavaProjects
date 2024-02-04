public class Rectangle extends AbstractShape{
    // The top left point of the rectangle
    private Point myTopLeft;
    // The bottom right point of the rectangle
    private Point myBottomRight;



    public Rectangle(){ // The constructor that has no parameter passed in
        this.myTopLeft = new Point(0 ,0);
        this.myBottomRight = new Point(1, 1);
    }
    public Rectangle(final Point p1, final Point p2){ // The constructor that allows user to accept parameters
        this.myTopLeft = p1;
        this.myBottomRight = p2;
    }

    public String toString() {

        String type = "{Type=" + this.getType() + ", ";
        String point1 = String.format("TopLeft=[Point X=%d, Y=%d], ", myTopLeft.getX(), myTopLeft.getY());
        String point2 = String.format("BottomRight=[Point X=%d, Y=%d]}", myBottomRight.getX(), myBottomRight.getY());

        return type + point1 + point2;
    }


    @Override
    public String getType() { // print the type name
        return "Rectangle";
    }

    @Override
    public double getPerimeter() { // Calculate the perimeter
        double mySide1 = Math.abs(myBottomRight.getX() - myTopLeft.getX());
        double mySide2 = Math.abs(myTopLeft.getY() - myBottomRight.getY());
        return 2 * (mySide1 + mySide2);
    }

    @Override
    public double getArea() { // Calculate the area
        double mySide1 = Math.abs(myBottomRight.getX() - myTopLeft.getX());
        double mySide2 = Math.abs(myTopLeft.getY() - myBottomRight.getY());
        return mySide1 * mySide2;
    }
}
