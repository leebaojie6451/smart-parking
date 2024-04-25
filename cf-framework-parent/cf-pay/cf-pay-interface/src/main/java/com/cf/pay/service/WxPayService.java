package com.cf.pay.service;

import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.response.ResultMap;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 微信支付
 *
 * @ClassName WxPayService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/4/004 8:45
 * @Version 1.0
 **/
public interface WxPayService {

    /**
     * @param orderNo:             订单编号
     * @param amount:              实际支付金额
     * @param body:                订单描述
     * @param ip:                  终端ip
     * @param openid:              openid
     * @param cfUserPaymentAgency: cfUserPaymentAgency
     * @return
     * @Description: 微信支付统一下单
     */
    ResultMap unifiedOrder(String orderNo, double amount, String body, String ip, String openid, CfUserPaymentAgency cfUserPaymentAgency) throws Exception;

    /**
     * @param notifyStr: 微信异步通知消息字符串
     * @return
     * @Description: 订单支付异步通知
     */
    String notify(String notifyStr) throws Exception;

    /**
     * @param orderNo:      订单编号
     * @param totalFee:     总金额
     * @param amount:       实际支付金额
     * @param refundReason: 退款原因
     * @return
     * @Description: 退款
     */
    ResultMap refund(String orderNo, BigDecimal totalFee, BigDecimal amount, String refundReason) throws Exception;

    /**
     * @param notifyStr: 微信异步通知消息字符串
     * @return
     * @Description: 易生支付订单支付异步通知
     */
    String yiShengNotify(String notifyStr) throws Exception;

    /**
     * @param notifyMap: 微信异步通知数据
     * @return
     * @Description: 光大银行哆啦宝支付订单支付异步通知
     */
    String duoLaBaoNotify(Map<String, String> notifyMap) throws Exception;

}
