package bran.cupid.www.cupid.config;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class JsonFile implements Serializable {

    public static final String HomePage = "homePage";
    public static final String FindPage = "findPage";
    public static final String MinePage = "minePage";
//
//    // 布局类型
    public static final int HEADER = 0;
    public static final int FOOTER = 1;
    public static final int BANNER = 2;


    public List<JsonItem> homeFragment;
    public List<JsonItem> findFragment;
    public List<JsonItem> mineFragment;
    public PublicConfig pubConfig;
}
