package OOPIntro.PolyLineTaskThree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PointCoordinate point1 = new PointCoordinate(1, 5);
        PointCoordinate point2 = new PointCoordinate(2, 8);
        PointCoordinate point3 = new PointCoordinate(5, 3);
        PointCoordinate point4 = new PointCoordinate(8, 9);

        PolyLine polyline = new PolyLine(List.of(point1, point2, point3, point4));
        List<Line> linesList = polyline.getLines();
        double polylineLength = polyline.getLength();
        double lineListLength = polyline.getLengthOfLineList(linesList);

        System.out.printf("Длина ломаной: %.2f\n", polylineLength);
        System.out.println("Массив линий: " + linesList);
        System.out.printf("Длина массива линий: %.2f\n", lineListLength);
        System.out.println("Сравнение длины ломаной и массива линий: " + (polylineLength == lineListLength));
        point2.x = 12;
        System.out.println("Новое значение точки #2 " + point2);
        System.out.printf("Новая длина ломаной: %.2f\n", polyline.getLength());
        System.out.println("Новый массив линий: " + linesList);
    }
}
