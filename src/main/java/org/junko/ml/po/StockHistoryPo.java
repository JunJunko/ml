package org.junko.ml.po;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StockHistoryPo {
	
private String StockID;
private String DealDate;
private String StockName;
private BigDecimal Open;
private BigDecimal Hight;
private BigDecimal Low;

}
