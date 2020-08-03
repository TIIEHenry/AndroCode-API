package taokdao.api.ui.window.tabtool.wrapped;


import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import taokdao.api.data.bean.Properties;
import taokdao.api.setting.preference.base.IPreference;
import taokdao.api.ui.window.tabtool.ITabTool;
import taokdao.api.ui.window.tabtool.callback.TabToolStateObserver;
import taokdao.api.ui.window.tabtool.menu.TabToolMenu;
import taokdao.api.base.annotation.Identifier;
import taokdao.api.base.annotation.relation.MainConstructor;
import taokdao.api.base.fragment.StateFragment;

public class TabTool implements ITabTool {
    @Identifier
    private final String id;
    private final String label;
    private final Drawable icon;
    private final StateFragment fragment;
    private final TabToolStateObserver stateObserver;
    private ArrayList<TabToolMenu> menuList = new ArrayList<>();
    private ArrayList<IPreference<?>> settingList = new ArrayList<>();

    @MainConstructor
    public TabTool(@NonNull Properties properties, Drawable icon, @NonNull StateFragment fragment, @Nullable TabToolStateObserver stateObserver) {
        this.id = properties.id;
        this.label = properties.label;
        this.icon = icon;
        this.fragment = fragment;
        this.stateObserver = stateObserver;
        fragment.setOnPauseObserver(() -> {
            if (getStateObserver() != null)
                getStateObserver().onHide();
        });
        fragment.setOnResumeObserver(() -> {
            if (getStateObserver() != null)
                getStateObserver().onShow();
        });
    }

    public TabTool(@NonNull Properties properties, StateFragment fragment, @Nullable TabToolStateObserver stateObserver) {
        this(properties, null, fragment, stateObserver);
    }

    @NonNull
    @Override
    public String id() {
        return id;
    }

    @NonNull
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Drawable getIcon() {
        return icon;
    }

    @NonNull
    @Override
    public StateFragment getFragment() {
        return fragment;
    }

    @NonNull
    @Override
    public ArrayList<TabToolMenu> getMenuList() {
        return menuList;
    }

    @NonNull
    @Override
    public ArrayList<IPreference<?>> getSettingList() {
        return settingList;
    }

    @Nullable
    @Override
    public TabToolStateObserver getStateObserver() {
        return stateObserver;
    }
}
