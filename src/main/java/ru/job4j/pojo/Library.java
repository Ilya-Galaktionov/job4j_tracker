package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 464);
        Book secondBook = new Book("Java Concurrency In Practice", 464);
        Book thirdBook = new Book("Java: The Complete Reference", 1280);
        Book fourthBook = new Book("Do Androids Dream of Electric Sheep?", 320);
        Book[] bk = new Book[4];
        bk[0] = firstBook;
        bk[1] = secondBook;
        bk[2] = thirdBook;
        bk[3] = fourthBook;
        for (Book paper: bk) {
            System.out.println(paper.getName() + ": " + paper.getPageCount());
        }
        System.out.println();
        System.out.println("Replace firstBook to fourthBook.");
        Book temp = bk[0];
        bk[0] = bk[3];
        bk[3] = temp;

        for (Book paper: bk) {
            System.out.println(paper.getName() + ": " + paper.getPageCount());
        }
        System.out.println();
        System.out.println("Show only \"Clean code\"");
        for (Book paper: bk) {
            if (paper.getName().equals("Clean code")) {
                System.out.println(paper.getName() + ": " + paper.getPageCount());
            }
        }
    }
}
