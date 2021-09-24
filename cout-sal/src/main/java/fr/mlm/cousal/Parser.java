package fr.mlm.cousal;

import java.net.URLEncoder;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Parser {

	public static void main(String[] args) {
		String searchQuery = "Iphone 6s" ;

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		HtmlPage page =null;
		try {
			String searchUrl = "https://newyork.craigslist.org/search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
			page = client.getPage(searchUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']") ;
		if(items.isEmpty()){
		  System.out.println("No items found !");
		}else{
		for(HtmlElement item : items){
		  HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//p[@class='result-info']/a"));

		  HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//a/span[@class='result-price']")) ;
							
		  String itemName = itemAnchor.asText();
		  String itemUrl =  itemAnchor.getHrefAttribute();

		  // It is possible that an item doesn't have any price
		  String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;
					
		  System.out.println( String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
		  }
		}
	}
}
