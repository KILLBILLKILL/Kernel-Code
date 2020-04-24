package one;
import jdk.jfr.StackTrace;
import org.junit.Test;
import java.io.*;
public class FileOperatorTest {
    @Test
    public void testRead_1() throws Exception {
        //字节流转换为字符流，需要字节字符转换流
        //转换流可以设置编码：java文件的编码格式.文件的编码格式
        //InputStreamReader:输入的字节字符转换流 或者是 OutputStreamWriter:输出的字节字符转换流
        FileInputStream fis=new FileInputStream(
                new File("D:\\Kernel-Code\\io-study\\Io测试\\info.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        //字符流的按行读取
//         String line;
//         while((line=br.readLine())!=null)
//         {
//             System.out.println(line);
//         }
        //字符流按照字符数组读取
        //abcedfg
//         char[]chars=new char[1024];
//         int len=1024;
//         int i;
//         while((i=br.read(chars,0,len))!=-1)
//         {
//             String str=new String(chars);
//             System.out.println(str);
//         }
        char[]chars=new char[1024];
        int len=1024;
        int i;
        while((i=br.read(chars))!=-1)
        {
            String str=new String(chars);
            System.out.println(str);
        }
    }
    public void testRead_2() throws Exception {
        FileInputStream fis=new FileInputStream(
                new File("D:\\Kernel-Code\\io-study\\Io测试\\info.txt"));
        //按字节读取
        byte[] bytes=new byte[1024];
        int len;
        while ((len=fis.read())!=-1){
            String str=new String(bytes,0,len);
            System.out.println();
        }
    }
    @Test
    public void testWrite_1() throws Exception {
            FileOutputStream fos=new FileOutputStream(
                    new File("D:\\Kernel-Code\\io-study\\Io测试\\info.txt"));
            BufferedWriter br=new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        //使用缓冲流注意的细节，输出的时候，要进行flush刷新缓冲区，否则不会真实的输出数据到目的设备
        br.write("1.u搜多少的公司\n");//write写数据到系统内存缓冲区
        br.write("2:好大好大大幅度十分发达\n");
        br.write("3:后第四啊士大夫十大");
        br.flush();//进行缓冲区刷新 发送数据到目的设备
    }
    @Test
    public void copyFile() throws Exception {
        //复制本地文件到另一个地方
        FileInputStream fis=null;
        BufferedInputStream bis=null;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        try {
             fis = new FileInputStream(
                    new File("D:\\Kernel-Code\\io-study\\Io测试\\info.txt"));
           bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(
                    new File("D:\\Kernel-Code\\io-study\\Io测试\\info2.txt"));
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        }finally {//IO流操作完成之后 一定要释放资源，顺序是 根据依赖关系反向释放
            if(bis!=null)
            bis.close();
            if(fis!=null)
                fis.close();
            if(bos!=null)
                bos.close();
            if(fos!=null)
                fos.close();
        }
    }
}
