package taokdao.api.builder;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import taokdao.api.data.bean.IProperties;
import taokdao.api.main.IMainActivity;

/**
 * 构建选项
 *
 * @param <I> 类型Project或File 对应构建Project和File
 */
public interface IBuildOption<I> extends IProperties, IBuildCallback<I> {

    @Nullable
    Drawable getIcon();

    @NonNull
    String getLabel();


    default boolean onBuild(IMainActivity main, I config) {
        return onBuild(main, config, this);
    }
}
