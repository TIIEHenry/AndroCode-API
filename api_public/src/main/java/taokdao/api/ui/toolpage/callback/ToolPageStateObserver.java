package taokdao.api.ui.toolpage.callback;

import taokdao.api.base.annotation.maintain.LongTerm;

@LongTerm
public interface ToolPageStateObserver {
    /**
     * 显示
     */
    void onShow();

    /**
     * 隐藏
     */
    void onHide();

    /**
     * 正在添加，还未添加进去
     */
    void onAdding();

    /**
     * 被移除，已经移除
     */
    void onRemoved();
}
