package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * @author 119178
 * @description 速度限制
 * @date 2021/3/11
 */
public class NET_SPEED_LIMIT extends SdkStructure {
    /**
     * 速度上限
     */
    public int nSpeedUpperLimit;
    /**
     * 速度下限
     */
    public int nSpeedLowerLimit;
}
