package com.github.shoothzj.algorithm.leetcode;

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
class TicTacToe {

    private final int N;

    private final int[] rowRemainArray;

    private final int[] rowRemainFlag;

    private final int[] colRemainArray;

    private final int[] colRemainFlag;

    private int leftSlashRemain;

    private int leftSlashFlag;

    private int rightSlashRemain;

    private int rightSlashFlag;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rowRemainArray = new int[n];
        for (int i = 0; i < n; i++) {
            rowRemainArray[i] = n;
        }
        rowRemainFlag = new int[n];
        colRemainArray = new int[n];
        for (int i = 0; i < n; i++) {
            colRemainArray[i] = n;
        }
        colRemainFlag = new int[n];
        leftSlashRemain = n;
        leftSlashFlag = 0;
        rightSlashRemain = n;
        rightSlashFlag = 0;
        N = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        //determine the point
        //top row remain
        if (rowRemainFlag[row] == 0) {
            // init player
            rowRemainFlag[row] = player;
            rowRemainArray[row]--;
            if (rowRemainArray[row] == 0) {
                return player;
            }
        } else if (rowRemainFlag[row] == player) {
            rowRemainArray[row]--;
            if (rowRemainArray[row] == 0) {
                return player;
            }
        } else if (rowRemainFlag[row] == -1) {
        } else {
            rowRemainFlag[row] = -1;
        }
        //top row remain
        if (colRemainFlag[col] == 0) {
            // init player
            colRemainFlag[col] = player;
            colRemainArray[col]--;
            if (colRemainArray[col] == 0) {
                return player;
            }
        } else if (colRemainFlag[col] == player) {
            colRemainArray[col]--;
            if (colRemainArray[col] == 0) {
                return player;
            }
        } else if (colRemainFlag[col] == -1) {
        } else {
            colRemainFlag[col] = -1;
        }
        if (col == row) {
            //top row remain
            if (leftSlashFlag == 0) {
                // init player
                leftSlashFlag = player;
                leftSlashRemain--;
                if (leftSlashRemain == 0) {
                    return player;
                }
            } else if (leftSlashFlag == player) {
                leftSlashRemain--;
                if (leftSlashRemain == 0) {
                    return player;
                }
            } else if (leftSlashFlag == -1) {
            } else {
                leftSlashFlag = -1;
            }
        }
        if ((col + row) == N - 1) {
            //top row remain
            if (rightSlashFlag == 0) {
                // init player
                rightSlashFlag = player;
                rightSlashRemain--;
                if (rightSlashRemain == 0) {
                    return player;
                }
            } else if (rightSlashFlag == player) {
                rightSlashRemain--;
                if (rightSlashRemain == 0) {
                    return player;
                }
            } else if (rightSlashFlag == -1) {
            } else {
                rightSlashFlag = -1;
            }
        }
        return 0;
    }
}