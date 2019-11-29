package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring("pwwkew"));
        //System.out.println(LengthOfLongestSubstringFast("pwwkew"));
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

    public static Integer LengthOfLongestSubstringFast(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
