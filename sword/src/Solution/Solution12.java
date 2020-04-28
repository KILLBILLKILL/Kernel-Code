package Solution;

import org.w3c.dom.ls.LSOutput;

/**
 * 数值的整数次方
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *

 * /**
 *  * 1.全面考察指数的正负、底数是否为零等情况。
 *  * 2.写出指数的二进制表达，例如13表达为二进制1101。
 *  * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
 *  * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 *  */

public class Solution12 {
    public  static  double Power(double base, int exponent){
        double res=1 ,curr=base;
        int exponent1;
        if(exponent>0) {
            exponent1 = exponent;
        }
        else if(exponent<0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            exponent1 = -exponent;
        }
          else{
            return 1;
        }
          while(exponent1!=0)
          {
              if((exponent1&1)==1)
              {
                 res*=curr;
              }
              curr*=curr;//指数翻倍
              exponent1>>=1;
          }
            return  exponent>0?res:(1/res);
    }



}
