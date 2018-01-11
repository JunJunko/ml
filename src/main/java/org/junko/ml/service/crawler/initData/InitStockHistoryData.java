package org.junko.ml.service.crawler.initData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junko.ml.bo.StockCirculationCycleBo;
import org.junko.ml.constant.ConstantData;
import org.junko.ml.dao.DataBaseDAO;
import org.junko.ml.dao.IStockCirculationCycleDao;
import org.junko.ml.service.crawler.AbstractWebConnect;
import org.junko.ml.service.crawler.stocklist.IStockList;
import org.junko.ml.service.crawler.stocklist.impl.StockIDListImpl;
import org.junko.ml.util.SpringContextUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitStockHistoryData extends AbstractWebConnect {

	private void getStartDataAndEndData() {

		IStockList sl = new StockIDListImpl();
		String pattern = "name=\"date_[a-z]{3,5}_type\" value=\"\\d{4}-\\d{2}-\\d{2}\"";
		Pattern r = Pattern.compile(pattern);
		Matcher m;
		List<StockCirculationCycleBo> scl = new ArrayList<StockCirculationCycleBo>();
		StockCirculationCycleBo sc = new StockCirculationCycleBo();
		for (String id : sl.getStockList()) {
			String result = sendGet(ConstantData.HISTTORY_LIST_DOWNLOAD_ADDR.getValue().replace("${para}", id));
			m = r.matcher(result);
			while (m.find()) {
				String[] t = m.group().split("=");
				sc.setStockID(id);
				if ("date_start_type".equals(t[1].replace(" value", "").replace("\"", ""))) {
					sc.setStartDate(t[2].replace("\"", ""));
				} else {
					sc.setEndDate(t[2].replace("\"", ""));
				}

			}
			scl.add(sc);
			sc = new StockCirculationCycleBo();
			if (scl.size() == 100) {
				putInitStockData2DataBase(scl);
				log.info("add recorde");
				scl.clear();
			}

			// sc = new StockCirculationCycleBo();
			// log.info("data base add recorde "+scl);
		}

	}

	public void putInitStockData2DataBase(List<StockCirculationCycleBo> scl) {
		IStockCirculationCycleDao stockcirculationcycle = (IStockCirculationCycleDao) SpringContextUtils
				.getBean("StockCirculationCycleImpl");
		stockcirculationcycle.addStock(scl);
	}

	public static void main(String[] args) {
		InitStockHistoryData a = new InitStockHistoryData();

		a.getStartDataAndEndData();
		
	}

}
