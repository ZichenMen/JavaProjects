public class Circle extends AbstractShape{
    // The center of the circle
    private Point myCenter;
    // The radius of the circle
    private int myRadius;

    public Circle(){  // The constructor that has no parameter passed in
        this.myCenter = new Point(0, 0);
        this.myRadius = 1;
    }

    public Circle(final Point center, final int radius){ // The constructor that allows user to accept parameters
        this.myCenter = center;
        this.myRadius = radius;
    }

    public String toString() {
        String type = "{Type=" + this.getType() + ", ";
        String center = String.format("Center=[Point X=%d, Y=%d], ", myCenter.getX(), myCenter.getY());
        String radius= String.format("Radius=" + myRadius + "}");

        return type + center + radius;
    }



    @Override
    public String getType() {// print the type name
        return "Circle";
    }

    @Override
    public double getPerimeter() {  // Calculate the perimeter
        return 2 * Math.PI * myRadius;
    }

    @Override
    public double getArea() { // Calculate the area
        return Math.PI * Math.pow(myRadius,2);
    }
}
