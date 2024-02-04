public abstract class AbstractShape implements Shape{

    // Compare two Shape objects
    public int compareTo(Shape other){
        // Compare the area
        if(this.getArea() > other.getArea()){
            return 1;
        }else if(this.getArea() < other.getArea()){
            return -1;
        }
        // Compare the perimeter
        if(this.getPerimeter() > other.getPerimeter()){
            return 1;
        }else if(this.getPerimeter() < other.getPerimeter()){
            return -1;
        }
        // Compare the name
        return this.getType().compareTo(other.getType());
    }
}
