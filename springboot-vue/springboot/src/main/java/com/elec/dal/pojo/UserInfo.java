package com.elec.dal.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jinglin
 * @since 2021-09-08
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user name
     */
    private String userName;

    /**
     * user id random id
     */
    private Long userId;

    /**
     * current total scores
     */
    private Long currScores;

    private Date gmtCreate;

    private Date gmtModified;


}
