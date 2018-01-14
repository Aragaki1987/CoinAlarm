package net.san;

import net.san.timer.Worker;

/**
 * Created by aragaki on 1/13/2018.
 */
public class ApplicationStart{

    public static void main(String[] args) {
        new Worker().start();
    }
}
