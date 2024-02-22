public class Rectangle {
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public String getRectangleInfo() {
        return String.format(
                "Width: %s, Height: %s, Area: %s, Perimeter: %s",
                 width, height, calculateArea(), calculatePerimeter());
    }

}
