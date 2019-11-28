package code;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring("au"));
    }

    public static Integer LengthOfLongestSubstring(String s){
        Integer count = 0;
        List<String> list = new ArrayList<>();
        List<String> tempList = null;
        char[] chars = s.toCharArray();
        int i ,j;
        for(char charStr : chars){
            String str = String.valueOf(charStr);
            if(0>=list.size()){
                list.add(str);
            }else{
                for(i=0;i<list.size();i++){
                    String str1 = list.get(i);
                    if(str.equals(str1)){
                        tempList = new ArrayList<>();
                        if(count<list.size()){
                            count = list.size();
                        }
                        if(i==list.size()-1){
                            break;
                        }
                        for(j=i+1;j<list.size();j++){
                            tempList.add(list.get(j));
                        }
                        break;
                    }
                }
                if(tempList!=null){
                    list = new ArrayList<>(tempList);
                    tempList = null;
                }
                list.add(str);
            }
        }
        if(count<list.size()){
            count = list.size();
        }
        return count;
    }

}
