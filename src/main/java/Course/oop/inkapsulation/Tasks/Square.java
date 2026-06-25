package Course.oop.inkapsulation.Tasks;

import Course.oop.Task.Points;

/**
 * Класс Square описывает квадрат на плоскости.
 * <p>
 * Квадрат определяется координатами левого верхнего угла (точка типа {@link Points})
 * и длиной стороны (положительное целое число).
 *
 */
public class Square {
    /**
     * Координата левого верхнего угла квадрата.
     */
    private Points topLeft;

    /**
     * Длина стороны квадрата (должна быть > 0).
     */
    private int sideLength;

    /**
     * Создаёт квадрат по координатам левого верхнего угла и длине стороны.
     *
     * @param x          координата X левого верхнего угла
     * @param y          координата Y левого верхнего угла
     * @param sideLength длина стороны квадрата (должна быть положительной)
     * @throws IllegalArgumentException если {@code sideLength <= 0}
     */
    public Square(int x, int y, int sideLength) {
        this(new Points(x, y), sideLength);
    }

    /**
     * Создаёт квадрат по точке левого верхнего угла и длине стороны.
     *
     * @param topLeft    точка левого верхнего угла (копируется, чтобы избежать внешнего изменения)
     * @param sideLength длина стороны квадрата (должна быть положительной)
     * @throws IllegalArgumentException если {@code sideLength <= 0} или {@code topLeft == null}
     */
    public Square(Points topLeft, int sideLength) {
        if (topLeft == null) {
            throw new IllegalArgumentException("Координаты верхнего левого угла не могут быть null.");
        }
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
        // Сохраняем копию, чтобы избежать изменения внешнего объекта Points
        this.topLeft = new Points(topLeft.getX(), topLeft.getY());
        this.sideLength = sideLength;
    }

    /**
     * Возвращает координаты левого верхнего угла.
     *
     * @return копия координат (чтобы сохранить инкапсуляцию)
     */
    public Points getTopLeft() {
        return new Points(topLeft.getX(), topLeft.getY());
    }

    /**
     * Устанавливает новые координаты левого верхнего угла.
     *
     * @param x новая координата X
     * @param y новая координата Y
     */
    public void setTopLeft(int x, int y) {
        this.topLeft.setX(x);
        this.topLeft.setY(y);
    }

    /**
     * Устанавливает координаты левого верхнего угла по объекту {@link Points}.
     *
     * @param topLeft новая точка левого верхнего угла (копируется)
     */
    public void setTopLeft(Points topLeft) {
        if (topLeft == null) {
            throw new IllegalArgumentException("Координаты верхнего левого угла не могут быть null.");
        }
        this.topLeft.setX(topLeft.getX());
        this.topLeft.setY(topLeft.getY());
    }

    /**
     * Возвращает длину стороны квадрата.
     *
     * @return длина стороны (положительное целое число)
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Устанавливает длину стороны квадрата.
     *
     * @param sideLength новая длина стороны (должна быть > 0)
     * @throws IllegalArgumentException если {@code sideLength <= 0}
     */
    public void setSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
        this.sideLength = sideLength;
    }

    /**
     * Приводит квадрат к строковому представлению в формате:
     * «Квадрат в точке T со стороной N», где:
     * - T — результат вызова {@link Points#toString()} для левого верхнего угла,
     * - N — длина стороны.
     *
     * @return строковое представление квадрата
     */
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}