package bran.cupid.www.cupid.config;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class PublicConfig implements Serializable {
    public String mainColor;
    public int bigVersion;
    public int smallVersion;

    public List<TabItem> tabBar;
}
