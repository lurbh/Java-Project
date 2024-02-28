import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
  private static ArrayList<Shape> ShapeList = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);
  // private static Point gridbtmleft = new Point(0,0);
  // private static Point gridtopright = new Point(10,10);

  public static void main(String[] args) 
  {
    // Point test = new Point(2,2);
    // ArrayList<Point> pointsToDraw = new ArrayList<>(); 
    // for(int x = 0; x <= 3; x++)
    //   for(int y = 0; y <= 3; y++)
    //     pointsToDraw.add(new Point(x,y));
    // System.out.print("Testing: ");
    // System.out.println(pointsToDraw.contains(test));
    // System.out.println(test.equals(gridtopright));
    ShapeList.add(new Circle(1,1,2));
    ShapeList.add(new Square(2,1,3));
    ShapeList.add(new Rectangle(3,5,2,3));
    ShapeList.add(new Triangle(5,2,2,3));
    ShapeList.add(new RegularPolygon(1,6,5,2));
    do 
    {
      int choice = displayMenu();
      switch (choice) 
      {
        case 1:
          addShape();
          break;
        case 2:
          listShapes();
          break;
        case 3:
          editShape();
          break;
        case 4:
          deleteShape();
          break;
        case 5:
          showAllShapesArea();
          break;
        case 6:
          showShapeArea();
          break;
        case 7:
          showAllShapesPerimeter();
          break;
        case 8:
          showShapePerimeter();
          break;
        case 9:
          showAllShapesPoints();
          break;
        case 10:
          showShapePoints();
          break;
        // case 11:
        //   drawShape();
        //   break;
      }
      if (choice == 11)
        break;
    } while (true);
    System.out.println("System Exit...");
  }

  private static int displayMenu() 
  {
    int choice = 0;

    while (true) 
    {
      System.out.println("Menu:");
      System.out.println("1. Add a Shape");
      System.out.println("2. List all Shapes");
      System.out.println("3. Edit a Shape");
      System.out.println("4. Delete a Shape");
      System.out.println("5. Show all Shapes Area");
      System.out.println("6. Show a Shape area");
      System.out.println("7. Show all Shapes Perimeter");
      System.out.println("8. Show a Shape Perimeter");
      System.out.println("9. Show all Shape Points");
      System.out.println("10. Show a Shape Points");
      // System.out.println("11. Draw a Shape");
      System.out.println("11. Exit");

      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine(); //consume the newline character in the buffer
      if (choice >= 1 && choice <= 11) 
        break;  
      else
        System.out.println("Enter a valid choice.");
    }
    return choice;
  }

  private static void addShape()
  {
    System.out.print("Enter the x-coordinate of the origin point for the shape: ");
    int x = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the y-coordinate of the origin point for the shape: ");
    int y = scanner.nextInt();
    scanner.nextLine();
    Point newpoint = new Point(x,y);
    while (true) 
    {
      System.out.println("Choose the type of shape");
      System.out.println("1. Circle");
      System.out.println("2. Triangle");
      System.out.println("3. Square");
      System.out.println("4. Rectangle");
      System.out.println("5. Regular Polygon");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch(choice)
      {
        case 1:
          CreateCircle(newpoint);
          break;
        case 2:
          CreateTriangle(newpoint);
          break;
        case 3:
          CreateSquare(newpoint);
          break;
        case 4:
          CreateRectangle(newpoint);
          break;
        case 5:
          CreateRegularPolygon(newpoint);
          break;
        default:
          System.out.println("Enter a valid choice.");
          break;
      }
      System.out.println(choice);
      if (choice >= 1 && choice <=5) 
        break;
    }
  }

  private static void CreateCircle(Point p)
  {
    System.out.print("Enter the radius for the Circle: ");
    double r = scanner.nextDouble();
    scanner.nextLine();
    Circle c = new Circle(p,r);
    ShapeList.add(c);
  }

  private static void CreateTriangle(Point p)
  {
    System.out.print("Enter the length for the base of triangle: ");
    int s1 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the length for the height of triangle: ");
    int s2 = scanner.nextInt();
    scanner.nextLine();
    Triangle t = new Triangle(p,s1,s2);
    ShapeList.add(t);
  }

  private static void CreateSquare(Point p)
  {
    System.out.print("Enter the length for the Square: ");
    int l = scanner.nextInt();
    scanner.nextLine();
    Square s = new Square(p,l);
    ShapeList.add(s);
  }

  private static void CreateRectangle(Point p)
  {
    System.out.print("Enter the width for the Rectangle: ");
    int w = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the height for the Rectangle: ");
    int h = scanner.nextInt();
    scanner.nextLine();
    Rectangle rec = new Rectangle(p,w,h);
    ShapeList.add(rec);
  }

  private static void CreateRegularPolygon(Point p)
  {
    System.out.print("Enter the number of sides for the Regular Polygon: ");
    int n = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the length of sides for the Regular Polygon: ");
    int l = scanner.nextInt();
    scanner.nextLine();
    RegularPolygon rp = new RegularPolygon(p,n,l);
    ShapeList.add(rp);
  }

  private static void listShapes()
  {
    for(Shape s : ShapeList)
    {
      System.out.println(s.toString());
    }
  }

  private static void editShape()
  {
    System.out.print("Enter the id of the Shape to edit: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for(Shape s : ShapeList)
    {
      if(s.shapeId == id)
      {
        s.editShape(scanner);
        return;
      }
    }
    System.out.println("No Shape with that id found.");
  }

  private static void deleteShape()
  {
    System.out.print("Enter the id of the Shape to delete: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    Shape delShape = null;
    for(Shape s : ShapeList)
    {
      if(s.getShapeID() == id)
      {
        delShape = s;
        break;
      }
    }
    if(delShape != null)
    {
      ShapeList.remove(delShape);
    }
    else
      System.out.println("No Shape with that id found.");
  }

  private static void showAllShapesArea()
  {
    for(Shape s : ShapeList)
    {
      System.out.println(s.toString() + " Area: " + s.calculateArea());
    }
    
  }

  private static void showShapeArea()
  {
    System.out.print("Enter the id of the Shape to show it's Area: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for(Shape s : ShapeList)
    {
      if(s.shapeId == id)
      {
        System.out.println(s.toString() + " Area: " + s.calculateArea());
        return;
      }
    }
    System.out.println("No Shape with that id found.");
  }

  private static void showAllShapesPerimeter()
  {
    for(Shape s : ShapeList)
    {
      System.out.println(s.toString() + " Perimeter: " + s.calculatePerimeter());
    }
  }

  private static void showShapePerimeter()
  {
    System.out.print("Enter the id of the Shape to show it's Perimeter: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for(Shape s : ShapeList)
    {
      if(s.shapeId == id)
      {
        System.out.println(s.toString() + " Perimeter: " + s.calculatePerimeter());
        return;
      }
    }
    System.out.println("No Shape with that id found.");
  }

  private static void showAllShapesPoints()
  {
    for(Shape s : ShapeList)
    {
      System.out.println(s.toString());
      System.out.print("Points: ");
      s.ShowOtherPoints();
    }
  }

  private static void showShapePoints()
  {
    System.out.print("Enter the id of the Shape to show it's Points: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    for(Shape s : ShapeList)
    {
      if(s.shapeId == id)
      {
        System.out.println(s.toString());
        System.out.print("Points: ");
        s.ShowOtherPoints();
        return;
      }
    }
    System.out.println("No Shape with that id found.");
  }

  // private static void drawShape()
  // {
  //   System.out.print("Enter the id of the Shape to show draw: ");
  //   int id = scanner.nextInt();
  //   scanner.nextLine();
  //   for(Shape s : ShapeList)
  //   {
  //     if(s.shapeId == id)
  //     {
  //       s.draw(gridbtmleft,gridtopright);
  //       return;
  //     }
  //   }
  //   System.out.println("No Shape with that id found.");
  // }
}
