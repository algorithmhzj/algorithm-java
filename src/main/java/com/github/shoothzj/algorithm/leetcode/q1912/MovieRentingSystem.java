package com.github.shoothzj.algorithm.leetcode.q1912;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
class MovieRentingSystem {

    final Comparator<Entry> comparator = (o1, o2) -> {
        if (o1.price != o2.price) {
            return Integer.compare(o1.price, o2.price);
        }
        if (o1.shop != o2.shop) {
            return Integer.compare(o1.shop, o2.shop);
        }
        return Integer.compare(o1.movie, o2.movie);
    };

    /**
     * moveId -> TreeSet of Entries
     */
    final HashMap<Integer, Set<Entry>> unRented = new HashMap<>();

    /**
     * shop, movie -> price
     */
    final HashMap<IntPair, Integer> priceMap = new HashMap<>();

    final TreeSet<Entry> rented = new TreeSet<>(comparator);

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];
            unRented.computeIfAbsent(movie, x -> new TreeSet<>(comparator)).add(new Entry(price, shop, movie));
            priceMap.put(new IntPair(shop, movie), price);
        }
    }

    public List<Integer> search(int movie) {
        return unRented.getOrDefault(movie, Collections.emptySet()).stream().limit(5).map(e -> e.shop).collect(Collectors.toList());
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(new IntPair(shop, movie));
        unRented.get(movie).remove(new Entry(price, shop, movie));
        rented.add(new Entry(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(new IntPair(shop, movie));
        unRented.get(movie).add(new Entry(price, shop, movie));
        rented.remove(new Entry(price, shop, movie));
    }

    public List<List<Integer>> report() {
        return rented.stream().limit(5).map(e -> {
            List<Integer> res = new ArrayList<>();
            res.add(e.shop);
            res.add(e.movie);
            return res;
        }).collect(Collectors.toList());
    }

    public static class IntPair {

        public final int fst;
        public final int snd;

        public IntPair(int fst, int snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public boolean equals(Object other) {
            if (!(other instanceof IntPair)) {
                return false;
            }
            IntPair aux = (IntPair) other;
            return fst == aux.fst && snd == aux.snd;
        }

        public int hashCode() {
            return fst + snd;
        }

    }

    static class Entry {
        final int price;
        final int shop;
        final int movie;

        public Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }
}