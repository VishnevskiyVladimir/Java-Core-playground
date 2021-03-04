package multithreading.dmdev.lesson25_low_level_work.practice.home_work.model;

import multithreading.dmdev.lesson25_low_level_work.practice.home_work.util.RandomUtil;

public enum RobotParts {

    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG,
    BODY,
    HEAD,
    RAM,
    CPU,
    HDD;


    public static RobotParts getRandomPart(){
        return RobotParts.values()[RandomUtil.getRandomInt(9)];
    }

}
