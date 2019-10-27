package bran.cupid.www.cupid.config;

import java.io.Serializable;

/**
 * 作者: bran
 * 日期: 2019/10/27 0027
 * 描述：
 */
public class JsonUnit implements Serializable {
    public String title;
    public String subTitle;
    public String imgUrl;
    public String linkUrl;
    public String tag;
    public String detail;

    public String pageType;     // html/native
    public String login;        // 1/0


}
