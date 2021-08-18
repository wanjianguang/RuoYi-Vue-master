package com.ruoyi.analysis.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

/**
 * 司机售后报表对象 pdd_driver_after
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
public class PddDriverAfterReport implements Serializable
{
    private static final long serialVersionUID = 1L;
    /** $column.columnComment */
    private Long id;

    /** 提供日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pickUpDate;

    /** 服务站名称 */
    @Excel(name = "服务站名称")
    private String serviceStationName;
    
    /** 门店ID */
    @Excel(name = "门店ID")
    private String storeId;
    
    /** 门店名称 */
    @Excel(name = "门店名称")
    private String storeName;
    
    /** 商品类型 */
    @Excel(name = "商品类型")
    private String itemType;
    
    /** 商品名称 */
    @Excel(name = "商品名称")
    private String itemName;
    
    /** 商品件数 */
    @Excel(name = "商品件数")
    private Long itemNumber;

    /** 商品单价(元) */
    @Excel(name = "商品单价(元)")
    private Double itemPrice;

    /** 售后退款件数 */
    @Excel(name = "售后退款件数")
    private String afterRefundsNumber;

    /** 退款金额(不含券) */
    @Excel(name = "退款金额（不含券）")
    private Double afterRefundsPrice;
    
    /** 售后原因 */
    @Excel(name = "售后原因")
    private String afterSalesReasons;

    /** 售后类型 */
    @Excel(name = "售后类型")
    private String afterSalesType;
    
    /** 售后退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "售后退款时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date afterRefundsTime;
    
    /** 退款发起方 */
    @Excel(name = "退款发起方")
    private String refundOriginator;
    
    /** 司机名称 */
    @Excel(name = "司机名称")
    private String driverName;
    
    /** 交货失败原因 */
    @Excel(name = "交货失败原因")
    private String deliveryFailureReason;
    
    /** 申诉状态 */
    @Excel(name = "申诉状态")
    private String appealStatus;
    
    /** 服务站分拣方式 */
    @Excel(name = "服务站分拣方式")
    private String serviceStationSort;

    /** 团点号/路线名 */
    @Excel(name = "团点号/路线名")
    private String serviceRoute;

    /** 分拣员名称 */
    @Excel(name = "分拣员名称")
    private String sorterName;

    /** 实际分拣件数 */
    @Excel(name = "实际分拣件数")
    private Long sorterActualNumber;

    /** 分拣缺货件数 */
    @Excel(name = "分拣缺货件数")
    private Long sorterPiecesNumber;

    /** 分拣开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "分拣开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date sorterStartTime;

    /** 服务站上报少货数 */
    @Excel(name = "服务站上报少货数")
    private Long serviceStationLessNumber;

    /** 服务站上报破损数 */
    @Excel(name = "服务站上报破损数")
    private Long serviceStationPiecesNumber;

    /** 服务站上报多货数 */
    @Excel(name = "服务站上报多货数")
    private Long serviceStationManyNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getServiceStationName() {
		return serviceStationName;
	}

	public void setServiceStationName(String serviceStationName) {
		this.serviceStationName = serviceStationName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getAfterRefundsNumber() {
		return afterRefundsNumber;
	}

	public void setAfterRefundsNumber(String afterRefundsNumber) {
		this.afterRefundsNumber = afterRefundsNumber;
	}

	public Double getAfterRefundsPrice() {
		return afterRefundsPrice;
	}

	public void setAfterRefundsPrice(Double afterRefundsPrice) {
		this.afterRefundsPrice = afterRefundsPrice;
	}

	public String getAfterSalesReasons() {
		return afterSalesReasons;
	}

	public void setAfterSalesReasons(String afterSalesReasons) {
		this.afterSalesReasons = afterSalesReasons;
	}

	public String getAfterSalesType() {
		return afterSalesType;
	}

	public void setAfterSalesType(String afterSalesType) {
		this.afterSalesType = afterSalesType;
	}

	public Date getAfterRefundsTime() {
		return afterRefundsTime;
	}

	public void setAfterRefundsTime(Date afterRefundsTime) {
		this.afterRefundsTime = afterRefundsTime;
	}

	public String getRefundOriginator() {
		return refundOriginator;
	}

	public void setRefundOriginator(String refundOriginator) {
		this.refundOriginator = refundOriginator;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDeliveryFailureReason() {
		return deliveryFailureReason;
	}

	public void setDeliveryFailureReason(String deliveryFailureReason) {
		this.deliveryFailureReason = deliveryFailureReason;
	}

	public String getAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(String appealStatus) {
		this.appealStatus = appealStatus;
	}

	public String getServiceStationSort() {
		return serviceStationSort;
	}

	public void setServiceStationSort(String serviceStationSort) {
		this.serviceStationSort = serviceStationSort;
	}

	public String getServiceRoute() {
		return serviceRoute;
	}

	public void setServiceRoute(String serviceRoute) {
		this.serviceRoute = serviceRoute;
	}

	public String getSorterName() {
		return sorterName;
	}

	public void setSorterName(String sorterName) {
		this.sorterName = sorterName;
	}

	public Long getSorterActualNumber() {
		return sorterActualNumber;
	}

	public void setSorterActualNumber(Long sorterActualNumber) {
		this.sorterActualNumber = sorterActualNumber;
	}

	public Long getSorterPiecesNumber() {
		return sorterPiecesNumber;
	}

	public void setSorterPiecesNumber(Long sorterPiecesNumber) {
		this.sorterPiecesNumber = sorterPiecesNumber;
	}

	public Date getSorterStartTime() {
		return sorterStartTime;
	}

	public void setSorterStartTime(Date sorterStartTime) {
		this.sorterStartTime = sorterStartTime;
	}

	public Long getServiceStationLessNumber() {
		return serviceStationLessNumber;
	}

	public void setServiceStationLessNumber(Long serviceStationLessNumber) {
		this.serviceStationLessNumber = serviceStationLessNumber;
	}

	public Long getServiceStationPiecesNumber() {
		return serviceStationPiecesNumber;
	}

	public void setServiceStationPiecesNumber(Long serviceStationPiecesNumber) {
		this.serviceStationPiecesNumber = serviceStationPiecesNumber;
	}

	public Long getServiceStationManyNumber() {
		return serviceStationManyNumber;
	}

	public void setServiceStationManyNumber(Long serviceStationManyNumber) {
		this.serviceStationManyNumber = serviceStationManyNumber;
	}

}
