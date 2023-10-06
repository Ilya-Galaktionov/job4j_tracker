package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder evenPhrase = new StringBuilder();
        int count = evenElements.size() / 2;
        for (int index = 0; index < count; index++) {
            if (evenElements.size() % 2 == 0) {
                evenPhrase.append(evenElements.pollFirst());
            }
            evenElements.pollFirst();
        }
        return evenPhrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder descendingPhrase = new StringBuilder();
        int count = descendingElements.size();
        for (int index = 0; index < count; index++) {
            descendingPhrase.append(descendingElements.pollLast());
        }
        return descendingPhrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
