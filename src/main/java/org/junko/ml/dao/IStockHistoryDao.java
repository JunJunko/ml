package org.junko.ml.dao;

import java.util.List;

import org.junko.ml.po.StockHistoryPo;

public interface IStockHistoryDao {

	public StockHistoryPo selectStock(int id);

	public List<StockHistoryPo> selectAll();

	public void addStock(StockHistoryPo stock);
	
	public void addStock(List<StockHistoryPo> stock);

	public void deleteStock(int id);

	public void updateStock(StockHistoryPo stock);

}
