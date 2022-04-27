package com.github.shoothzj.algorithm.amosdeke;

public class Q0067 {

    public String transform(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            char ch = charArray[i];
            int minIndex = -1;
            int minChar = ch;
            for (int j = i; j < charArray.length; j++) {
                if (charArray[j] < minChar) {
                    minChar = charArray[j];
                    minIndex = j;
                }
            }
            if (minIndex != -1) {
                char aux = charArray[minIndex];
                charArray[minIndex] = charArray[i];
                charArray[i] = aux;
                break;
            }
        }
        return new String(charArray);
    }

}
