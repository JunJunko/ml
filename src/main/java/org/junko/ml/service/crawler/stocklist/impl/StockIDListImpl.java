package org.junko.ml.service.crawler.stocklist.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junko.ml.service.crawler.AbstractWebConnect;
import org.junko.ml.service.crawler.stocklist.IStockList;

import org.junko.ml.constant.ConstantData;

public class StockIDListImpl extends AbstractWebConnect implements IStockList {

	public static void main(String[] args) {
		StockIDListImpl a = new StockIDListImpl();
		System.out.println(a.getStockList());
	}

	public List<String> getStockList() {
		// TODO Auto-generated method stub
		List<String> stocklist = new ArrayList<String>();
		String result = sendGet(ConstantData.STOCK_LIST_WEBSITE_ADDR.getValue(), "gbk");

		String pattern = "<li><a target=\"_blank\".*\\([6]\\d{5}|<li><a target=\"_blank\".*\\([0]\\d{5}";
		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(result);
	
		while (m.find()) {
			stocklist.add(m.group(0).replaceFirst("^.*\\(", ""));
		}

		return stocklist;
	}
	
	
	

}
