package com.github.shoothzj.algorithm.amosdeke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0067Test {

    private final Q0067 q0067 = new Q0067();

    @Test
    public void case1() {
        Assertions.assertEquals("abcdef", q0067.transform("abcdef"));
    }

    @Test
    public void case2() {
        Assertions.assertEquals("acdefb", q0067.transform("bcdefa"));
    }

}