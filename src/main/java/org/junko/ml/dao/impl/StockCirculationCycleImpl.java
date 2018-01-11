package org.junko.ml.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junko.ml.bo.StockCirculationCycleBo;
import org.junko.ml.dao.DataBaseDAO;
import org.junko.ml.dao.IStockCirculationCycleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository(value = "StockCirculationCycleImpl")
@AllArgsConstructor
public class StockCirculationCycleImpl implements IStockCirculationCycleDao {

	@Autowired
	private DataBaseDAO dao;

	@Override
	public List<StockCirculationCycleBo> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		List<StockCirculationCycleBo> stock = session.selectList("ml/mapper.StockCirculationCycleMapper.findAll");
		session.close();
		return stock;
	}

	@Override
	public void addStock(List<StockCirculationCycleBo> stock) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.insert("ml/mapper.StockCirculationCycleMapper.BatchInsert", stock);
		session.commit();
		session.close();
	}

	@Override
	public void addStock(StockCirculationCycleBo stock) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.insert("ml/mapper.StockCirculationCycleMapper.Insert", stock);
		session.commit();
		session.close();
	}

}
