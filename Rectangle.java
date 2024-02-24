import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Rectangle extends Shape 
{
  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height) 
  {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  public Rectangle(Point p, int width, int height) 
  {
    super(p);
    this.width = width;
    this.height = height;
  }

  public double calculateArea() 
  {
    return width * height;
  }

  public double calculatePerimeter() 
  {
    return 2 * (width + height);
  }

  public void draw(Point start, Point end)
  {
    System.out.println("Drawing a rectangle at " + origin + " with width " + width + " and height " + height);
    Point p1 = this.origin.makePoint(this.width, 0);
    Point p3 = this.origin.makePoint(0, this.height);
    Point p2 = this.origin.makePoint(this.width, this.height);
    ArrayList<Point> pointsToDraw = new ArrayList<>(); 
    pointsToDraw.addAll(this.origin.getPointsInBetween(p1));
    pointsToDraw.addAll(p1.getPointsInBetween(p2));
    pointsToDraw.addAll(p2.getPointsInBetween(p3));
    pointsToDraw.addAll(p3.getPointsInBetween(this.origin));
    // for (Point point : pointsToDraw) {
    //   point.ShowPoint();
    // }
    // System.out.println("");
    drawAShapeOnGrid(start, end, pointsToDraw);
  }

  @Override
  public String toString()
  {
    return super.toString() + "Rectangle at " + origin + " with width " + width + " and height " + height;
  }

  public void setWidth(int width) 
  {
    this.width = width;
  }

  public void setHeight(int height) 
  {
    this.height = height;
  }

  public void SetDimensions(int width, int height)
  {
    this.width = width;
    this.height = height;
  }

  public int getWidth() 
  {
    return width;
  }

  public int getHeight() 
  {
    return height;
  }

  public void ShowOtherPoints() 
  {
    Point p1 = this.origin.makePoint(this.width, 0);
    Point p3 = this.origin.makePoint(0, this.height);
    Point p2 = this.origin.makePoint(this.width, this.height);
    System.out.println(this.origin.toString() + ", " + p1.toString() + ", " + p2.toString()  + ", " + p3.toString());
    // this.origin.ShowPoint();
    // p1.ShowPoint();
    // p2.ShowPoint();
    // p3.ShowPoint();
  }

  @Override
  public void editShape(Scanner scanner)
  {
    super.editShape(scanner);
    System.out.print("Enter the new width for the Rectangle: ");
    width = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the new height for the Rectangle: ");
    height = scanner.nextInt();
    scanner.nextLine();
  }
}