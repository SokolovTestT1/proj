package Course.oop.inicialization.Task;

public class Main {
    public static void main(String[] args) {
        // 🔑 ВАЖНО: создаём точки ОДИН РАЗ, чтобы линии делили их
        Points p1 = new Points(1, 3);     // начало линии 1
        Points p2 = new Points(5, 8);     // конец линии 1 и начало линии 3
        Points p3 = new Points(10, 11);   // конец линии 3 и начало линии 2
        Points p4 = new Points(15, 19);   // конец линии 2

        Points p5 = new Points(1, 5);
        Points p6 = new Points(2, 8);
        Points p7 = new Points(5, 3);
        Points p8 = new Points(8, 9);
        //System.out.println(o1 == o2); // false
        //System.out.println(o2 == o3); // false
        //System.out.println(o1 == o3); // False

        // ✅ Создаём линии, используя общие точки
        Line line1 = new Line(p1, p2);  // от {1;3} до {5;8}
        Line line2 = new Line(p3, p4);  // от {10;11} до {15;19}
        Line line3 = new Line(p2, p3);  // от {5;8} до {10;11}

        // 1️⃣ Выводим текстовое представление Линии 3
        System.out.println("Линия 3 до изменения:");
        System.out.println(line3);

        // 2️⃣ Сдвигаем начало и конец Линии 3 — и ВСЕ линии изменятся!
        // Пример: сместим начало line3 (это p2) и конец line3 (это p3)
        p2.setX(20);  // начало line3 и конец line1 → теперь (20,8)
        p2.setY(25);
        p3.setX(30);  // начало line2 и конец line3 → теперь (30,11)
        p3.setY(35);

        // 3️⃣ Выводим Линию 3 ПОСЛЕ изменения
        System.out.println("\nЛиния 3 после изменения:");
        System.out.println(line3);
        System.out.println("Линия 1 после изменения (изменён её конец p2):");
        System.out.println(line1);
        System.out.println("Линия 2 после изменения (изменено её начало p3):");
        System.out.println(line2);

        // 4️⃣ Рассчитываем суммарную длину всех трёх линий
        double totalLength = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.printf("\nСуммарная длина всех трёх линий: %.4f\n", totalLength);


        BrokenLine brokenLine = new BrokenLine(p5, p6, p7, p8);

        // 2️⃣ Рассчитать длину Ломаной
        double brokenLength = brokenLine.getLength();
        System.out.println("Длина ломаной: " + brokenLength);

        // 3️⃣ Получить у Ломаной массив Линий
        Line[] lines = brokenLine.toLines();
        System.out.println("Количество линий в массиве: " + lines.length);

        // 4️⃣ Рассчитать длину массива Линий (сумма длин отрезков)
        double linesTotalLength = brokenLine.getTotalLineLength();
        System.out.println("Сумма длин линий: " + linesTotalLength);

        // 5️⃣ Сравнить длины — они должны совпасть (с точностью до плавающей точки)
        System.out.println("Длины совпадают? " + (Math.abs(brokenLength - linesTotalLength) < 1e-9));

        // 6️⃣ Сдвинуть координату точки {2,8} → {12,8}
        System.out.println("\nДо изменения точки p6:");
        System.out.println("p6: " + p6);
        System.out.println("Ломаная: " + brokenLine);
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Линия " + i + ": " + lines[i]);
        }

        // Изменяем точку p2 — ссылка на объект остаётся той же, поэтому в ломаной и линиях обновится автоматически
        p6.setX(12);
        p6.setY(8);

        System.out.println("\nПосле изменения p6.setX(12); p2.setY(8):");
        System.out.println("p6: " + p6);
        System.out.println("Ломаная: " + brokenLine);
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Линия " + i + ": " + lines[i]);
        }

        // Проверка: обновилась ли длина?
        double newBrokenLength = brokenLine.getLength();
        double newLinesTotal = brokenLine.getTotalLineLength();
        System.out.println("\nНовая длина ломаной: " + newBrokenLength);
        System.out.println("Новая сумма длин линий: " + newLinesTotal);
        System.out.println("Длины после изменения совпадают? " + (Math.abs(newBrokenLength - newLinesTotal) < 1e-9));

    }
}
