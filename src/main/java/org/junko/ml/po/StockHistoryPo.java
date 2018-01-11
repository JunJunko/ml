package org.junko.ml.po;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component(value="StockHistoryPo")
public class StockHistoryPo {
	
private String StockID;
private String DealDate;
private String StockName;
private BigDecimal Open;
private BigDecimal Hight;
private BigDecimal Low;

}
