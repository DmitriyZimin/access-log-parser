package OOPIntro.LineTaskTwo;

public class Line {
    PointCoordinate start;
    PointCoordinate end;

    public Line(PointCoordinate start, PointCoordinate end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int x2, int y1, int y2) {
        this.start = new PointCoordinate(x1, y1);
        this.end = new PointCoordinate(x2, y2);
    }

    public String toString() {
        return "{" + start + ";" + end + "}";
    }

    public double getLength() {
        int dx = end.x - start.x; //Вычисление разницы координат x
        int dy = end.y - start.y; //Вычисление разницы координат y
        return Math.sqrt(dx * dx + dy * dy); //Вычисление длины линии
    }

    //Изменение координат
    public void changePoint(PointCoordinate start, PointCoordinate end) {
        this.start = start;
        this.end = end;
    }
}
