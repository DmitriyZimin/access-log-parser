package OOPIntro.CoordinatePointTaskOne;

public class Main {
    public static void main(String[] args) {
        PointCoordinate point1 = new PointCoordinate(1, 3);
        PointCoordinate point2 = new PointCoordinate(1, 3);
        PointCoordinate point3 = new PointCoordinate(5, 8);

        System.out.println("Точка координат");
        System.out.println("#1 " + point1.toString());
        System.out.println("#2 " + point2.toString());
        System.out.println("#3 " + point3.toString());
        System.out.println("Сравнение точек координат");
        System.out.println("#1 и №2: " + (point1 == point2));
        System.out.println("#2 и №3: " + (point2 == point3));
    }
}
