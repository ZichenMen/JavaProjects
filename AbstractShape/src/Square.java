public class Square extends Rectangle{

    public Square() { // The constructor that has no parameter passed in
        super(new Point(0, 0), new Point(1, 1));
    }

    public Square(final Point topLeft, final int length){ // The constructor that allows user to accept parameters
        super(topLeft, new Point(topLeft.getX() + length, topLeft.getY()- length));
    }

    public String getType() {
        return "Square";
    }
}
