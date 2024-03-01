import java.util.ArrayList;
import java.util.Scanner;

public class Triangle extends Shape 
{
  private int base;
  private int height;
  private double hypotenuse;

  public Triangle(int x, int y, int base, int height) 
  {
    super(x, y);
    this.base = base;
    this.height = height;
    this.hypotenuse = Math.sqrt(height*height + base*base);
    this.hypotenuse = Math.round(hypotenuse * 100.0) / 100.0;
  }

  public Triangle(Point p, int base, int height) 
  {
    super(p);
    this.base = base;
    this.height = height;
    this.hypotenuse = Math.sqrt(height*height + base*base);
    this.hypotenuse = Math.round(hypotenuse * 100.0) / 100.0;
  }

  public double calculateArea() 
  {
    double s = (base + height + hypotenuse) / 2.0;
    double area =  Math.sqrt(s * (s - base) * (s - height) * (s - hypotenuse));
    return Math.round(area * 100.0) / 100.0;
  }

  public double calculatePerimeter() 
  {
    return base + height + hypotenuse;
  }

  public void drawPoints(Point start, Point end) 
  {
    System.out.println("Drawing Triangle Points with bottom left point at " + origin + " with sides " + base + ", " + height
        + ", " + hypotenuse);
    Point p1 = this.origin.makePoint(this.base, 0);
    Point p2 = this.origin.makePoint(0, this.height);
    ArrayList<Point> pointsToDraw = new ArrayList<>(); 
    pointsToDraw.add(this.origin);
    pointsToDraw.add(p1);
    pointsToDraw.add(p2);
    drawAShapeOnGrid(start, end, pointsToDraw);
  }

  @Override
  public String toString()
  {
    return super.toString() + "Triangle with bottom left point at " + origin + " with sides " + base + ", " + height + ", " + hypotenuse;
  }

  public void setbase(int base) 
  {
    if(base > 0)
    {
      this.base = base;
      double hypotenuse = Math.sqrt(this.height * this.height + this.base * this.base);
      sethypotenuse(Math.round(hypotenuse * 100.0) / 100.0);
    }
    else
      throw new IllegalArgumentException("Invalid base length. Please provide a non-negative value.");
  }

  public void setheight(int height) 
  {
    if(height > 0)
    {
      this.height = height;
      double hypotenuse = Math.sqrt(this.height * this.height + this.base * this.base);
      sethypotenuse(Math.round(hypotenuse * 100.0) / 100.0);
    }
    else
      throw new IllegalArgumentException("Invalid height length. Please provide a non-negative value.");
  }

  public void sethypotenuse(double hypotenuse) 
  {
    this.hypotenuse = hypotenuse;
  }

  public void SetSides(int base, int height) 
  {
    if(height > 0 && base > 0)
    {
      this.base = base;
      this.height = height;
      double hypotenuse = Math.sqrt(this.height * this.height + this.base * this.base);
      sethypotenuse(Math.round(hypotenuse * 100.0) / 100.0);
    }
    else
      throw new IllegalArgumentException("Invalid sides length. Please provide a non-negative value.");
  }

  public int getbase() 
  {
    return base;
  }

  public int getheight() 
  {
    return height;
  }

  public double gethypotenuse() 
  {
    return hypotenuse;
  }

  public void ShowOtherPoints() 
  {
    Point p1 = this.origin.makePoint(this.base, 0);
    Point p2 = this.origin.makePoint(0, this.height);
    System.out.println(this.origin.toString() + ", " + p1.toString() + ", " + p2.toString());
    // this.origin.ShowPoint();
    // p1.ShowPoint();
    // p2.ShowPoint();
  }

  @Override
  public void editShape(Scanner scanner)
  {
    super.editShape(scanner);
    System.out.print("Enter the new length for the base of triangle: ");
    base = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the new length for the height of triangle: ");
    height = scanner.nextInt();
    scanner.nextLine();
    this.hypotenuse = Math.sqrt(height*height + base*base);
  }
}