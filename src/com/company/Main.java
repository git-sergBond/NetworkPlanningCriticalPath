package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Example1();
        //Var2Ex1();
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
        //TODO написать в дальнейшем прогу для вычисления предшественниов и последователей
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
     * Вариант 2.
     * Задача1.
     */
    public static void Var2Ex1() {
        Node n1 = Node.createInitialNode();
        Node n2 = new Node(30);
        Node n3 = new Node(15);
        Node n4 = new Node(20);
        Node n5 = new Node(25);
        Node n6 = new Node(30);
        Node n7 = new Node(45);
        Node n8 = new Node(45);
        Node n9 = new Node(25);
        Node n10 = new Node(60);
        Node n11 = new Node(40);
        Node n12 = new Node(7);
        Node n13 = Node.createFinishNode();
        //TODO написать в дальнейшем прогу для вычисления предшественниов и последователей
        n1.addNext(n2);
        n2.addPre(n1)           .addNext(n3,n4,n5);
        n3.addPre(n2)           .addNext(n8);
        n4.addPre(n2)           .addNext(n6, n7);
        n5.addPre(n2)           .addNext(n7, n8);
        n6.addPre(n4)           .addNext(n9);
        n7.addPre(n4, n5)       .addNext(n9);
        n8.addPre(n3, n5)       .addNext(n9);
        n9.addPre(n8, n6, n7)   .addNext(n10, n11);
        n10.addPre(n9)          .addNext(n12);
        n11.addPre(n9)          .addNext(n12);
        n12.addPre(n10, n11)    .addNext(n13);
        n13.addPre(n12);

        networkPlaningModel(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13));
    }

    public static void networkPlaningModel(List<Node> forwardElevationOrder) {
        //TODO Порядок вычисления важен для самих данных (написать в дальнейшем прогу для вычисления порядка)
        //а пока можно просто перечислить вершины по порядку, слева на права, сверху вниз
        //типа так Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13)
        //TODO + тут важен порядок вычислений для самих функций (Раннее время начала задач -> Позднее время начала задач-> Резервное время на задачи -> Критический путь, сделать так, чтобы программа была не зависима от порядка вычислений

        System.out.println("Раннее время начала задач:");
    //    while (!Node.isAllCalcEarlyStartTime(forwardElevationOrder)) {
            for (var n : forwardElevationOrder) {
                n.calcEarlyStartTime();
            }
    //    }

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

        System.out.println("Критический путь:");
        for (var n : forwardElevationOrder) {
            if (n.isCritical()) {
                System.out.print("[" + n.getNumber() + "]->");
            }
        }
        System.out.println();

        System.out.println("Итог:");
        for (var n : forwardElevationOrder) {
            System.out.println("№" + n.getNumber() + (n.isCritical() ? " [КРИТИЧЕСКАЯ ЗАДАЧА]" : ""));
            System.out.println("Длительность: " + n.getCost());
            System.out.println("Раннее время начала: " + n.getEarlyStartTime());
            System.out.println("Позднее время начала: " + n.getLateStartTime());
            System.out.println("Резерв времени: " + n.getReserveTime());
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
         * Длительность задачи в днях.
         */
        private final int cost;

        /**
         * Предшествующие задачи.
         */
        private Node[] preNodes = new Node[] {};

        /**
         * Следующие задачи.
         */
        private Node[] nextNodes = new Node[] {};

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

        public static Node createInitialNode() {
            Node n = new Node(0);
            //n.isCalculatedEarlyStartTime = true;
            //n.isCalculatedLateStartTime = true;
            return n;
        }

        public static Node createFinishNode() {
            Node n = new Node(0);
            //n.isCalculatedEarlyStartTime = true;
            //n.isCalculatedLateStartTime = true;
            return n;
        }

        public Node addPre(Node... preNodes) {
            if (!Objects.isNull(preNodes)) {
                this.preNodes = preNodes;
            }
            return this;
        }

        public void addNext(Node... nextList) {
            if (!Objects.isNull(nextList)) {
                this.nextNodes = nextList;
            }
        }

        public void calcEarlyStartTime() {
            if (isCalculatedEarlyStartTime) {
                return;
            }
/*
            if (Arrays.stream(preNodes).anyMatch(n -> !(n.isCalculatedEarlyStartTime))) {
                System.out.print("№" + number + " Пропуск, что-то не посчитано");
                return;
            }
*/
            //System.out.print("Раннее время начала задачи №" + number + " Max(");
            System.out.print("№" + number + " Max(");
            earlyStartTime = Arrays.stream(preNodes)
                    .peek(p -> System.out.print("[" + p.number + "] " + p.earlyStartTime + " + " + p.cost))
                    .map(p -> p.getEarlyStartTime() + p.cost)
                    .peek(e -> System.out.print(" = " + e + "; "))
                    .max(Integer::compareTo)
                    .orElse(0);
            System.out.println(") = " + earlyStartTime + "");

            isCalculatedEarlyStartTime = true;
        }
/*
        public static boolean isAllCalcEarlyStartTime(List<Node> forwardElevationOrder) {
            return forwardElevationOrder.stream().anyMatch(n -> n.isCalculatedEarlyStartTime);
        }
*/
        public void calcLateStartTime() {
            if (isCalculatedLateStartTime) {
                return;
            }
/*
            if (Arrays.stream(nextNodes).anyMatch(n -> !(n.isCalculatedLateStartTime))) {
                System.out.print("№" + number + " Пропуск, что-то не посчитано");
                return;
            }
*/
            //System.out.print("Позднее время начала задачи №" + number + " Max(");
            System.out.print("№" + number + " Min(");
            lateStartTime = Arrays.stream(nextNodes)
                    .peek(p -> System.out.print("[" + p.number + "] " + p.lateStartTime + " - " + cost))
                    .map(p -> p.lateStartTime - cost)
                    .peek(e -> System.out.print(" = " + e + "; "))
                    .min(Integer::compareTo)
                    .orElse(earlyStartTime);
            System.out.println(") = " + lateStartTime + "");

            isCalculatedLateStartTime = true;
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
                calcEarlyStartTime();
            }

            return earlyStartTime;
        }

        public int getLateStartTime() {
            if (!isCalculatedLateStartTime) {
                calcLateStartTime();
            }

            return lateStartTime;
        }

        public int getReserveTime() {
            return reserveTime;
        }

        public int getNumber() {
            return number;
        }

        private int createNumber() {
            return numberCounter++;
        }
    }
}
