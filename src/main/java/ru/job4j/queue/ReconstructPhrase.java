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
        for (int index = evenElements.size(); index > 0; index--) {
            if (evenElements.size() % 2 == 0 && evenElements.peek() != null) {
                evenPhrase.append(evenElements.pollFirst());
            }
            evenElements.pollFirst();
        }
        return evenPhrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder descendingPhrase = new StringBuilder();
        for (int index = descendingElements.size(); index > 0; index--) {
            descendingPhrase.append(descendingElements.pollLast());
        }
        return descendingPhrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
