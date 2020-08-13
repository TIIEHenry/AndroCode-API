package taokdao.api.event.tags;

import androidx.annotation.NonNull;

import taokdao.api.api_public.R;
import taokdao.api.event.tag.IEventTag;
import taokdao.api.main.IMainContext;
import taokdao.api.ui.window.tabtool.ITabTool;

public class TabToolTag implements IEventTag {
    private final ITabTool tabtool;

    public TabToolTag(@NonNull ITabTool tabtool) {
        this.tabtool = tabtool;
    }

    @NonNull
    @Override
    public String getTag(@NonNull IMainContext main) {
        return main.getString(R.string.event_tabtool_prefix) + "(" + tabtool.getLabel() + ")";
    }

}
