package org.junko.ml.dao;

import java.util.List;

import org.junko.ml.bo.StockCirculationCycleBo;

public interface IStockCirculationCycleDao  {
	public List<StockCirculationCycleBo> selectAll();

	public void addStock(List<StockCirculationCycleBo> stock);
	
	public void addStock(StockCirculationCycleBo stock);

}
