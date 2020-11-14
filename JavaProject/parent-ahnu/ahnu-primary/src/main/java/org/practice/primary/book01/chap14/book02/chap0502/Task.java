package org.practice.primary.book01.chap14.book02.chap0502;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
    private static final long serialVersionUID = 9036040532883927425L;
    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task() {
    }

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {

    }
}
