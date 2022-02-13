package pojo;

import java.util.List;

/**
 * 通知正文的结构
 */
public class notice {
    // 一级标题
    List<String> headingLevel1;
    // 二级标题
    List<String> headingLevel2;

    public List<String> getHeadingLevel1() {
        return headingLevel1;
    }

    public void setHeadingLevel1(List<String> headingLevel1) {
        this.headingLevel1 = headingLevel1;
    }

    public List<String> getHeadingLevel2() {
        return headingLevel2;
    }

    public void setHeadingLevel2(List<String> headingLevel2) {
        this.headingLevel2 = headingLevel2;
    }
}
