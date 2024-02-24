import java.util.ArrayList;

public class Point {
  protected double x;
  protected double y;

  Point() {
    x = 0;
    y = 0;
  }

  Point(int x, int y) 
  {
    this.x = x;
    this.y = y;
  }

  Point(double x, double y) 
  {
    // System.out.println("x: " + x + ", y: " + y);
    this.x = Math.round(x * 100.0) / 100.0;;
    this.y = Math.round(y * 100.0) / 100.0;;
  }

  Point(Point p)
  {
    this.x = p.x;
    this.y = p.y;
  }

  public double getX() 
  {
    return x;
  }

  public double getY() 
  {
    return y;
  }

  public void setX(double x) 
  {
    this.x = x;
  }

  public void setY(double y) 
  {
    this.y = y;
  }

  public void move(int x, int y) 
  {
    this.x += x;
    this.y += y;
  }

  public void move(Point p) 
  {
    this.x += p.x;
    this.y += p.y;
  }

  public Point makePoint(int x, int y) 
  {
    Point p = new Point(this.x, this.y);
    p.x += x;
    p.y += y;
    return p;
  }

  public Point makePoint(double x, double y) 
  {
    Point p = new Point(this.x, this.y);
    p.x += Math.round(x);
    p.y += Math.round(y);
    return p;
  }

  public void ShowPoint() 
  {
    System.out.print("[" + x + ", " + y + "]");
  }

  public String toString() 
  {
    return "[" + x + ", " + y + "]";
  }

  @Override
  public boolean equals(Object o) 
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Point p = (Point) o;
    if (this.x == p.x)
      if(this.y == p.y)
        return true;
    return false;
  }

  public ArrayList<Point> getPointsInBetween(Point p2)
  {
    ArrayList<Point> result = new ArrayList<>();
    if (this.x == p2.x)
    {
      if (this.y < p2.y)
        for (double k = this.y; k <= p2.y; k++)
        {
          Point p = new Point(this.x, k);
          result.add(p);
        }
      else
        for (double k = y; k >= p2.y; k--)
        {
          Point p = new Point(this.x, k);
          result.add(p);
        }
    }
    else if (this.y == p2.y)
    {
      if(this. x < p2.x)
        for (double k = this.x; k <= p2.x; k++)
        {
          Point p = new Point(k, this.y);
          result.add(p);
        }
      else
        for (double k = this.x; k >= p2.x; k--)
        {
          Point p = new Point(k, this.y);
          result.add(p);
        }
    }
    else
    {
      Point p1 = this;
      if (p2.x < p1.x)
      {
        Point temp = p1;
        p1 = p2;
        p2 = temp;
      }
      double deltaX = p2.x - p1.x;
      double deltaY = p2.y - p1.y;
      double error = -1.0f;
      double deltaErr = Math.abs(deltaY / deltaX);
      System.out.println(String.valueOf(deltaX) + " " + String.valueOf(deltaY) + " " + String.valueOf(error) + " " + String.valueOf(deltaErr));

      double y = p1.y;
      for (double x = p1.x; x <= p2.x; x++)
      {
          Point p = new Point(x, y);
          result.add(p);
          System.out.println("Added Point: " + p.toString());

          error += deltaErr;
          System.out.println("Error is now: " + error);

          while (error >= 0.0f)
          {
            System.out.println("   Moving Y to " + y);
            double res = (deltaY <= 0.0 && y >= p2.y)  ? y--: y++;
              result.add(new Point(x, y));
              error -= 1.0f;
          }
      }
    }
    return result;
  }
}