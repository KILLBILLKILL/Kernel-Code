package Solution;

public class Solution2 {
    /**
     * 替换空格
     * 题目描述
     *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.
     * 则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static String replaceSpace(StringBuffer str) {
        int length=str.length();
        StringBuilder strc=new StringBuilder();
        for(int i=0;i<length;i++)
        {
           char c=str.charAt(i);
            if(c==' ')
            {
                strc.append("%20");
            }
            else{
                strc.append(c);

            }
        }
        return strc.toString();
    }
    public static void main(String[] args) {
        StringBuffer str=new StringBuffer("j h g f d s");
        int length=str.length();
        System.out.println(length);
        System.out.println(str.charAt(5));
        String src=replaceSpace(str);
        System.out.println(src);
    }


}
