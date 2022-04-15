package HashMap;

import java.util.HashMap;
import java.util.Set;

public class MapUse {
    public static void main(String[]args){
        HashMap<String,Integer> map=new HashMap<>();
        //insertion
        map.put("abc", 1);
        map.put("def", 2);
        map.put("ghi", 3);

        if(map.containsKey("abc")){
            System.out.println("has \"abc\"");
            
        }
        if(map.containsKey("abc1")){
            System.out.println("has abc1");
        }

        //get value
        System.out.println(map.get("abc"));
        // System.out.println(map.get("abc11"));
        try{
            int a=map.get("abc1");
            System.out.println(a);
        }
        catch(NullPointerException e){
            System.out.println("null");
            
        }
        Set<String> keys =map.keySet();
        for(String str: keys){
            System.out.println(str);
        }

        

        System.out.println("End of program");
        
        
    }
}
