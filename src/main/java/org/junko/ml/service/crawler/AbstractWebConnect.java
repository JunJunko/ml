package org.junko.ml.service.crawler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public abstract class AbstractWebConnect {
	
	protected static String sendGet(String url){
		return sendGet(url, "UTF-8");
		
	}
	

	protected static String sendGet(String url, String CharSet)
		{ // 定义一个字符串用来存储网页内容
			StringBuilder result = new StringBuilder();
			// 定义一个缓冲字符输入流
			BufferedReader in = null;
			try
			{
				// 将string转成url对象
				URL realUrl = new URL(url);
				// 初始化一个链接到那个url的连接
				URLConnection connection = realUrl.openConnection();
				// 开始实际的连接
				connection.connect();
				// 初始化 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), CharSet));
				// 用来临时存储抓取到的每一行的数据
				String line;
				while ((line = in.readLine()) != null)
				{
					// 遍历抓取到的每一行并将其存储到result里面
					result.append(line+"\n");
				}
			} catch (Exception e)
			{
				System.out.println("发送GET请求出现异常！" + e);
				e.printStackTrace();
			} // 使用finally来关闭输入流
			finally
			{
				try
				{
					if (in != null)
					{
						in.close();
					}
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			return result.toString();
		}
	
	
	protected static boolean saveUrlAs(String Url, String FileName) {  
        //此方法只能用户HTTP协议  
            try {  
              URL url = new URL(Url);  
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
              DataInputStream in = new DataInputStream(connection.getInputStream());  
              DataOutputStream out = new DataOutputStream(new FileOutputStream(FileName));  
              byte[] buffer = new byte[4096];  
              int count = 0;  
              while ((count = in.read(buffer)) > 0) {  
                out.write(buffer, 0, count);  
              }  
              out.close();  
              in.close();  
              return true;  
            }  
            catch (Exception e) {  
              return false;  
            }  
          }  


}
