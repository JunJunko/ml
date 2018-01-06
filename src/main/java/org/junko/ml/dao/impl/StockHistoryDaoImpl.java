package org.junko.ml.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junko.ml.dao.IStockHistoryDao;
import org.junko.ml.po.StockHistoryPO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockHistoryDaoImpl implements IStockHistoryDao {

	private SqlSessionFactory sqlSessionFactory;

	public StockHistoryPO selectStock(int id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		StockHistoryPO stock = session.selectOne("ml/mapper.StockHistoryMapper.findByID", id);
		session.close();
		return stock;
	}

	public List<StockHistoryPO> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		List<StockHistoryPO> stock =  session.selectList("ml/mapper.StockHistoryMapper.findAll");
		session.close();
		return stock;
	}

	public void addStock(StockHistoryPO stock) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("ml/mapper.StockHistoryMapper.insert", stock);
		session.commit();
		session.close();

	}
	
	public void addStock(List<StockHistoryPO> stock) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("ml/mapper.StockHistoryMapper.BatchInsert", stock);
		session.commit();
		session.close();
	}

	public void deleteStock(int id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("ml/mapper.StockHistoryMapper.delete", id);
		session.commit();
		session.close();

	}

	public void updateStock(StockHistoryPO stock) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.update("ml/mapper.StockHistoryMapper.update", stock);
		session.commit();
		session.close();
	}

	

}
