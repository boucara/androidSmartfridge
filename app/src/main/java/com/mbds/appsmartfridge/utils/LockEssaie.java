package com.mbds.appsmartfridge.utils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rechi on 14/03/2017.
 */

public class LockEssaie extends ReentrantLock {

    private static LockEssaie lock;

    public static LockEssaie getInstance(){
        if(lock == null){
            lock = new LockEssaie();
        }
        return lock;
    }

    private LockEssaie(){
        super();
    }
}
