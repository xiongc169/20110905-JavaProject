package org.practice.primary.book01.chap14.book02.chap0407;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {

    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        //ExecutableTask
        //this.name = ((ExecutableTask) callable).getClass();
    }

    protected void done() {
        if (isCancelled()) {
            System.out.println("ResultTask.isCancelled(): true ");
        } else {
            System.out.println("ResultTask.isCancelled(): false");
        }
    }
}
