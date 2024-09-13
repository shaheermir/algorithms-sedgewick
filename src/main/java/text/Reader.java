package text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {

  static class Route {
    String src;
    String dest;

    Route(String src, String dest) {
      this.src = src;
      this.dest = dest;
    }

    @Override
    public String toString() {
      return "Route{" + "src='" + src + '\'' + ", dest='" + dest + '\'' + '}';
    }
  }

  public static void main(String[] args) {
    ArrayList<Route> routes = new ArrayList<>();

    try {
      File myObj = new File("algs4-data/routesWithSize.txt");
      Scanner myReader = new Scanner(myObj);

      int size = Integer.parseInt(myReader.nextLine());
      Route[] routesArray = new Route[size];
      int i = 0;
      while (myReader.hasNextLine()) {
        String row = myReader.nextLine();
        String[] routeInfo = row.split(" ");
        Route r = new Route(routeInfo[0], routeInfo[1]);
        routes.add(r);
        routesArray[i++] = r;
      }
      myReader.close();

      System.out.println(routes);
      System.out.println(Arrays.toString(routesArray));
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
