package Course.oop.Task.city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Path> paths;

    // Класс, представляющий путь (связь: город + стоимость)
    public static class Path {
        private City city;
        private int cost;

        public Path(City city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        public City getCity() {
            return city;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return city.name + ":" + cost;
        }
    }

    // Конструктор с обязательным названием и необязательными путями
    public City(String name, Path... paths) {
        this.name = name;
        this.paths = new ArrayList<>();
        if (paths != null) {
            for (Path path : paths) {
                this.paths.add(path);
            }
        }
    }

    // Метод добавления пути
    public void addPath(City city, int cost) {
        paths.add(new Path(city, cost));
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    // Текстовое представление: "Название города [связанные города]"
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" [");
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i).toString());
            if (i < paths.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Метод путешествия: выполняет n шагов, возвращая последний город или null
    public City travel(int n) {
        if (n <= 0) return this;  // или null? зависит от интерпретации. По условию — как минимум 1 город (текущий), но n — кол-во *переходов*
        City current = this;
        int steps = 0;

        while (steps < n && current != null && !current.paths.isEmpty()) {
            // Берём первый путь (по условию)
            City nextCity = current.paths.get(0).getCity();
            if (nextCity == null) {
                return null; // тупик
            }
            current = nextCity;
            steps++;
        }

        return current;
    }
}