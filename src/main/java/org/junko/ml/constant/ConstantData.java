package org.junko.ml.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ConstantData {
	
	SH_STOCK_LIST_WEBSITE_ADDR("http://quote.eastmoney.com/stocklist.html#sh"),
	SZ_STOCK_LIST_WEBSITE_ADDR("http://quote.eastmoney.com/stocklist.html#sz");

	@Getter
	private String value;
}
