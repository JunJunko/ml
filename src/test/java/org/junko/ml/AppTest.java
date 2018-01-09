package org.junko.ml;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junko.ml.bo.StockCirculationCycleBo;
import org.junko.ml.dao.DataBaseDAO;
import org.junko.ml.dao.IStockCirculationCycleDao;
import org.junko.ml.dao.impl.StockCirculationCycleImpl;
import org.junko.ml.dao.impl.StockHistoryDaoImpl;
import org.junko.ml.po.StockHistoryPo;

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
        List<StockCirculationCycleBo> scl = new ArrayList<StockCirculationCycleBo>();
        StockCirculationCycleBo sc = new StockCirculationCycleBo();
        sc.setStockID("1");
        sc.setStartDate("");
        sc.setEndDate("");
        scl.add(sc);
        
		DataBaseDAO database = new DataBaseDAO();

		IStockCirculationCycleDao stockcirculationcycle = new StockCirculationCycleImpl(database.getSeesionFactory());

        stockcirculationcycle.addStock(scl);
    }
}
