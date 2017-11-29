package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Demo1 {
	public static void main(String[] args) {
		Demo1 d = new Demo1();
		try {
			System.out.println(d.getJsonText(
					"http://api.k780.com/?app=weather.future&weaid=36&appkey=12897&sign=ad041abb874869a9764b5891234459b3&format=json"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getJsonText(String url) throws IOException {
		if (url == null || url.length() == 0) {
			return "";
		}
		// try {
		// url = URLEncoder.encode(url, "UTF-8");
		// } catch (UnsupportedEncodingException e) {
		// url = URLDecoder.decode(url,"UTF-8");
		// }

		URL u = new URL(url);

		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));
		StringBuilder sBuilder = new StringBuilder();
		String line = "";
		while (null != (line = br.readLine()))
			sBuilder.append(line);
		return sBuilder.toString();
	}

	public void testCode(String str) {
		// 如果字符串中有中文，使用下列代码转码
		try {
			System.out.println(URLEncoder.encode(str, "UTF-8"));
			System.out.println(URLDecoder.decode("%E6%97%A9%E4%B8%8A%E5%A5%BD", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
