package text;

import java.util.ArrayList;
import java.util.Scanner;

public class ReaderStdIn {
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

    Scanner scanner = new Scanner(System.in);
    int numberOfRoutes = Integer.parseInt(scanner.nextLine());
    System.out.println(numberOfRoutes);

    while (scanner.hasNextLine()) {
      String row = scanner.nextLine();
      String[] routeInfo = row.split(" ");
      Route r = new Route(routeInfo[0], routeInfo[1]);
      routes.add(r);
    }

    System.out.println(routes);
  }
}
