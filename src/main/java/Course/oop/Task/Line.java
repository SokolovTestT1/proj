package Course.oop.Task;

public class Line {
    private Points start;
    private Points end;

    // Конструктор с двумя Точками
    public Line(Points start, Points end) {
        this.start = start;
        this.end = end;
    }

    // Конструктор с четырьмя целыми числами (координаты начала и конца)
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Points(x1, y1);
        this.end = new Points(x2, y2);
    }

    // Геттеры для получения начала и конца линии
    public Points getStart() {
        return start;
    }

    public Points getEnd() {
        return end;
    }

    // Метод, возвращающий текстовое представление линии
    @Override
    public String toString() {
        return "Линия от {" + start.getX() + ";" + start.getY() + "} до {" + end.getX() + ";" + end.getY() + "}";
    }

    // Метод, возвращающий длину линии
    public double getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}