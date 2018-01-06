package org.junko.ml;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junko.ml.dao.impl.StockHistoryDaoImpl;
import org.junko.ml.po.StockHistoryPO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

/**
 * Unit test for simple App.
 */

@Slf4j
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {System.out.println(System.getProperty("user.dir"));
        assertTrue( true );
        String resource = "mybatis-config.xml";           // 定位核心配置文件
        InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory

//        SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession
        
        
        List<StockHistoryPO> a = new ArrayList<StockHistoryPO>();
        StockHistoryPO shp = new StockHistoryPO();
        shp.setStockID(1);
        shp.setStockName("test");
        shp.setOpen(BigDecimal.valueOf(1.14));
        shp.setHight(BigDecimal.valueOf(2.14));
        shp.setLow(BigDecimal.valueOf(0.14));
        a.add(shp);
        
        shp = new StockHistoryPO();
        
        shp.setStockID(2);
        shp.setStockName("test2");
        shp.setOpen(BigDecimal.valueOf(1.14));
        shp.setHight(BigDecimal.valueOf(2.14));
        shp.setLow(BigDecimal.valueOf(0.14));
        
        a.add(shp);
        
        StockHistoryDaoImpl s = new StockHistoryDaoImpl(sqlSessionFactory);
        s.addStock(a);
    }
}
