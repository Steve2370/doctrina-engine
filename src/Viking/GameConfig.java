package Viking;

public class GameConfig {
    private static boolean isDebugEnabled;

    public static boolean isIsDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean isDebugEnabled) {
        GameConfig.isDebugEnabled = isDebugEnabled;
    }
}
