import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape 
{
  protected int shapeId;

  protected Point origin;

  public abstract double calculateArea();

  public abstract double calculatePerimeter();

  public abstract void drawPoints(Point start, Point end);

  public void editShape(Scanner scanner)
  {
    System.out.print("Enter the new x-coordinate of the origin point for the shape: ");
    origin.setX(scanner.nextInt()); 
    scanner.nextLine();
    System.out.print("Enter the new y-coordinate of the origin point for the shape: ");
    origin.setY(scanner.nextInt());
    scanner.nextLine();
  }

  public String toString()
  {
    return "ShapeID : (" + shapeId + ") ";
  }

  public abstract void ShowOtherPoints();

  public Shape(int x, int y) 
  {
    shapeId = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
    origin = new Point(x, y);
  }

  public Shape(Point p)
  {
    shapeId = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
    origin = new Point(p);
  }

  public int getShapeID()
  {
    return shapeId;
  }

  public void setShapeID(int id)
  {
    this.shapeId = id;
  }

  public String padString(String s, int length)
  {
    String str = s;
    int lengthdif = length - s.length();
    if (lengthdif % 2 == 0) 
    {
      int topad = lengthdif / 2;
      char[] bufferstart = new char[topad];
      char[] bufferend = new char[topad];
      for(int i = 0; i < topad; i++)
      {
        bufferstart[i] = ' ';
        bufferend[i] = ' ';
      }
      str = new String(bufferstart) + str + new String(bufferend);
    }
    else
    {
      int topadf = lengthdif / 2;
      int topade = lengthdif - topadf;
      char[] bufferstart = new char[topadf];
      char[] bufferend = new char[topade];
      for(int i = 0; i < topadf; i++)
      {
        bufferstart[i] = ' ';
      }
      for(int i = 0; i < topade; i++)
      {
        bufferend[i] = ' ';
      }
      str = new String(bufferstart) + str + new String(bufferend);
    }
    return str;
  }

  public void drawAShapeOnGrid(Point start, Point end, ArrayList<Point> pointsToDraw)
  {
    System.out.print(padString("Y\\X" ,3));
    for (int viewx = (int)start.x; viewx <= (int)end.x; viewx ++)
    {
      System.out.print(padString(String.valueOf(viewx) ,3));
    }
    System.out.println("");
    for (int viewy = (int)end.y; viewy >= (int)start.y; viewy --)
    {
      System.out.print(padString(String.valueOf(viewy) ,3));
      for (int viewx = (int)start.x; viewx <= (int)end.x; viewx ++)
      {
        if(pointsToDraw.contains(new Point(viewx,viewy)))
        {
          // System.out.print( padString("[" + viewx + viewy + "]",3));
          System.out.print(padString("*" ,3));
        }
        else
        {
          System.out.print( padString(" ",3));
        }
      }
      System.out.println("");
    }
    System.out.print(padString("Y/X" ,3));
    for (int viewx = (int)start.x; viewx <= (int)end.x; viewx ++)
    {
      System.out.print(padString(String.valueOf(viewx) ,3));
    }
    System.out.println("");
  }
}