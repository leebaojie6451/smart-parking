package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.ucenter.request.CfAuthForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Pattern;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/10/010 23:06
 * @Version 1.0
 **/
@Api(tags = {"用户权限"})
public interface AuthSwagger {
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content-type", value = "请求方式", required = true, paramType = "header", dataType = "string", defaultValue = "application/json;charset=UTF-8")
    })
    public ResponseResult login(LoginRequest loginRequest) throws Exception;

    @ApiOperation("退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "type", value = "方式(all-当前用户所有客户端都退出登录/current-只退出当前客户端)", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult logout(String type) throws Exception;

    @ApiOperation(value = "获取权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "type", value = "类型(user-将标识用户所拥有的权限/role-将标识角色所拥有的权限)", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "value", value = "值(若type参数为user则该值表示用户id，否则表示为角色id)", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult getAuths(
            @RequestParam(value = "type", required = false)
            @Pattern(regexp = "^(user|role){1}$", message = "暂时只支持user|role两种类型") String type, String value);

    @ApiOperation(value = "添加权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string")
    })
    public ResponseResult addAuth(@Validated CfAuthForm cfAuthForm);

    @ApiOperation(value = "更新权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string")
    })
    public ResponseResult updateAuth(@Validated CfAuthForm cfAuthForm);

    @ApiOperation(value = "删除权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string")
    })
    public ResponseResult deleteAuth(String id);

    @ApiOperation(value = "根据角色id获取获取角色权限路径")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult getAuthPathByRoleId(String roleId);

    @ApiOperation(value = "根据角色id获取获取完整的父子权限-带前端路由")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "jwt串(请加\"Bearer \"前缀，注意有空格)", required = true, paramType = "header", dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult getFullAuthsByRoleId(String roleId);
}
