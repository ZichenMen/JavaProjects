

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class ShapeMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        List<Shape> shapes = new ArrayList<Shape>();

        Scanner console = new Scanner(new File("shapes.txt"));
        while (console.hasNext())
        {
            String shapeType = console.next();
            if (shapeType.equals(TRIANGLE))
            {
                Point point1 = new Point();
                point1.setX(Integer.parseInt(console.next()));
                point1.setY(Integer.parseInt(console.next()));

                Point point2 = new Point();
                point2.setX(Integer.parseInt(console.next()));
                point2.setY(Integer.parseInt(console.next()));

                Point point3 = new Point();
                point3.setX(Integer.parseInt(console.next()));
                point3.setY(Integer.parseInt(console.next()));

                shapes.add(new Triangle(point1, point2, point3));
            }
            else if (shapeType.equals(RECTANGLE))
            {
                Point topLeft = new Point();
                topLeft.setX(Integer.parseInt(console.next()));
                topLeft.setY(Integer.parseInt(console.next()));

                Point bottomRight = new Point();
                bottomRight.setX(Integer.parseInt(console.next()));
                bottomRight.setY(Integer.parseInt(console.next()));

                shapes.add(new Rectangle(topLeft, bottomRight));
            }
            else if (shapeType.equals(SQUARE))
            {
                Point topLeft = new Point();
                topLeft.setX(Integer.parseInt(console.next()));
                topLeft.setY(Integer.parseInt(console.next()));

                int length = Integer.parseInt(console.next());

                shapes.add(new Square(topLeft, length));
            }
            else if (shapeType.equals(CIRCLE))
            {
                Point center = new Point();
                center.setX(Integer.parseInt(console.next()));
                center.setY(Integer.parseInt(console.next()));

                int radius = Integer.parseInt(console.next());

                shapes.add(new Circle(center, radius));
            }
            else
            {
                System.err.println("There is something wrong with the inputs");
                console.close();
                System.exit(1);
            }
        }

        console.close();
        Collections.sort(shapes);

        System.out.println("Print shapes in ascending order:");
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext())
        {
            Shape shape = iterator.next();
            System.out.println(String.format("%s => Perimeter=%.3f and Area=%.3f", shape, shape.getPerimeter(), shape.getArea()));
        }
    }

    public static final String TRIANGLE = "t";
    public static final String RECTANGLE = "r";
    public static final String SQUARE = "s";
    public static final String CIRCLE = "c";
}


