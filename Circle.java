import java.util.ArrayList;
import java.util.Scanner;

public class Circle extends Shape
{
  double radius;

  public Circle(int x, int y, double radius) 
  {
    super(x, y);
    this.radius = radius;
  }

  public Circle(Point p, double radius) 
  {
    super(p);
    this.radius = radius;
  }

  public double calculateArea()
  {
    return Math.round((Math.PI * radius * radius) * 100.0) / 100.0;
  }

  public double calculatePerimeter()
  {
    return Math.round((2 * Math.PI * radius) * 100.0) / 100.0;
  }

  public void draw(Point start, Point end)
  {
    System.out.println("Drawing a Circle with center at " + origin + " with radius " + radius);
    Point p1 = this.origin.makePoint(this.radius, 0);
    Point p2 = this.origin.makePoint(0, this.radius);
    Point p3 = this.origin.makePoint(-this.radius, 0);
    Point p4 = this.origin.makePoint(0, -this.radius);
    ArrayList<Point> pointsToDraw = new ArrayList<>(); 
  }

  @Override
  public String toString()
  {
    return super.toString() + "Circle with center at " + origin + " with radius " + radius;
  }

  public void setRadius(double radius)
  {
    this.radius = radius;
  }

  public double getRadius()
  {
    return radius;
  }

  public void ShowOtherPoints()
  {
    Point p1 = this.origin.makePoint(this.radius, 0);
    Point p2 = this.origin.makePoint(0, this.radius);
    Point p3 = this.origin.makePoint(-this.radius, 0);
    Point p4 = this.origin.makePoint(0, -this.radius);
    System.out.println(p1.toString() + ", " + p2.toString() + ", " + p3.toString()  + ", " + p4.toString());
    System.out.println("Center: " + this.origin.toString());
    // this.origin.ShowPoint();
    // p1.ShowPoint();
    // p2.ShowPoint();
    // p3.ShowPoint();
    // p4.ShowPoint();
  }

  @Override
  public void editShape(Scanner scanner)
  {
    super.editShape(scanner);
    System.out.print("Enter the new radius for the Circle: ");
    radius = scanner.nextDouble();
    scanner.nextLine();
  }
}