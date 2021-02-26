package multithreading.dmdev.lesson25.list;

import java.util.List;

public class ListThread2 extends Thread{
    private final List<Integer> list;

    public ListThread2(List<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

                list.add(i);

        }
    }
}
