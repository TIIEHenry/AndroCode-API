package androcode.api.setting.preference.base;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androcode.api.bean.Properties;
import androcode.base.annotation.relation.MainConstructor;

public abstract class OppositeStatePreference implements IOppositeStatePreference {

    private final String id;
    private final Drawable icon;
    private final String title;
    private final String description;
    private final SharedPreferences sharedPreferences;
    private final Listener listener;
    private final boolean defaultValue;
    private IGroupPreference group;
    private boolean enable = true;

    @MainConstructor
    public OppositeStatePreference(@NonNull SharedPreferences sharedPreferences, boolean defaultValue, @NonNull Properties properties, Drawable icon, Listener listener) {
        this.sharedPreferences = sharedPreferences;
        this.defaultValue = defaultValue;
        this.id = properties.id;
        this.title = properties.label;
        this.description = properties.des;
        this.icon=icon;
        this.listener = listener;
    }

    public OppositeStatePreference(@NonNull SharedPreferences sharedPreferences, boolean defaultValue,@NonNull Properties properties, Listener listener) {
        this(sharedPreferences, defaultValue, properties,null, listener);
    }


    @Override
    public void saveValue(@NonNull Boolean value) {
        sharedPreferences.edit().putBoolean(getIdWithGroup(), value).apply();
    }

    @NonNull
    @Override
    public Boolean loadValue() {
        return sharedPreferences.getBoolean(getIdWithGroup(), defaultValue);
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
    public void setGroup(IGroupPreference group) {
        this.group = group;
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
    public void on() {
        onToggle(true);
    }

    @Override
    public void off() {
        onToggle(false);
    }


    @Override
    public void onToggle(boolean isOn) {
        saveValue(isOn);
        if (listener != null)
            listener.onToggle(isOn);
    }

}
