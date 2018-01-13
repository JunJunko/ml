package org.junko.ml.service.crawler.initData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junko.ml.dao.IStockHistoryDao;
import org.junko.ml.po.StockHistoryPo;
import org.junko.ml.util.SpringContextUtils;

import com.csvreader.CsvReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadHistoryData2DataBase {
	@Test
	public void loadData2DataBase() {
		IStockHistoryDao stockhistory = (IStockHistoryDao) SpringContextUtils.getBean("StockHistoryDaoImpl");

		List<StockHistoryPo> lStockHistoryPo = new ArrayList<StockHistoryPo>();
		for (String filename : getFileList()) {

			StockHistoryPo sho = new StockHistoryPo();

			try {
				CsvReader r = new CsvReader("data/" + filename, ',', Charset.forName("UTF-8"));
				r.readHeaders();
				while (r.readRecord()) {
					sho.setDealDate(r.get(0));
					sho.setStockID(r.get(1).replace("'", ""));
					sho.setHight(BigDecimal.valueOf(Double.valueOf(r.get(3))));
					sho.setOpen(BigDecimal.valueOf(Double.valueOf(r.get(5))));
					sho.setLow(BigDecimal.valueOf(Double.valueOf(r.get(4))));
					lStockHistoryPo.add(sho);
					sho = new StockHistoryPo();
				}
				

				if (lStockHistoryPo.size() > 1000) {
					stockhistory.addStock(lStockHistoryPo);
					log.info(filename);
					lStockHistoryPo.clear();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private List<String> getFileList() {
		File file = new File("data");
		File[] array = file.listFiles();
		List<String> filelist = new ArrayList<String>();

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				filelist.add(array[i].getName());
				// System.out.println(array[i].getName());
			}
		}
		return filelist;

	}

}
