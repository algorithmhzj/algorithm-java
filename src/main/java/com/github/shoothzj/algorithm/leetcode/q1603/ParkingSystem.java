package com.github.shoothzj.algorithm.leetcode.q1603;

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
class ParkingSystem {

    private int big;

    private int med;

    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.med = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.big == 0) {
                return false;
            }
            this.big--;
        }
        if (carType == 2) {
            if (this.med == 0) {
                return false;
            }
            this.med--;
        }
        if (carType == 3) {
            if (this.small == 0) {
                return false;
            }
            this.small--;
        }
        return true;
    }
}