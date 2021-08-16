package com.ruoyi.analysis.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 司机售后报表对象 pdd_driver_after
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
public class PddDriverAfter extends BaseEntity
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

    /** 商品ID */
    @Excel(name = "商品ID")
    private String itemId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String itemName;

    /** 商品件数 */
    @Excel(name = "商品件数")
    private String itemNumber;

    /** 商品单价(元) */
    @Excel(name = "商品单价(元)")
    private String itemPrice;

    /** 售后退款件数 */
    @Excel(name = "售后退款件数")
    private String afterRefundsNumber;

    /** 退款金额(不含券) */
    @Excel(name = "退款金额（不含券）")
    private String afterRefundsPrice;

    /** 实际退款比例 */
    @Excel(name = "实际退款比例")
    private String afterRefundsRatio;

    /** 售后原因 */
    @Excel(name = "售后原因")
    private String afterSalesReasons;

    /** 售后类型 */
    @Excel(name = "售后类型")
    private String afterSalesType;

    /** 售后申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "售后申请时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date afterSalesTime;

    /** 售后退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "售后退款时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date afterRefundsTime;

    /** 是否批量退款 */
    @Excel(name = "是否批量退款")
    private String batchRefund;

    /** 退款发起方 */
    @Excel(name = "退款发起方")
    private String refundOriginator;

    /** 司机名称 */
    @Excel(name = "司机名称")
    private String driverName;

    /** 司机手机号 */
    @Excel(name = "司机手机号")
    private String driverPhone;

    /** 送达时间 */
    @Excel(name = "送达时间")
    private String deliveryTime;

    /** 交货失败原因 */
    @Excel(name = "交货失败原因")
    private String deliveryFailureReason;

    /** 站长确认缺货件数 */
    @Excel(name = "站长确认缺货件数")
    private String stationmasterItemNumber;

    /** 运营确认缺货件数 */
    @Excel(name = "运营确认缺货件数")
    private String operateItmeNumber;

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
    private String sorterActualNumber;

    /** 分拣缺货件数 */
    @Excel(name = "分拣缺货件数")
    private String sorterPiecesNumber;

    /** 分拣开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "分拣开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date sorterStartTime;

    /** 服务站上报少货数 */
    @Excel(name = "服务站上报少货数")
    private String serviceStationLessNumber;

    /** 服务站上报破损数 */
    @Excel(name = "服务站上报破损数")
    private String serviceStationPiecesNumber;

    /** 服务站上报多货数 */
    @Excel(name = "服务站上报多货数")
    private String serviceStationManyNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPickUpDate(Date pickUpDate) 
    {
        this.pickUpDate = pickUpDate;
    }

    public Date getPickUpDate() 
    {
        return pickUpDate;
    }
    public void setServiceStationName(String serviceStationName) 
    {
        this.serviceStationName = serviceStationName;
    }

    public String getServiceStationName() 
    {
        return serviceStationName;
    }
    public void setStoreId(String storeId) 
    {
        this.storeId = storeId;
    }

    public String getStoreId() 
    {
        return storeId;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setItemId(String itemId) 
    {
        this.itemId = itemId;
    }

    public String getItemId() 
    {
        return itemId;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setItemNumber(String itemNumber) 
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() 
    {
        return itemNumber;
    }
    public void setItemPrice(String itemPrice) 
    {
        this.itemPrice = itemPrice;
    }

    public String getItemPrice() 
    {
        return itemPrice;
    }
    public void setAfterRefundsNumber(String afterRefundsNumber) 
    {
        this.afterRefundsNumber = afterRefundsNumber;
    }

    public String getAfterRefundsNumber() 
    {
        return afterRefundsNumber;
    }
    public void setAfterRefundsPrice(String afterRefundsPrice) 
    {
        this.afterRefundsPrice = afterRefundsPrice;
    }

    public String getAfterRefundsPrice() 
    {
        return afterRefundsPrice;
    }
    public void setAfterRefundsRatio(String afterRefundsRatio) 
    {
        this.afterRefundsRatio = afterRefundsRatio;
    }

    public String getAfterRefundsRatio() 
    {
        return afterRefundsRatio;
    }
    public void setAfterSalesReasons(String afterSalesReasons) 
    {
        this.afterSalesReasons = afterSalesReasons;
    }

    public String getAfterSalesReasons() 
    {
        return afterSalesReasons;
    }
    public void setAfterSalesType(String afterSalesType) 
    {
        this.afterSalesType = afterSalesType;
    }

    public String getAfterSalesType() 
    {
        return afterSalesType;
    }
    public void setAfterSalesTime(Date afterSalesTime) 
    {
        this.afterSalesTime = afterSalesTime;
    }

    public Date getAfterSalesTime() 
    {
        return afterSalesTime;
    }
    public void setAfterRefundsTime(Date afterRefundsTime) 
    {
        this.afterRefundsTime = afterRefundsTime;
    }

    public Date getAfterRefundsTime() 
    {
        return afterRefundsTime;
    }
    public void setBatchRefund(String batchRefund) 
    {
        this.batchRefund = batchRefund;
    }

    public String getBatchRefund() 
    {
        return batchRefund;
    }
    public void setRefundOriginator(String refundOriginator) 
    {
        this.refundOriginator = refundOriginator;
    }

    public String getRefundOriginator() 
    {
        return refundOriginator;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setDriverPhone(String driverPhone) 
    {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() 
    {
        return driverPhone;
    }
    public void setDeliveryTime(String deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryTime() 
    {
        return deliveryTime;
    }
    public void setDeliveryFailureReason(String deliveryFailureReason) 
    {
        this.deliveryFailureReason = deliveryFailureReason;
    }

    public String getDeliveryFailureReason() 
    {
        return deliveryFailureReason;
    }
    public void setStationmasterItemNumber(String stationmasterItemNumber) 
    {
        this.stationmasterItemNumber = stationmasterItemNumber;
    }

    public String getStationmasterItemNumber() 
    {
        return stationmasterItemNumber;
    }
    public void setOperateItmeNumber(String operateItmeNumber) 
    {
        this.operateItmeNumber = operateItmeNumber;
    }

    public String getOperateItmeNumber() 
    {
        return operateItmeNumber;
    }
    public void setAppealStatus(String appealStatus) 
    {
        this.appealStatus = appealStatus;
    }

    public String getAppealStatus() 
    {
        return appealStatus;
    }
    public void setServiceStationSort(String serviceStationSort) 
    {
        this.serviceStationSort = serviceStationSort;
    }

    public String getServiceStationSort() 
    {
        return serviceStationSort;
    }
    public void setServiceRoute(String serviceRoute) 
    {
        this.serviceRoute = serviceRoute;
    }

    public String getServiceRoute() 
    {
        return serviceRoute;
    }
    public void setSorterName(String sorterName) 
    {
        this.sorterName = sorterName;
    }

    public String getSorterName() 
    {
        return sorterName;
    }
    public void setSorterActualNumber(String sorterActualNumber) 
    {
        this.sorterActualNumber = sorterActualNumber;
    }

    public String getSorterActualNumber() 
    {
        return sorterActualNumber;
    }
    public void setSorterPiecesNumber(String sorterPiecesNumber) 
    {
        this.sorterPiecesNumber = sorterPiecesNumber;
    }

    public String getSorterPiecesNumber() 
    {
        return sorterPiecesNumber;
    }
    public void setSorterStartTime(Date sorterStartTime) 
    {
        this.sorterStartTime = sorterStartTime;
    }

    public Date getSorterStartTime() 
    {
        return sorterStartTime;
    }
    public void setServiceStationLessNumber(String serviceStationLessNumber) 
    {
        this.serviceStationLessNumber = serviceStationLessNumber;
    }

    public String getServiceStationLessNumber() 
    {
        return serviceStationLessNumber;
    }
    public void setServiceStationPiecesNumber(String serviceStationPiecesNumber) 
    {
        this.serviceStationPiecesNumber = serviceStationPiecesNumber;
    }

    public String getServiceStationPiecesNumber() 
    {
        return serviceStationPiecesNumber;
    }
    public void setServiceStationManyNumber(String serviceStationManyNumber) 
    {
        this.serviceStationManyNumber = serviceStationManyNumber;
    }

    public String getServiceStationManyNumber() 
    {
        return serviceStationManyNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pickUpDate", getPickUpDate())
            .append("serviceStationName", getServiceStationName())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("itemType", getItemType())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemNumber", getItemNumber())
            .append("itemPrice", getItemPrice())
            .append("afterRefundsNumber", getAfterRefundsNumber())
            .append("afterRefundsPrice", getAfterRefundsPrice())
            .append("afterRefundsRatio", getAfterRefundsRatio())
            .append("afterSalesReasons", getAfterSalesReasons())
            .append("afterSalesType", getAfterSalesType())
            .append("afterSalesTime", getAfterSalesTime())
            .append("afterRefundsTime", getAfterRefundsTime())
            .append("batchRefund", getBatchRefund())
            .append("refundOriginator", getRefundOriginator())
            .append("driverName", getDriverName())
            .append("driverPhone", getDriverPhone())
            .append("deliveryTime", getDeliveryTime())
            .append("deliveryFailureReason", getDeliveryFailureReason())
            .append("stationmasterItemNumber", getStationmasterItemNumber())
            .append("operateItmeNumber", getOperateItmeNumber())
            .append("appealStatus", getAppealStatus())
            .append("serviceStationSort", getServiceStationSort())
            .append("serviceRoute", getServiceRoute())
            .append("sorterName", getSorterName())
            .append("sorterActualNumber", getSorterActualNumber())
            .append("sorterPiecesNumber", getSorterPiecesNumber())
            .append("sorterStartTime", getSorterStartTime())
            .append("serviceStationLessNumber", getServiceStationLessNumber())
            .append("serviceStationPiecesNumber", getServiceStationPiecesNumber())
            .append("serviceStationManyNumber", getServiceStationManyNumber())
            .toString();
    }
}
