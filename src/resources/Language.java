package resources;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private static Language language;
    private Locale locale;

    private Language() {
        //TODO::switch to fixed languages (EN/NL via GUI selection)??
        this.locale = new Locale(Locale.getDefault().getLanguage());
        //   this.locale = new Locale("nl");
    }

    public static synchronized Language getInstance() {
        if (language == null) {
            language = new Language();
        }

        return language;
    }

    public ResourceBundle getResourceBundle(String bundleName) {
        return ResourceBundle.getBundle(bundleName, locale);
    }

    public String getString(String bundleName, String key, Object... parameters) {
        return MessageFormat.format(
                getResourceBundle(bundleName).getString(key),
                parameters
        );
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
