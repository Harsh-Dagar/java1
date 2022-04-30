package DP;

public class LootHouses {
    public static int maxMoneyLooted(int houses[]){
        if(houses.length==1){
            return houses[0];
        }
        if(houses.length==0){
            return 0;
        }
        int storage[]=new int[houses.length];
        storage[0]=houses[0];
        storage[1]=Math.max(houses[0],houses[1]);
        for(int i=2;i<houses.length;i++){
            storage[i]=Math.max(storage[i-1],storage[i-2]+houses[i]);
        }
        return storage[houses.length-1];
    }
}
