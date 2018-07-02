package 算法6级;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class A068 {
	public static void main(String[] args) {
        Map<Integer,List<String>> levelmap=new HashMap<Integer,List<String>>();
        List<String> putlist=new ArrayList<>();
        putlist.add("澶氫釜鍊�1");
        putlist.add("澶氫釜鍊�2");
        putlist.add("澶氫釜鍊�3");
         
       for (int i=0;i<5;i++){
           levelmap.put(i, putlist);
       }
        
       for (Entry<Integer, List<String>> in: levelmap.entrySet()){
           System.out.println("key===  "+in.getKey()+"     values=  "+in.getValue());
       }
   }
}
