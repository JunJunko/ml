package org.junko.ml.service.crawler.initData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junko.ml.bo.StockCirculationCycleBo;
import org.junko.ml.constant.ConstantData;
import org.junko.ml.service.crawler.AbstractWebConnect;
import org.junko.ml.service.crawler.stocklist.IStockList;
import org.junko.ml.service.crawler.stocklist.impl.StockIDListImpl;

public class InitStockHistoryDataTest extends AbstractWebConnect {

	public StockCirculationCycleBo getStartDataAndEndData() {

		IStockList sl = new StockIDListImpl();

		for (String id : sl.getStockList()) {
			sendGet(ConstantData.HISTTORY_LIST_DOWNLOAD_ADDR.getValue().replace("${para}", id));
		}

		return null;

	}

	@Test
	public void test() {
		List<StockCirculationCycleBo> scl = new ArrayList<StockCirculationCycleBo>();
		StockCirculationCycleBo sc = new StockCirculationCycleBo();
		String pattern = "name=\"date_[a-z]{3,5}_type\" value=\"\\d{4}-\\d{2}-\\d{2}\"";
		Pattern r = Pattern.compile(pattern);
		Matcher m;
		String result = sendGet(ConstantData.HISTTORY_LIST_DOWNLOAD_ADDR.getValue().replace("${para}", "600004"));
		m = r.matcher(result);
		while (m.find()) {
			String[] t = m.group().split("=");
			sc.setStockID("600004");
			if ("date_start_type".equals(t[1].replace(" value", "").replace("\"", ""))) {
				sc.setStartDate(t[2].replace("\"", ""));
			} else {
				sc.setEndDate(t[2].replace("\"", ""));
			}

			scl.add(sc);
//			sc = new StockCirculationCycleBo();
			System.out.println(m.group());
		}
		System.out.println(sc);

	}

}
