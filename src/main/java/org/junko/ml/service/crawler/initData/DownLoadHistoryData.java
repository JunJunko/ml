package org.junko.ml.service.crawler.initData;

import java.util.List;

import org.junko.ml.bo.StockCirculationCycleBo;
import org.junko.ml.constant.ConstantData;
import org.junko.ml.dao.IStockCirculationCycleDao;
import org.junko.ml.po.StockHistoryPo;
import org.junko.ml.service.crawler.AbstractWebConnect;
import org.junko.ml.util.SpringContextUtils;

public class DownLoadHistoryData extends AbstractWebConnect {

	public StockHistoryPo getStockCsv() {
		IStockCirculationCycleDao stock = (IStockCirculationCycleDao) SpringContextUtils
				.getBean("StockCirculationCycleImpl");
		List<StockCirculationCycleBo> stockList = stock.selectAll();
		for (StockCirculationCycleBo s : stockList) {
			String url = ConstantData.DOWNlOAD_SCV_ADDR.getValue().replace("${id}", s.getStockID())
					.replace("${start}", s.getStartDate().replace("-", ""))
					.replace("${end}", s.getEndDate().replace("-", ""));
			saveUrlAs(url, "data/"+s.getStockID()+".cvs");
		}

		return null;

	}

	public static void main(String[] args) {
		DownLoadHistoryData a = new DownLoadHistoryData();
		/*saveUrlAs(
				"http://quotes.money.163.com/service/chddata.html?code=0600004&start=20030424&end=20180111&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP",
				"test.txt");*/
		a.getStockCsv();
	}
}
