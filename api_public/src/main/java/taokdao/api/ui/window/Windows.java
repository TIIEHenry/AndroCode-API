package taokdao.api.ui.window;

public enum Windows {
    //各种drawer
    EXPLORER("START"), END("END"),
    TOP("TOP"), TOOL_PAGES("BOTTOM");

    public String name;
    public IWindow window;

    Windows(String name) {
        this.name = name;
    }

    public static void hideAll() {
        for (Windows value : values()) {
            if (value.window != null) {
                value.window.hideWindow();
            }
        }
    }

    public static void showAll() {
        for (Windows value : values()) {
            if (value.window != null) {
                value.window.showWindow();
            }
        }
    }

    public static boolean isAnyDrawerShow() {
        for (Windows value : values()) {
            if (value.window != null) {
                if (value.window.isWindowShown())
                    return true;
            }
        }
        return false;
    }

    public static void clear() {
        for (Windows value : values()) {
            value.window = null;
        }
    }
}
