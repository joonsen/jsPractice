package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlEx {

	public static void main(String[] args) {
		String domain = "http://192.168.219.140:8888/web-2022-08/index.jsp";
		try {
			URL url = new URL(domain);
			InputStream is = url.openStream();	
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);	//cpu가 일끝내고 딴일할수 있도록 버퍼를~~ data를 한번에 엔터키까지 읽어낼수 있는 버퍼스트림
			String data = "";
//			while( (data = br.readLine()) != null ) {
//				
//			}
			while(true) {
				data = br.readLine();
				if(data == null) break;
				System.out.println(data);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
