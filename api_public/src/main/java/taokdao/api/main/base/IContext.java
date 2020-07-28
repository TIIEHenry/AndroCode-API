package taokdao.api.main.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;

public interface IContext extends IDisplay {

    Resources getResources();

    Context getContext();

    /**
     * 资源类
     */
    Drawable getDrawable(int id);

    String getString(int id);

    int getAttrColor(int id);

    int getDimen(int id);

    LayoutInflater getLayoutInflater();


    void startActivity(@RequiresPermission Intent intent);

    void startActivity(@RequiresPermission Intent intent,
                       @Nullable Bundle options);

    default float dp2px(float dpValue) {
        return (dpValue * getResources().getDisplayMetrics().density + 0.5f);
    }

    default float sp2px(float spValue) {
        return (spValue * getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    default float px2dp(float pxValue) {
        return (pxValue / getResources().getDisplayMetrics().density + 0.5f);
    }


    default float px2sp(float pxValue) {
        return (pxValue / getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
}