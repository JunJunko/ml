package org.junko.ml.bo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;


@ToString
@EqualsAndHashCode
public class UrlConfig {
	
	@Getter
	private static final String StockListWebSiteAddr = "http://quote.eastmoney.com/stocklist.html";
	

	private String HistorDataDownloadAddr;
	
	
	public String getHistoryListDownloadAddr() {
		return HistorDataDownloadAddr;
	}
	
	public void setHistoryListDownloadAddr(@NonNull String StockId) {
		HistorDataDownloadAddr = "http://quotes.money.163.com/trade/lsjysj_"+StockId+".html";
	}
	
	
}
