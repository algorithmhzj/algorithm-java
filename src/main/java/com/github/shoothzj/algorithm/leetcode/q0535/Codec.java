package com.github.shoothzj.algorithm.leetcode.q0535;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    private final Map<Integer, String> map = new HashMap<>();

    int count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count++;
        map.put(count, longUrl);
        return String.valueOf(count);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));