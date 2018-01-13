package org.junko.ml.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junko.ml.dao.DataBaseDAO;
import org.junko.ml.dao.IStockHistoryDao;
import org.junko.ml.po.StockHistoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository(value="StockHistoryDaoImpl")
@AllArgsConstructor
public class StockHistoryDaoImpl implements IStockHistoryDao {

	@Autowired
	private DataBaseDAO dao;

	public StockHistoryPo selectStock(int id) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		StockHistoryPo stock = session.selectOne("ml/mapper.StockHistoryMapper.findByID", id);
		session.close();
		return stock;
	}

	public List<StockHistoryPo> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		List<StockHistoryPo> stock =  session.selectList("ml/mapper.StockHistoryMapper.findAll");
		session.close();
		return stock;
	}

	public void addStock(StockHistoryPo stock) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.insert("ml/mapper.StockHistoryMapper.insert", stock);
		session.commit();
		session.close();

	}
	
	public void addStock(List<StockHistoryPo> stock) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.insert("ml/mapper.StockHistoryMapper.BatchInsert", stock);
		session.commit();
		session.close();
	}

	public void deleteStock(int id) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.delete("ml/mapper.StockHistoryMapper.delete", id);
		session.commit();
		session.close();

	}

	public void updateStock(StockHistoryPo stock) {
		// TODO Auto-generated method stub
		SqlSession session = dao.getSeesionFactory().openSession();
		session.update("ml/mapper.StockHistoryMapper.update", stock);
		session.commit();
		session.close();
	}

	

}
