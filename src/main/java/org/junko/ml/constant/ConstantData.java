package org.junko.ml.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ConstantData {
	
	STOCK_LIST_WEBSITE_ADDR("http://quote.eastmoney.com/stocklist.html"),
	HISTTORY_LIST_DOWNLOAD_ADDR("http://quotes.money.163.com/trade/lsjysj_${para}.html"),
	DOWNlOAD_SCV_ADDR("http://quotes.money.163.com/service/chddata.html?code=${id}&start=${start}&end=${end}&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;");

	@Getter
	private String value;
}
