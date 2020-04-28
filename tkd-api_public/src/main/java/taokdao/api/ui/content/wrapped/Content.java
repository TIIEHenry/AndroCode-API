package taokdao.api.ui.content.wrapped;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;

import taokdao.api.data.bean.Properties;
import taokdao.api.setting.preference.base.IPreference;
import taokdao.api.ui.content.IContent;
import taokdao.api.ui.content.editor.IEditor;
import taokdao.api.ui.content.menu.ContentMenu;
import taokdao.base.annotation.maintain.LongTerm;
import taokdao.base.annotation.relation.MainConstructor;
import taokdao.base.fragment.StateFragment;

@LongTerm
public class Content implements IContent {
    @NonNull
    public String id;
    @Nullable
    public Drawable icon;
    @NonNull
    public String label;
    @NonNull
    public String path;
    @NonNull
    public StateFragment fragment;
    @NonNull
    public IEditor editor;
    private ArrayList<IPreference<?>> settingList = new ArrayList<>();
    private ArrayList<ContentMenu> menuList = new ArrayList<>();


//    @NonNull
//    public ITabContentLifecycle lifecycle = new TabContentBaseLifecycle();

    @MainConstructor
    public Content(@NonNull Properties properties, @Nullable Drawable icon, @NonNull String path, @NonNull StateFragment fragment, @NonNull IEditor editor) {
        this.id = properties.id;
        this.label = properties.label;
        this.icon = icon;
        this.path = path;
        this.fragment = fragment;
        this.editor = editor;
        fragment.setOnPauseObserver(() -> {
            if (getStateObserver() != null)
                getStateObserver().onHide();
        });
        fragment.setOnResumeObserver(() -> {
            if (getStateObserver() != null)
                getStateObserver().onShow();
        });
    }

    public Content(@NonNull Properties properties, @Nullable Drawable icon, @NonNull File file, @NonNull StateFragment fragment, @NonNull IEditor editor) {
        this(properties, icon, file.getAbsolutePath(), fragment, editor);
        this.label = file.getName();
    }

    public Content(@NonNull Properties properties, @NonNull File file, @NonNull StateFragment fragment, @NonNull IEditor editor) {
        this(properties, null, file.getAbsolutePath(), fragment, editor);
        this.label = file.getName();
    }

    @NonNull
    @Override
    public String id() {
        return id;
    }

    @Nullable
    @Override
    public Drawable getIcon() {
        return icon;
    }

    @NonNull
    @Override
    public String getLabel() {
        return label;
    }

    @NonNull
    @Override
    public String getPath() {
        return path;
    }

    @NonNull
    @Override
    public StateFragment getFragment() {
        return fragment;
    }

    @NonNull
    @Override
    public IEditor getEditor() {
        return editor;
    }

    @NonNull
    @Override
    public ArrayList<ContentMenu> getMenuList() {
        return menuList;
    }

    @NonNull
    @Override
    public ArrayList<IPreference<?>> getSettingList() {
        return settingList;
    }
}
