package org.junko.ml.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBaseDAO {
	volatile static SqlSessionFactory sqlSessionFactory;
	
	private static SqlSessionFactory init(){
		String resource = "mybatis-config.xml";           // 定位核心配置文件
        InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory; 
	}
	
	public SqlSessionFactory getSeesionFactory(){
		if(sqlSessionFactory == null){
			sqlSessionFactory = init();
		}
		return sqlSessionFactory;
		
	}

}
