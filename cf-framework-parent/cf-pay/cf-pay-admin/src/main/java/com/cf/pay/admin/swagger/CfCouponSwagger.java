package com.cf.pay.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.CfCouponForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"优惠券管理"})
public interface CfCouponSwagger {

    @ApiOperation(value = "根据条件查询优惠券数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "conditions",
                    value = "条件,例子{\"id\":{\"operator\":\"=\",\"value\":200},\"province_id\":{\"operator\":\"between\",\"min\":200,\"max\":300},\"order\":" +
                            "{\"operator\":\"order\",\"list\":{\"id\":{\"type\":\"DESC\",\"alias\":\"cp\"},\"country_id\":{\"type\":\"ASC\",\"alias\":\"cp\"}}}," +
                            "\"limit\":{\"operator\":\"limit\",\"page\":1,\"limit\":10},\"like\":{\"operator\":\"like\",\"list\":{\"name\":{\"0\":{\"value\":\"绿地国博\"," +
                            "\"alias\":\"cp\"},\"1\":{\"value\":\"财富中心\",\"alias\":\"cp\"}},\"country_id\":{\"0\":{\"value\":\"1111\",\"alias\":\"cp\"},\"1\":{\"value\":\"2222\"," +
                            "\"alias\":\"cp\"}}}}}解析出的sql为：SELECT cp.* FROM cf_car_park cp WHERE cp.id=200 AND cp.province_id>=200 AND cp.province_id<=300 AND (cp.name LIKE '%绿地国博%'" +
                            " OR cp.name LIKE '%财富中心%')  AND (cp.country_id LIKE '%1111%' OR cp.country_id LIKE '%2222%') ORDER BY cp.id DESC,cp.country_id ASC LIMIT 0,10",
                    required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "scenes", value = "场景(parking-停车/charging-充电)", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult selectListByCondition(String conditions, String scenes) throws Exception;

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    public ResponseResult add(CfCouponForm cfCouponForm);

    @ApiOperation(value = "更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    public ResponseResult update(CfCouponForm cfCouponForm);

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "lang", value = "语言(zh-中文[默认]/en-英文...更多见官网文档)", required = false, paramType = "header", dataType = "string")
    })
    public ResponseResult delete(String id);

}
