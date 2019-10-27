package bran.cupid.www.cupid.config;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class JsonItem implements Serializable {

    public int type;
    public List<JsonUnit> data;

    public String title;
    public String titleColor;
    public int titleSize;
    public String titleDrawableColor;
    public String moreLink;

    // 宽高
    public int width;
    public int height;

    //渐变背景
    public String backgroundColorFrom;
    public String backgroudColorTo;
}
