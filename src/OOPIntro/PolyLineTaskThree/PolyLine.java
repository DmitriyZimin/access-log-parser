package OOPIntro.PolyLineTaskThree;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    List<PointCoordinate> pointsList;

    public PolyLine() {
        this.pointsList = new ArrayList<>();
    }

    public PolyLine(List<PointCoordinate> startPoints) {
        this.pointsList = new ArrayList<>(startPoints);
    }

    public String toString() {
        return "Линия " + pointsList.toString();
    }

    public List<Line> getLines() {
        List<Line> linesList = new ArrayList<>();

        for (int i = 0; i < pointsList.size() - 1; i++) {
            linesList.add(new Line(pointsList.get(i), pointsList.get(i + 1)));
        }
        return linesList;
    }

    public double getLength() {
        double polyLineLength = 0.0;
        for (int i = 0; i < pointsList.size() - 1; i++) {
            polyLineLength += new Line(pointsList.get(i), pointsList.get(i + 1)).getLength();
        }
        return polyLineLength;
    }

    public double getLengthOfLineList(List<Line> lines) {
        double lineListLength = 0.0;
        for (Line line : lines) {
            lineListLength += line.getLength();
        }
        return lineListLength;
    }
}