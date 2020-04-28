package taokdao.api.event.senders;

import androidx.annotation.NonNull;

import taokdao.api.event.sender.IEventSender;
import taokdao.api.event.sender.wrapped.EventSender;
import taokdao.api.event.tags.TabToolTag;
import taokdao.api.ui.window.tabtool.ITabTool;


public class TabToolSender {
    private final ITabTool tabTool;

    public TabToolSender(@NonNull ITabTool tabTool) {
        this.tabTool = tabTool;
    }

    public IEventSender saveSuccess(@NonNull String path) {
        return new EventSender(new TabToolTag(tabTool), path + ": saved");
    }

    public IEventSender saveFailed(@NonNull String path) {
        return new EventSender(new TabToolTag(tabTool), path + ": saveFailed");
    }

    public IEventSender message(@NonNull String message) {
        return new EventSender(new TabToolTag(tabTool), "Message: " + message);
    }


//    public IEventSender open(@NonNull String path) {
//        return main -> main.send(new TabContentTag(tabContent), path + ": saved");
//    }

}
