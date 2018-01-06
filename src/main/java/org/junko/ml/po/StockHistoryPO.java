package org.junko.ml.po;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StockHistoryPO {
	
private Integer StockID;
private String StockName;
private BigDecimal Open;
private BigDecimal Hight;
private BigDecimal Low;

}
