package com.github.shoothzj.algorithm.leetcode.q0588;

import org.junit.jupiter.api.Test;

import java.util.List;

class FileSystemTest {

    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.ls("/");
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        List<String> ls = fileSystem.ls("/");
        fileSystem.readContentFromFile("/a/b/c/d");
    }

}