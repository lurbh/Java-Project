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
    double angle = 2 * Math.PI / numSides;
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

  public void draw(Point start, Point end)
  {
    System.out.println(this.toString());
    double angle = 2 * Math.PI / numSides;
    Point pn = this.origin.makePoint(this.sideLength, 0);
    ArrayList<Point> points = new ArrayList<>();
    points.add(this.origin);
    points.add(pn);
    // this.origin.ShowPoint();
    // pn.ShowPoint();
    for (int i = 0; i < numSides - 2 ; i++)
    {
      double x = this.sideLength * Math.cos(Math.toRadians(angle));
      double y = this.sideLength * Math.sin(Math.toRadians(angle));
      System.out.println("X: " + String.valueOf(x) + "Y: " +  String.valueOf(y));
      pn = pn.makePoint(x,y);
      points.add(pn);
      // pn.ShowPoint();
    }
    ArrayList<Point> pointsToDraw = new ArrayList<>(); 
    for (int i = 0; i < points.size() -1; i++) 
    {
      pointsToDraw.addAll(points.get(i).getPointsInBetween(points.get(i+1)));
    }
    pointsToDraw.addAll(points.get(points.size() -1).getPointsInBetween(points.get(0)));
    for (Point point : pointsToDraw) {
      point.ShowPoint();
    }
    System.out.println("");
    drawAShapeOnGrid(start, end, points);
  }

  @Override
  public String toString()
  {
    return super.toString() + "Regular Polygon with " + numSides + " sides at Center: " + origin + " with side length of " + sideLength + " and radius of " + radius;
  }

  public void setNumSides(int numSides)
  {
    this.numSides = numSides;
  }

  public void setSideLength(int sideLength)
  {
    this.sideLength = sideLength;
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
    double angle = (numSides -2 ) * Math.PI / numSides;
    String points = "";
    for (int i = 0; i < numSides; i++)
    {
      double x = this.origin.x + radius * Math.sin(i * angle);
      double y = this.origin.y + radius * Math.cos(i * angle);
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