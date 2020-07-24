package taokdao.api.ui.window.explorer;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import taokdao.api.data.bean.IProperties;
import taokdao.api.setting.preference.base.IPreference;
import taokdao.api.ui.window.explorer.menu.ExplorerMenu;
import taokdao.base.fragment.StateFragment;

public interface IExplorer extends IProperties {

    String getDropDownLabel();

    @Nullable
    @Override
    default String getDescription() {
        return null;
    }

    @Nullable
    Drawable getIcon();

    @Nullable
    Drawable getDropDownIcon();

    @NonNull
    StateFragment getFragment();

    @NonNull
    ArrayList<ExplorerMenu> getMenuList();

    @NonNull
    ArrayList<IPreference<?>> getSettingList();

    @Nullable
    default ExplorerStateObserver getStateObserver() {
        return null;
    }

}
