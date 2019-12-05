package code;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {

        String[] strings = new String[]{"aca","cba"};
        System.out.printf(longestCommonPrefix(strings));
        System.out.printf(longestCommonPrefixStandard(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder();
        if(strs.length<=0){
            return common.toString();
        }
        if(strs.length==1){
            return common.append(strs[0]).toString();
        }
        char[] chars = strs[0].toCharArray();
        for(int j=0;j<chars.length;j++){
            String temp = null;
            for(int i=1;i<strs.length;i++){
                temp = String.valueOf(chars[j]);
                if(strs[i].indexOf(temp, j)!=j){
                    temp = null;
                    break;
                }
            }
            if(j==0&&temp==null){
                break;
            }
            if(null!=temp){
                common.append(temp);
            }

        }
        return common.toString();
    }

    public static String longestCommonPrefixStandard(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

}
