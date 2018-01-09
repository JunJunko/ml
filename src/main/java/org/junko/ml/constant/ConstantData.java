package org.junko.ml.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ConstantData {
	
	STOCK_LIST_WEBSITE_ADDR("http://quote.eastmoney.com/stocklist.html"),
	HISTTORY_DATA_DOWNLOAD_ADDR("http://quotes.money.163.com/trade/lsjysj_${para}.html");

	@Getter
	private String value;
}
