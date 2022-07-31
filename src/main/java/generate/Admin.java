package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * admin
 * @author 
 */
@Data
public class Admin implements Serializable {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像地址
     */
    private String avatar;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 删除时间
     */
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
}