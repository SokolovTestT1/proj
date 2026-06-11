package Course.oop.inicialization.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    private List<Points> points;

    // Конструктор по умолчанию
    public BrokenLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор с начальным набором Точек
    public BrokenLine(Points... points) {
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
    }

    // Метод, возвращающий строковое представление ломаной линии
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i).toString());
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Метод, возвращающий массив Линий (отрезков между соседними точками)
    public Line[] toLines() {
        if (points.size() < 2) {
            return new Line[0];
        }

        Line[] lines = new Line[points.size() - 1];
        for (int i = 0; i < points.size() - 1; i++) {
            lines[i] = new Line(points.get(i), points.get(i + 1));
        }
        return lines;
    }

    // Метод, возвращающий общую длину ломаной линии
    public double getLength() {
        double totalLength = 0;
        Line[] lines = toLines();
        for (Line line : lines) {
            totalLength += line.getLength();
        }
        return totalLength;
    }

    // ✅ НОВЫЙ МЕТОД: возвращает общую длину всех линий в массиве (без повторного вычисления)
    // Можно использовать, когда уже есть массив линий — просто суммируем их
    public double getTotalLineLength() {
        double sum = 0;
        for (Line line : toLines()) {
            sum += line.getLength();
        }
        return sum;
    }

    // Дополнительные методы для удобства работы с ломаной
    public void addPoint(Points point) {
        points.add(point);
    }

    public int getPointsCount() {
        return points.size();
    }

    public Points getPoint(int index) {
        return points.get(index);
    }
}