package taokdao.api.setting.preference.wrapped;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tencent.mmkv.MMKV;

import taokdao.api.data.bean.Properties;
import taokdao.api.setting.preference.ITextPreference;
import taokdao.api.setting.preference.base.IGroupPreference;
import taokdao.base.annotation.relation.MainConstructor;


public class TextPreference implements ITextPreference {

    private final String id;
    private final Drawable icon;
    private final String title;
    private final String description;
    private final MMKV mmkv;
    private final Listener listener;
    private final String defaultValue;
    private IGroupPreference group;
    private boolean enable = true;
    private boolean idUseGroup = true;

    @MainConstructor
    public TextPreference(@NonNull MMKV mmkv, @NonNull String defaultValue, @NonNull Properties properties, Drawable icon, Listener listener) {
        this.mmkv = mmkv;
        this.defaultValue = defaultValue;
        this.id = properties.id;
        this.title = properties.label;
        this.description = properties.des;
        this.icon = icon;
        this.listener = listener;
    }


    public TextPreference(@NonNull MMKV mmkv, @NonNull String defaultValue, @NonNull Properties properties, Listener listener) {
        this(mmkv, defaultValue, properties, null, listener);
    }

    @NonNull
    @Override
    public String loadValue() {
        return mmkv.getString(getIdWithGroup(), defaultValue);
    }

    @Override
    public void saveValue(String value) {
        mmkv.edit().putString(getIdWithGroup(), value).apply();
    }

    @NonNull
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Nullable
    @Override
    public String getDescription() {
        return description;
    }

    @Nullable
    @Override
    public IGroupPreference getGroup() {
        return group;
    }

    @Override
    public void setGroup(@NonNull IGroupPreference group) {
        this.group = group;
    }

    @Override
    public boolean isIdUseGroup() {
        return idUseGroup;
    }

    @Override
    public void setIdUseGroup(boolean idUseGroup) {
        this.idUseGroup = idUseGroup;
    }

    @Override
    public void enable() {
        enable = true;
    }

    @Override
    public void disable() {
        enable = false;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @NonNull
    @Override
    public String id() {
        return id;
    }


    @Override
    public void onChanged(@NonNull String text) {
        saveValue(text);
        if (listener != null)
            listener.onChanged(text);
    }

}
