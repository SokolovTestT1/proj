package Course.oop.inicialization.Task;

public class Points {
    private int x;
    private int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры для доступа к координатам
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // ✅ Сеттеры для изменения координат (ключевы!)
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Points{" +
                "X=" + x +
                ", Y=" + y +
                '}';
    }
}
