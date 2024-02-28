// import java.util.ArrayList;
import java.util.Scanner;

public class Square extends Shape 
{
  private int length;

  public Square(int x, int y, int length) 
  {
    super(x, y);
    this.length = length;
  }

  public Square(Point p, int length) 
  {
    super(p);
    this.length = length;
  }

  public double calculateArea() 
  {
    return length * length;
  }

  public double calculatePerimeter() 
  {
    return 4 * length;
  }

  // public void draw(Point start, Point end) 
  // {
  //   System.out.println("Drawing a Square at " + origin + " with length " + length);
  //   Point p1 = this.origin.makePoint(this.length, 0);
  //   Point p2 = this.origin.makePoint(this.length, this.length);
  //   Point p3 = this.origin.makePoint(0, this.length);
  //   ArrayList<Point> pointsToDraw = new ArrayList<>(); 
  //   pointsToDraw.addAll(this.origin.getPointsInBetween(p1));
  //   pointsToDraw.addAll(p1.getPointsInBetween(p2));
  //   pointsToDraw.addAll(p2.getPointsInBetween(p3));
  //   pointsToDraw.addAll(p3.getPointsInBetween(this.origin));
  //   drawAShapeOnGrid(start, end, pointsToDraw);
  // }

  @Override
  public String toString()
  {
    return super.toString() + "Square at " + origin + " with length " + length;
  }

  public void setLength(int length) 
  {
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void ShowOtherPoints() 
  {
    Point p1 = this.origin.makePoint(this.length, 0);
    Point p2 = this.origin.makePoint(this.length, this.length);
    Point p3 = this.origin.makePoint(0, this.length);
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
    System.out.print("Enter the new length for the Square: ");
    length = scanner.nextInt();
    scanner.nextLine();
  }
}