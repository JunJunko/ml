package org.junko.ml.dao;

import java.util.List;

import org.junko.ml.po.StockHistoryPO;

public interface IStockHistoryDao {

	public StockHistoryPO selectStock(int id);

	public List<StockHistoryPO> selectAll();

	public void addStock(StockHistoryPO stock);
	
	public void addStock(List<StockHistoryPO> stock);

	public void deleteStock(int id);

	public void updateStock(StockHistoryPO stock);

}
