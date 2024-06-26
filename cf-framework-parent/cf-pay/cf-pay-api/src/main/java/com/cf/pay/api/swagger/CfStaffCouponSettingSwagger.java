package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.CfStaffCouponSettingForm;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"员工发放优惠券设置"})
public interface CfStaffCouponSettingSwagger {

    @ApiOperation(value = "添加员工发放优惠券设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    ResponseResult employerAddStaffCouponSetting(CfStaffCouponSettingForm cfStaffCouponSettingForm) throws Exception;

    @ApiOperation(value = "更新员工发放优惠券设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    ResponseResult employerUpdateStaffCouponSetting(CfStaffCouponSettingForm cfStaffCouponSettingForm) throws Exception;

    @ApiOperation(value = "获取员工发放优惠券设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    ResponseResult getStaffCouponSettingByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) throws Exception;

}
