package androcode.api.tabpager;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public interface ITabPager {
    String getTitle();

    Drawable getIcon();

    Fragment getFragment();

    ArrayList<TabPagerMenu> getStartMenuList();

    ArrayList<TabPagerMenu> getEndMenuList();

}
