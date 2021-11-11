package com.github.shoothzj.algorithm.leetcode.q1166;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shoothzj
 */
class FileSystemTest {

    @Test
    public void testCase1() {
        FileSystem fileSystem = new FileSystem();
        Assertions.assertTrue(fileSystem.createPath("/a", 1));
        Assertions.assertEquals(1, fileSystem.get("/a"));
    }

}
