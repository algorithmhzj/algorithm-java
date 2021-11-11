package com.github.shoothzj.algorithm.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhangjian
 */
public class Dhcp {

    private final int[] array = new int[256];

    private final Map<String, Integer> historyIp = new HashMap<>();

    private final Map<String, Integer> usedIp = new HashMap<>();

    public Integer get(String mac) {
        if (usedIp.containsKey(mac)) {
            return usedIp.get(mac);
        }
        if (historyIp.containsKey(mac)) {
            final Integer oldIp = historyIp.get(mac);
            if (array[oldIp] == 0) {
                array[oldIp] = 1;
                usedIp.put(mac, oldIp);
                return oldIp;
            }
        }
        int index = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] == 0) {
                historyIp.put(mac, i);
                usedIp.put(mac, i);
                array[i] = 1;
                return i;
            }
        }
        return -1;
    }

    public void release(String mac) {
        if (!usedIp.containsKey(mac)) {
            return;
        }
        final Integer ip = usedIp.get(mac);
        usedIp.remove(mac);
        array[ip] = 0;
    }

}
