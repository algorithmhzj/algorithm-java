package com.github.shoothzj.algorithm.amosdeke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0068Test {

    private final Q0068 q0068 = new Q0068();

    @Test
    public void case1() {
        Assertions.assertEquals(2, q0068.minAbsAdd(new int[]{-1, -3, 7, 5, 11, 15}));
    }

}