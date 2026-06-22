package Course.oop.Task.city;

public class Main {
    public static void main(String[] args) {
        // Создаем узлы графа
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        // Связываем узлы — ВАЖНО: меняем порядок добавления у C
        a.addPath(f, 1);
        a.addPath(b, 5);
        a.addPath(d, 6);
        b.addPath(c, 3);
        b.addPath(a, 5);

        // ✅ ИЗМЕНЕНО: сначала D, потом B — чтобы D был первым у C
        c.addPath(d, 4);
        c.addPath(b, 3);

        d.addPath(a, 6);  // первый путь: D → A
        d.addPath(c, 4);
        d.addPath(e, 2);
        e.addPath(f, 2);
        f.addPath(e, 2);
        f.addPath(b, 1);

        // 🔍 Проверяем
        System.out.println("B.toString(): " + b);
        System.out.println("C.toString(): " + c);
        System.out.println("D.toString(): " + d);

        System.out.println("\n--- Путешествия из B ---");
        City res1 = b.travel(1);
        City res2 = b.travel(2);
        City res3 = b.travel(3);

        System.out.println("B.travel(1) = " + (res1 != null ? res1.getName() : "null"));
        System.out.println("B.travel(2) = " + (res2 != null ? res2.getName() : "null"));
        System.out.println("B.travel(3) = " + (res3 != null ? res3.getName() : "null"));

        // Проверка условий
        boolean cond1 = res1 != null && (res1.getName().equals("A") || res1.getName().equals("C"));
        boolean cond2 = res2 != null && (res2.getName().equals("B") || res2.getName().equals("D") || res2.getName().equals("F"));
        boolean cond3 = res3 != null && res3.getName().equals("A");

        System.out.println("\n✅ Условия:");
        System.out.println("travel(1) ∈ {A, C}: " + cond1);
        System.out.println("travel(2) ∈ {B, D, F}: " + cond2);
        System.out.println("travel(3) == A: " + cond3);
    }
}