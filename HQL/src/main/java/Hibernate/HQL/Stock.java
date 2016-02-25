package Hibernate.HQL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock implements Serializable{

	/**
	 * Serial Verison UID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Stock Id
	 */
	@Id
	@Column(name="STOCK_ID",nullable = false)
	private Integer stockId;
	
	/**
	 * Stock Code
	 */
	@Column(name="STOCK_CODE")
	private String stockCode;
	
	/**
	 * Stock Name
	 */
	@Column(name="STOCK_NAME")
	private String stockName;

	/**
	 *  Default Constructor
	 */
	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.setStockCode(stockCode);
		this.setStockName(stockName);
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


}
