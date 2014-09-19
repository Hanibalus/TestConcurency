/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.concurency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Eugen.Popa
 */
public class Counter {

    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.getAndIncrement();
    }

    public void decrement() {
        c.getAndDecrement();
    }

    public int getCount() {
        return c.get();
    }
}
