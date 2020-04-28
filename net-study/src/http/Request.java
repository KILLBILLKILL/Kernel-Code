package http;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class Request {
    //请求方法 :get 或者是 post
    private String method;
    //请求地址：对应服务端提供的服务路径
    private String url;
    //http版本
    private String version;
    //请求头
    private Map<String,String> headers=new HashMap<>();
    //请求参数
    private Map<String,String> parameters=new HashMap<>();
    /**
     * 类似单例的写法  提供私有的构造方法
     *
     */
    public Request()
    {


    }
    /**
     *通过客户端发送的Http请求数据 ，转换为request请求类
     * 包装请求方法，url,http版本号。请求头。请求参数
     * @param inputStream
     * @return
     */
    public static Request buildRequest(InputStream inputStream) throws IOException {

        Request request=new Request();

        try {
            BufferedReader input=new BufferedReader(
                    new InputStreamReader(inputStream,"UTF-8"));
            System.out.println("==========开始解析Http请求");
            String resquestLine=input.readLine();
            //处理请求行
            request.parseRequestLine(resquestLine);
            //处理请求头
            String header;
            while ((header=input.readLine())!=null&&header.length()!=0)
            {
                String []parts=header.split(":");
                request.headers.put(parts[0].trim(),parts[1].trim());
                System.out.printf("请求头 %s=%s\n",parts[0].trim(),parts[1].trim());
                System.out.println();
            }
            //如果是POST方法提交，并且有Content-Length，表示请求数据中包含我们的请求体
            //需要处理请求体
            if("POST".equalsIgnoreCase(request.method)
                    &&request.headers.containsKey("Content-Length"))
            {
                int len=Integer.parseInt(request.headers.get("Content-Length"));
                char[]chars=new char[len];
                input.read(chars,0,len);
                request.parseParameters(new String(chars));
            }
            System.out.printf("请求参数");
            for(Map.Entry<String,String>entry:request.parameters.entrySet())
            {
                System.out.printf("%s=%s,",entry.getKey(),entry.getValue());
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("处理请求数据",e);
        }
        return request;
    }
    /*
    解析请求行为mthod, url ,verson
     */
    private void parseRequestLine(String requestLine)
    {
        if(requestLine==null)
            return;
        String[] parts=requestLine.split(" ");

        method=parts[0];
        url=parts[1];
        //如果url包含"?",表示有请求参数需要处理
        int index=url.indexOf("?");
        if(index!=-1)
        {
            //包含请求参数时，？前是url，之后的是请求参数
            parseParameters(url.substring(index+1));
            url=url.substring(0,index);

        }
        version=parts[2];
        System.out.printf("请求方法：%s,url: %s,版本号：%s\n", method,url,version);
    }
    /**
     * 解析请求参数
     * 格式为k1=v1&k2=v2&...
     * @param parameters
     */
    private void parseParameters(String parameters){

        String[] parts=parameters.split("&");
        if(parts!=null&parts.length!=0)
        {
            for(String part:parts)
            {
                //part对应看k1=v1
                String[] parrms=part.split("=");
                this.parameters.put(parrms[0],parrms[1]);
            }
        }
    }

    /**
     * 根据请求头中的key获取value
     * @param key
     * @return
     */
    public String getHeader(String key)
    {
        return headers.get(key);
    }

    /**
     * 根据请求参数中的key获取value
     * @param key
     * @return
     */
    public String getParameter(String key)
    {
        return parameters.get(key);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
