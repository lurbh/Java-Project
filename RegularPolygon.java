import java.util.ArrayList;
import java.util.Scanner;

public class RegularPolygon extends Shape
{
  private int numSides;
  private int sideLength;
  private double radius;

  RegularPolygon(int x, int y, int numSides, int sideLength)
  {
    super(x,y);
    this.numSides = numSides;
    this.sideLength = sideLength;
    // double angle = 2 * Math.PI / numSides;
    radius = 0.5 * sideLength * (1/Math.cos(Math.PI/numSides)); //(1/2) a csc(π/n)
    radius = Math.round(radius * 100.0) / 100.0;
  }

  RegularPolygon(Point p, int numSides, int sideLength)
  {
    super(p);
    this.numSides = numSides;
    this.sideLength = sideLength;
    radius =  (sideLength) / (2 * Math.cos(Math.PI / numSides));
    radius = Math.round(radius * 100.0) / 100.0;
  }

  public double calculateArea()
  {
    double area = (numSides * sideLength * sideLength) / (4 * Math.tan(Math.PI / numSides));
    return Math.round(area * 100.0) / 100.0;
  }

  public double calculatePerimeter()
  {
    return numSides * sideLength;
  }

  public void drawPoints(Point start, Point end)
  {
    System.out.println("Drawing Regular Polygon Points with bottom left point at " + origin + " with " + numSides + " sides of " + sideLength 
      + " length and a radius of " + radius);
    ArrayList<Point> pointsToDraw = new ArrayList<>();
    for (int i = 0; i < numSides; i++)
    {
      double x = this.origin.x + radius * Math.cos(2 * Math.PI * i / numSides);
      double y = this.origin.y + radius * Math.sin(2 * Math.PI * i / numSides);
      // System.out.println("x: " + x + ", y: " + y);
      Point p = new Point((int)x, (int)y);
      pointsToDraw.add(p);
    }
    drawAShapeOnGrid(start, end, pointsToDraw);
  }

  @Override
  public String toString()
  {
    return super.toString() + "Regular Polygon with " + numSides + " sides at Center: " + origin + " with side length of " + sideLength + " and radius of " + radius;
  }

  public void setNumSides(int numSides)
  {
    if(numSides > 0)
      this.numSides = numSides;
    else
      throw new IllegalArgumentException("Invalid number of sides . Please provide a non-negative value.");
  }

  public void setSideLength(int sideLength)
  {
    if(sideLength > 0)
      this.sideLength = sideLength;
    else
      throw new IllegalArgumentException("Invalid side length. Please provide a non-negative value.");
  }

  public int getNumSides()
  {
    return numSides;
  }

  public double getSideLength()
  {
    return sideLength;
  }

  public void ShowOtherPoints()
  {
    String points = "";
    for (int i = 0; i < numSides; i++)
    {
      double x = this.origin.x + radius * Math.cos(2 * Math.PI * i / numSides);
      double y = this.origin.y + radius * Math.sin(2 * Math.PI * i / numSides);
      // System.out.println("x: " + x + ", y: " + y);
      Point p = new Point(x, y);
      points += p.toString() + ", ";
    }
    points = points.substring(0, points.length()-2);
    System.out.println(points);
  }

  @Override
  public void editShape(Scanner scanner)
  {
    super.editShape(scanner);
    System.out.print("Enter the new number of sides for the Regular Polygon: ");
    numSides = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the new length of sides for the Regular Polygon: ");
    sideLength = scanner.nextInt();
    scanner.nextLine();
  }
}