package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Example1();
        //Example2();
        //Var2Ex1();
        //Var2Ex2();
        Var2Ex3();
    }

    /**
     * Пример 1.
     */
    public static void Example1() {
        Node n1 = Node.createInitialNode();
        Node n2 = new Node(10);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(6);
        Node n6 = new Node(8);
        Node n7 = new Node(5);
        Node n8 = new Node(10);
        Node n9 = new Node(5);
        Node n10 =  Node.createFinishNode();
        n1.addNext(n2);
        n2.addPre(n1)           .addNext(n3,n5);
        n3.addPre(n2)           .addNext(n4);
        n4.addPre(n3, n5)           .addNext(n7);
        n5.addPre(n2)           .addNext(n4,n6);
        n6.addPre(n5)           .addNext(n7);
        n7.addPre(n4,n6)       .addNext(n8, n9);
        n8.addPre(n7)       .addNext(n10);
        n9.addPre(n7)   .addNext(n10);
        n10.addPre(n8,n9);

        networkPlaningModel(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10));
    }

    /**
     * Пример 2.
     */
    public static void Example2() {
        Node n1 = Node.createInitialNode();
        Node n2 = new Node(15);
        Node n3 = new Node(7);
        Node n4 = new Node(7);
        Node n5 = new Node(15);
        Node n6 = new Node(30);
        Node n7 = new Node(20);
        Node n8 = new Node(5);
        Node n9 = new Node(25);
        Node n10 =  new Node(40);
        Node n11 =  new Node(30);
        Node n12 =  new Node(5);
        Node n13 =  Node.createFinishNode();

        var network = new NetworkPlaningModel(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13));

        network.addEdge(1, 2);

        network.addEdge(2, 3);
        network.addEdge(2, 4);
        network.addEdge(2, 5);

        network.addEdge(3, 8);

        network.addEdge(4, 6);
        network.addEdge(4, 7);

        network.addEdge(5, 8);
        network.addEdge(5, 7);

        network.addEdge(6, 9);

        network.addEdge(7, 9);

        network.addEdge(8, 9);

        network.addEdge(9, 10);

        network.addEdge(9, 11);

        network.addEdge(10, 12);

        network.addEdge(11, 12);

        network.addEdge(12, 13);

        network.calculate();
    }

    /**
     * Вариант 2.
     * Задача1.
     */
    public static void Var2Ex1() {
        var model = new NetworkPlaningModel(
                Node.createInitialNode(),
                new Node(30),
                new Node(15),
                new Node(20),
                new Node(25),
                new Node(30),
                new Node(45),
                new Node(45),
                new Node(25),
                new Node(60),
                new Node(40),
                new Node(7),
                Node.createFinishNode()
        );

        model.addEdge(1, 2);

        model.addEdge(2, 3);
        model.addEdge(2, 4);
        model.addEdge(2, 5);

        model.addEdge(3, 8);

        model.addEdge(4, 6);
        model.addEdge(4, 7);

        model.addEdge(5, 8);
        model.addEdge(5, 7);

        model.addEdge(6, 9);
        model.addEdge(7, 9);
        model.addEdge(8, 9);

        model.addEdge(9, 10);
        model.addEdge(9, 11);

        model.addEdge(10, 12);
        model.addEdge(11, 12);

        model.addEdge(12, 13);

        model.calculate();
    }

    /**
     * Вариант 2.
     * Задача 2.
     */
    public static void Var2Ex2() {
        var model = new NetworkPlaningModel(
                Node.createInitialNode(),
                new Node(7),
                new Node(10),
                new Node(8),
                new Node(9),
                new Node(7),
                new Node(5),
                new Node(6),
                new Node(5),
                new Node(3),
                new Node(4),
                new Node(3),
                new Node(5),
                new Node(5),
                Node.createFinishNode()
        );

        model.addEdge(1, 2);

        model.addEdge(2, 3);
        model.addEdge(2, 4);
        model.addEdge(2, 5);

        model.addEdge(3, 6);
        model.addEdge(3, 7);

        model.addEdge(4, 7);
        model.addEdge(4, 10);

        model.addEdge(5, 7);
        model.addEdge(5, 8);

        model.addEdge(6, 9);
        model.addEdge(7, 9);

        model.addEdge(8, 10);
        model.addEdge(8, 11);

        model.addEdge(9, 11);
        model.addEdge(9, 12);

        model.addEdge(10, 12);
        model.addEdge(10, 13);

        model.addEdge(11, 14);
        model.addEdge(12, 14);
        model.addEdge(13, 14);

        model.addEdge(14, 15);

        model.calculate();
    }

    /**
     * Вариант 2.
     * Задача 3.
     */
    public static void Var2Ex3() {
        var model = new NetworkPlaningModel(
                /* 1 */Node.createInitialNode(),
                /* 2 */new Node(7, "Создание договора об участии в маркетинговом исследовании для предприятий"),
                /* 3 */new Node(3, "Поиск компаний"),
                /* 4 */new Node(7, "Рассылка договора"),
                /* 5 */new Node(3, "Подготовка базы данных"),
                /* 6 */new Node(1, "Продумать 'Характеристики выборки'"),
                /* 7 */new Node(1, "Продумать вектор 'Анализа актуальности задач инвестиционного и финансового анализа'"),
                /* 8 */new Node(1, "Продумать вектор 'Анализ спроса на программное обеспечение для инвестиционного и финансового анализа'"),
                /* 9 */new Node(1, "Продумать вектор 'Анализ спроса на консультационные услуги и обучение в области инвестиционного и финансового анализа'"),
                /* 10 */new Node(1, "Продумать вектор 'Анализ источников информации, используемых покупателями'"),
                /* 11 */new Node(3, "Рассылка анкет"),
                /* 12 */new Node(14, "Получение ответа от организаций"),
                /* 13 */new Node(1, "Произвести: 'Характеристики выборки'"),
                /* 14 */new Node(3, "Произвести: 'Анализа актуальности задач инвестиционного и финансового анализа'"),
                /* 15 */new Node(3, "Произвести: 'Анализ спроса на программное обеспечение для инвестиционного и финансового анализа'"),
                /* 16 */new Node(3, "Произвести: 'Анализ спроса на консультационные услуги и обучение в области инвестиционного и финансового анализа'"),
                /* 17 */new Node(3, "Произвести: 'Анализ источников информации, используемых покупателями'"),
                /* 18 */new Node(1, "Сделать заключение"),
                /* 19 */Node.createFinishNode()
        );

        model.addEdge(1, 2);
        model.addEdge(1, 3);
        model.addEdge(1, 5);
        model.addEdge(1, 6);

        model.addEdge(2, 4);
        model.addEdge(3, 4);

        model.addEdge(4, 12);
        model.addEdge(5, 12);

        model.addEdge(6, 7);
        model.addEdge(6, 8);
        model.addEdge(6, 9);
        model.addEdge(6, 10);

        model.addEdge(7, 11);
        model.addEdge(8, 11);
        model.addEdge(9, 11);
        model.addEdge(10, 11);

        model.addEdge(11, 12);

        model.addEdge(12, 13);

        model.addEdge(13, 14);
        model.addEdge(13, 15);
        model.addEdge(13, 16);
        model.addEdge(13, 17);

        model.addEdge(14, 18);
        model.addEdge(15, 18);
        model.addEdge(16, 18);
        model.addEdge(17, 18);

        model.addEdge(18, 19);

        model.calculate();
    }

    public static void networkPlaningModel(List<Node> forwardElevationOrder) {
        //TODO Порядок вычисления важен для самих данных (написать в дальнейшем прогу для вычисления порядка)
        //а пока можно просто перечислить вершины по порядку, слева на права, сверху вниз
        //типа так Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13)
        //TODO + тут важен порядок вычислений для самих функций (Раннее время начала задач -> Позднее время начала задач-> Резервное время на задачи -> Критический путь, сделать так, чтобы программа была не зависима от порядка вычислений

        System.out.println("Раннее время начала задач:");
        for (var n : forwardElevationOrder) {
            n.calcEarlyStartTime();
        }

        System.out.println("Позднее время начала задач:");
        var reverseElevationOrder = new ArrayList<>(forwardElevationOrder);
        Collections.reverse(reverseElevationOrder);
        for (var n : reverseElevationOrder) {
            n.calcLateStartTime();
        }

        System.out.println("Резервное время на задачи:");
        for (var n : forwardElevationOrder) {
            n.calcReserveTime();
        }

        System.out.print("Критический путь можно составить, если соединить дугами задачи:");
        for (var n : forwardElevationOrder) {
            if (n.isCritical()) {
                System.out.print(n.getNumber() + ",");
            }
        }
        System.out.println();

        System.out.println("Итог:");
        for (var n : forwardElevationOrder) {
            System.out.println("№" + n.getNumber() + (n.isCritical() ? " [КРИТИЧЕСКАЯ ЗАДАЧА]" : ""));
            System.out.println("Название: " + n.getName());
            System.out.println("Длительность: " + n.getCost());
            System.out.println("Раннее время начала: " + n.getEarlyStartTime());
            System.out.println("Позднее время начала: " + n.getLateStartTime());
            System.out.println("Резерв времени: " + n.getReserveTime());
        }
    }

    static class NetworkPlaningModel {

        private final List<Node> forwardElevationOrder;

        public NetworkPlaningModel(List<Node> forwardElevationOrder) {
            this.forwardElevationOrder = forwardElevationOrder;
        }

        public NetworkPlaningModel(Node... forwardElevationOrder) {
            this.forwardElevationOrder = Arrays.asList(forwardElevationOrder);
        }

        public void calculate() {
            networkPlaningModel(forwardElevationOrder);
        }

        public void addEdge(int fromNumber, int toNumber) {
            Node from = this.forwardElevationOrder.stream().filter(e -> e.getNumber() == fromNumber).findFirst().orElseThrow();
            Node to = this.forwardElevationOrder.stream().filter(e -> e.getNumber() == toNumber).findFirst().orElseThrow();
            from.addNext(to);
            to.addPre(from);
        }

    }

    static class Node {

        /**
         * счетчик порядкового номера.
         */
        private static int numberCounter = 1;

        /**
         * Порядковый номер, который присваевается автоматически.
         */
        private final int number;

        /**
         * Наименование работы.
         */
        private String name;

        /**
         * Длительность задачи в днях.
         */
        private final int cost;

        /**
         * Предшествующие задачи.
         */
        private List<Node> preNodes = new ArrayList<Node>();

        /**
         * Следующие задачи.
         */
        private List<Node> nextNodes = new ArrayList<Node>();

        /**
         * Раннее время начала.
         */
        private int earlyStartTime = 0;

        private boolean isCalculatedEarlyStartTime = false;//нужно для того, чтобы ноды которые не были расчитаны не попадали в расчет

        /**
         * Позднее время начала.
         */
        private int lateStartTime = 0;

        private boolean isCalculatedLateStartTime = false;//нужно для того, чтобы ноды которые не были расчитаны не попадали в расчет

        /**
         * Резерв времени.
         */
        private int reserveTime = 0;

        public Node(int cost) {
            this.cost = cost;
            this.number = createNumber();
        }

        public Node(int cost, String name) {
            this.cost = cost;
            this.number = createNumber();
            this.name = name;
        }

        public static Node createInitialNode() {
            return new Node(0, "Начало проекта");
        }

        public static Node createFinishNode() {
            return new Node(0, "Конец проекта");
        }

        public Node addPre(Node... preNodes) {
            if (!Objects.isNull(preNodes)) {
                this.preNodes = Arrays.asList(preNodes);
            }
            return this;
        }

        public Node addPre(Node pre) {
            if (!Objects.isNull(preNodes)) {
                if (this.preNodes.stream().anyMatch(n -> n.getNumber() == pre.getNumber())) {
                    return this;
                }
                this.preNodes.add(pre);
            }
            return this;
        }

        public void addNext(Node... nextList) {
            if (!Objects.isNull(nextList)) {
                this.nextNodes = Arrays.asList(nextList);
            }
        }

        public void addNext(Node next) {
            if (!Objects.isNull(next)) {
                if (this.nextNodes.stream().anyMatch(n -> n.getNumber() == next.getNumber())) {
                    return;
                }
                this.nextNodes.add(next);
            }
        }

        public int calcEarlyStartTime() {
            if (isCalculatedEarlyStartTime) {
                return earlyStartTime;
            }

            preNodes.stream().filter(n -> !(n.isCalculatedEarlyStartTime)).forEach(Node::getEarlyStartTime);

            //System.out.print("Раннее время начала задачи №" + number + " Max(");
            System.out.print("№" + number + " Max(");
            earlyStartTime = preNodes.stream()
                    .peek(p -> System.out.print("[" + p.number + "] " + p.getEarlyStartTime() + " + " + p.cost))
                    .map(p -> p.getEarlyStartTime() + p.cost)
                    //.peek(e -> System.out.print(" = " + e + "; "))
                    .peek(e -> System.out.print("; "))
                    .max(Integer::compareTo)
                    .orElse(0);
            System.out.println(") = " + earlyStartTime + "");

            isCalculatedEarlyStartTime = true;
            return earlyStartTime;
        }

        public int calcLateStartTime() {
            if (isCalculatedLateStartTime) {
                return lateStartTime;
            }

            nextNodes.stream().filter(n -> !(n.isCalculatedLateStartTime)).forEach(Node::getLateStartTime);

            //System.out.print("Позднее время начала задачи №" + number + " Max(");
            System.out.print("№" + number + " Min(");
            lateStartTime = nextNodes.stream()
                    .peek(p -> System.out.print("[" + p.number + "] " + p.getLateStartTime() + " - " + cost))
                    .map(p -> p.getLateStartTime() - cost)
                    //.peek(e -> System.out.print(" = " + e + "; "))
                    .peek(e -> System.out.print("; "))
                    .min(Integer::compareTo)
                    .orElse(earlyStartTime);
            System.out.println(") = " + lateStartTime + "");

            isCalculatedLateStartTime = true;
            return lateStartTime;
        }

        public void calcReserveTime() {
            reserveTime = lateStartTime - earlyStartTime;
            //System.out.println("Резервное время на задачу №" + number + " = " + lateStartTime + " - " + earlyStartTime + " = " + reserveTime);
            System.out.println("№" + number + " = " + lateStartTime + " - " + earlyStartTime + " = " + reserveTime);
        }

        public boolean isCritical() {
            return reserveTime == 0;
        }

        public int getCost() {
            return cost;
        }

        public int getEarlyStartTime() {
            if (!isCalculatedEarlyStartTime) {
                return calcEarlyStartTime();
            }

            return earlyStartTime;
        }

        public int getLateStartTime() {
            if (!isCalculatedLateStartTime) {
                return calcLateStartTime();
            }

            return lateStartTime;
        }

        public int getReserveTime() {
            return reserveTime;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        private int createNumber() {
            return numberCounter++;
        }
    }
}
