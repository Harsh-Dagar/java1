package DP;
/*
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
*/

public class MinStepToOne {
    public static int countMinStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }
        int op1 = countMinStepsToOne(n - 1);
        int minSteps = op1;
        if (n % 2 == 0) {
            int op2 = countMinStepsToOne(n / 2);
            if (op2 < minSteps) {
                minSteps = op2;
            }
        }
        if (n % 2 == 0) {
            int op3 = countMinStepsToOne(n / 2);
            if (op3 < minSteps) {
                minSteps = op3;
            }
        }
        return minSteps + 1;
    }

    public int countStepsM(int n) {
        int storage[] = new int[n + 1];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = -1;
        }
        return countStepsM(n, storage);
    }

    private int countStepsM(int n, int storage[]) {
        if (n == 1) {
            storage[1] = 0;
            return storage[1];
        }
        if (storage[n] != -1) {
            return storage[n];
        }
        int op1;
        if (storage[n - 1] != -1) {
            op1 = storage[n - 1];
        } else {
            op1 = countMinStepsToOne(n - 1);
            storage[n - 1] = op1;
        }
        int minSteps = op1;
        if (n % 2 == 0) {
            int op2;
            if (storage[n / 2] != -1) {
                op2 = storage[n / 2];
            } else {
                op2 = countMinStepsToOne(n / 2);
                storage[n / 2] = op2;
            }
            if (op2 < minSteps) {
                minSteps = op2;
            }
        }
        if (n % 3 == 0) {
            int op3;
            if (storage[n / 3] != -1) {
                op3 = storage[n / 3];
            } else {
                op3 = countMinStepsToOne(n / 3);
                storage[n / 3] = op3;
            }
            if (op3 < minSteps) {
                minSteps = op3;
            }
        }
        storage[n]=minSteps+1;
        return storage[n];
    }

    public static int countStepsDP(int n){
        int storage[]=new int[n+1];
        storage[1]=0;
        for(int i=2;i<=n;i++){
            int min=storage[i-1];
            if(i%2==0){
                int op1=storage[i/2];
                if(op1<min){
                    min=op1;
                }
            }
            if(i%3==0){
                int op2=storage[i/3];
                if(op2<min){
                    min=op2;
                }
            }
            storage[i]=min+1;
        }
        return storage[n];
    }
}
