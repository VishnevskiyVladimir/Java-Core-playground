package multithreading.dmdev.lesson25_low_level_work.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListRunner {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread listThread1 = new ListThread(list);
        Thread listThread2 = new ListThread(list);
        Thread listThread3 = new ListThread(list);
        Thread listThread4 = new ListThread(list);
        Thread listThread5 = new ListThread(list);
        Thread listThread6 = new ListThread(list);
        Thread listThread7 = new ListThread(list);
        Thread listThread8 = new ListThread(list);
        Thread listThread9 = new ListThread(list);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();
        listThread8.start();
        listThread9.start();

        try {
            listThread1.join();
            listThread2.join();
            listThread3.join();
            listThread4.join();
            listThread5.join();
            listThread6.join();
            listThread7.join();
            listThread8.join();
            listThread9.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
