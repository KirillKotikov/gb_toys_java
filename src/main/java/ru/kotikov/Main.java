package ru.kotikov;

import ru.kotikov.models.Toy;

import java.util.PriorityQueue;

public class Main {
    private static final PriorityQueue<Toy> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        PrizeMachine prizeMachine = new PrizeMachine();

        for (int i = 0; i < 10; i++) {
            Toy toy = prizeMachine.takePrize();
            if (toy == null) break;
            queue.add(toy);
        }

        for (int i = 0; i < 10; i++) {
            if (!queue.isEmpty()) prizeMachine.givePrise(queue.poll());
        }
    }
}