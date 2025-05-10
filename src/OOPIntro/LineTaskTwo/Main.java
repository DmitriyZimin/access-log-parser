package OOPIntro.LineTaskTwo;

public class Main {
    public static void main(String[] args) {
        PointCoordinate point1 = new PointCoordinate(1, 3);
        PointCoordinate point2 = new PointCoordinate(5, 8);
        PointCoordinate point3 = new PointCoordinate(10, 11);
        PointCoordinate point4 = new PointCoordinate(15, 19);

        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point3, point4);
        Line line3 = new Line(line1.end, line2.start);

        System.out.println("Линия от " + line3.start + " до " + line3.end);//Начальное значение линии
        point2.x = 6;
        point3.x = 11;
        line3.changePoint(line3.start, line3.end);
        System.out.println("Линия после изменений от " + line3.start + " до " + line3.end);//Значение линии после изменений
        System.out.printf("Суммарная длина всех линий: %.2f\n", line1.getLength() + line2.getLength() + line3.getLength());
    }
}
