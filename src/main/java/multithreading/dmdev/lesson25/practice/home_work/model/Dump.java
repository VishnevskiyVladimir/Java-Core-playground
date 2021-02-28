package multithreading.dmdev.lesson25.practice.home_work.model;

import multithreading.dmdev.lesson25.practice.home_work.util.RandomUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dump {

    private final Object lock = new Object();
    private final List<RobotParts> dump = new LinkedList<>();

    public Dump() {
    }

    public Dump(List<RobotParts> initialRobotParts) {
        dump.addAll(initialRobotParts);
    }

    public void add(RobotParts robotParts) {
        dump.add(robotParts);
    }

    public RobotParts removeRandomPart() {
        //TODO:Test removing of all parts without NPE by one thread
        int index = RandomUtil.getRandomInt(dump.size());
        return dump.remove(index);
    }

    public List<RobotParts> removeAll() {
        List<RobotParts> robotParts = new ArrayList<>(dump);
        dump.clear();
        return robotParts;
    }

    public int size() {
        return dump.size();
    }

    public boolean isNotEmpty() {
        return !dump.isEmpty();
    }

    public Object getLock() {
        return lock;
    }
}
