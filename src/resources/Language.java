package resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private static Language language;
    private ResourceBundle resourceBundle;
    private Locale locale;

    private Language() {
        //TODO::switch to fixed languages (EN/NL via GUI selection)??
        this.locale = new Locale(Locale.getDefault().getLanguage());
//        this.locale = new Locale("nl");
    }

    public static synchronized Language getInstance() {
        if (language == null) {
            language = new Language();
        }

        return language;
    }

    public ResourceBundle getResourceBundle(String bundleName) {
        this.resourceBundle = ResourceBundle.getBundle(bundleName, locale);

        return this.resourceBundle;
    }

    public String getTranslation(String message) {
        return this.resourceBundle.getString(message);
    }
}
