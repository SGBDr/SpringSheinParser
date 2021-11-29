package com.example.demo.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
	
	public List<Result> getResult(String precision, double pric){
		List<Result> resultList = new ArrayList<Result>();
		String url = "https://fr.shein.com/Women-Plus-Clothing-c-1888.html?ici=CCCSN=WomenHomePage_ON=Banner_OI=1_CN=categoryall_TI=50000_aod=0_PS=HZ-7-6_ABT=0&scici=WomenHomePage~~ON_Banner,CN_categoryall,HZ_Plus,HI_hotZoner2hha1uyrgi~~7_6~~real_1888~~~~&srctype=homepage&userpath=%3EWomenHomePage%3EWomen-Plus-Clothing";
		Document webPage = null;
		try{
			 webPage = Jsoup.connect(url).get();
		}catch(Exception e){}
		Elements elements = webPage.getElementsByTag("section");
		for(Element el : elements) {
			if(el.getElementsByTag("div").size() != 0) {
				String link = el.getElementsByTag("div").get(0).getElementsByTag("a").attr("href");
				String image = el.getElementsByTag("div").get(0).getElementsByTag("img").attr("data-src");
				String name = el.getElementsByTag("div").get(1).getElementsByTag("a").text();
				String price = "";
				boolean go = true;
				String temp = "";
				try {
					temp = Jsoup.connect("https://fr.shein.com" + link).get().toString();
				} catch (IOException e) {
					e.printStackTrace();
				}
				for(int i = temp.indexOf("amountWithSymbol") + 20; go; i++) {
					if(temp.charAt(i) == '"')go = false;
					else price += temp.charAt(i);
				}
				resultList.add(new Result(image, price, name, link));
			}
			if(resultList.size() == 100)break;
		}
		return resultList;
	}
	
}
