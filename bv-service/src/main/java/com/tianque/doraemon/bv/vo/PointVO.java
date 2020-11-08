package com.tianque.doraemon.bv.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 坐标 出参
 *
 * @author lingyuwang
 * @date 2020-11-08 10:10 下午
 * @since 1.0.4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointVO implements Serializable {

    private static final long serialVersionUID = 4690168572944811337L;

    /**
     * x 轴坐标
     */
    public int x;

    /**
     * y 轴坐标
     */
    public int y;

    /**
     * 秘钥
     */
    private String secretKey;

}
