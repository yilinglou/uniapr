package java.util;


public final class Locale implements java.io.Serializable , java.lang.Cloneable {
    private static class Cache extends sun.util.locale.LocaleObjectCache<java.util.Locale.LocaleKey, java.util.Locale> {
        private Cache() {
        }

        @java.lang.Override
        protected java.util.Locale createObject(java.util.Locale.LocaleKey key) {
            return new java.util.Locale(key.base, key.exts);
        }
    }

    private static final class LocaleKey {
        private final sun.util.locale.BaseLocale base;

        private final sun.util.locale.LocaleExtensions exts;

        private final int hash;

        private LocaleKey(sun.util.locale.BaseLocale baseLocale, sun.util.locale.LocaleExtensions extensions) {
            base = baseLocale;
            exts = extensions;
            int h = base.hashCode();
            if ((exts) != null) {
                h ^= exts.hashCode();
            }
            hash = h;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object obj) {
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof java.util.Locale.LocaleKey)) {
                return false;
            }
            java.util.Locale.LocaleKey other = ((java.util.Locale.LocaleKey) (obj));
            if (((hash) != (other.hash)) || (!(base.equals(other.base)))) {
                return false;
            }
            if ((exts) == null) {
                return (other.exts) == null;
            }
            return exts.equals(other.exts);
        }

        @java.lang.Override
        public int hashCode() {
            return hash;
        }
    }

    private static class LocaleNameGetter implements sun.util.locale.provider.LocaleServiceProviderPool.LocalizedObjectGetter<java.util.spi.LocaleNameProvider, java.lang.String> {
        private static final java.util.Locale.LocaleNameGetter INSTANCE = new java.util.Locale.LocaleNameGetter();

        @java.lang.Override
        public java.lang.String getObject(java.util.spi.LocaleNameProvider localeNameProvider, java.util.Locale locale, java.lang.String key, java.lang.Object... params) {
            assert (params.length) == 2;
            int type = ((java.lang.Integer) (params[0]));
            java.lang.String code = ((java.lang.String) (params[1]));
            switch (type) {
                case java.util.Locale.DISPLAY_LANGUAGE :
                    return localeNameProvider.getDisplayLanguage(code, locale);
                case java.util.Locale.DISPLAY_COUNTRY :
                    return localeNameProvider.getDisplayCountry(code, locale);
                case java.util.Locale.DISPLAY_VARIANT :
                    return localeNameProvider.getDisplayVariant(code, locale);
                case java.util.Locale.DISPLAY_SCRIPT :
                    return localeNameProvider.getDisplayScript(code, locale);
                default :
                    assert false;
            }
            return null;
        }
    }

    public enum Category {
        DISPLAY("user.language.display","user.script.display","user.country.display","user.variant.display"), FORMAT("user.language.format","user.script.format","user.country.format","user.variant.format");
        final java.lang.String languageKey;

        final java.lang.String scriptKey;

        final java.lang.String countryKey;

        final java.lang.String variantKey;

        Category(java.lang.String languageKey, java.lang.String scriptKey, java.lang.String countryKey, java.lang.String variantKey) {
            this.languageKey = languageKey;
            this.scriptKey = scriptKey;
            this.countryKey = countryKey;
            this.variantKey = variantKey;
        }
    }

    public static final class Builder {
        private final sun.util.locale.InternalLocaleBuilder localeBuilder;

        public Builder() {
            localeBuilder = new sun.util.locale.InternalLocaleBuilder();
        }

        public java.util.Locale.Builder setLocale(java.util.Locale locale) {
            try {
                localeBuilder.setLocale(locale.baseLocale, locale.localeExtensions);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setLanguageTag(java.lang.String languageTag) {
            sun.util.locale.ParseStatus sts = new sun.util.locale.ParseStatus();
            sun.util.locale.LanguageTag tag = sun.util.locale.LanguageTag.parse(languageTag, sts);
            if (sts.isError()) {
                throw new java.util.IllformedLocaleException(sts.getErrorMessage(), sts.getErrorIndex());
            }
            localeBuilder.setLanguageTag(tag);
            return this;
        }

        public java.util.Locale.Builder setLanguage(java.lang.String language) {
            try {
                localeBuilder.setLanguage(language);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setScript(java.lang.String script) {
            try {
                localeBuilder.setScript(script);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setRegion(java.lang.String region) {
            try {
                localeBuilder.setRegion(region);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setVariant(java.lang.String variant) {
            try {
                localeBuilder.setVariant(variant);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setExtension(char key, java.lang.String value) {
            try {
                localeBuilder.setExtension(key, value);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder setUnicodeLocaleKeyword(java.lang.String key, java.lang.String type) {
            try {
                localeBuilder.setUnicodeLocaleKeyword(key, type);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder addUnicodeLocaleAttribute(java.lang.String attribute) {
            try {
                localeBuilder.addUnicodeLocaleAttribute(attribute);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder removeUnicodeLocaleAttribute(java.lang.String attribute) {
            try {
                localeBuilder.removeUnicodeLocaleAttribute(attribute);
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
            return this;
        }

        public java.util.Locale.Builder clear() {
            localeBuilder.clear();
            return this;
        }

        public java.util.Locale.Builder clearExtensions() {
            localeBuilder.clearExtensions();
            return this;
        }

        public java.util.Locale build() {
            sun.util.locale.BaseLocale baseloc = localeBuilder.getBaseLocale();
            sun.util.locale.LocaleExtensions extensions = localeBuilder.getLocaleExtensions();
            if ((extensions == null) && ((baseloc.getVariant().length()) > 0)) {
                extensions = java.util.Locale.getCompatibilityExtensions(baseloc.getLanguage(), baseloc.getScript(), baseloc.getRegion(), baseloc.getVariant());
            }
            return java.util.Locale.getInstance(baseloc, extensions);
        }
    }

    public static enum FilteringMode {
        AUTOSELECT_FILTERING, EXTENDED_FILTERING, IGNORE_EXTENDED_RANGES, MAP_EXTENDED_RANGES, REJECT_EXTENDED_RANGES;}

    public static final class LanguageRange {
        public static final double MAX_WEIGHT = 1.0;

        public static final double MIN_WEIGHT = 0.0;

        private final java.lang.String range;

        private final double weight;

        private volatile int hash = 0;

        public LanguageRange(java.lang.String range) {
            this(range, java.util.Locale.LanguageRange.MAX_WEIGHT);
        }

        public LanguageRange(java.lang.String range, double weight) {
            if (range == null) {
                throw new java.lang.NullPointerException();
            }
            if ((weight < (java.util.Locale.LanguageRange.MIN_WEIGHT)) || (weight > (java.util.Locale.LanguageRange.MAX_WEIGHT))) {
                throw new java.lang.IllegalArgumentException(("weight=" + weight));
            }
            range = range.toLowerCase();
            boolean isIllFormed = false;
            java.lang.String[] subtags = range.split("-");
            if ((java.util.Locale.LanguageRange.isSubtagIllFormed(subtags[0], true)) || (range.endsWith("-"))) {
                isIllFormed = true;
            }else {
                for (int i = 1; i < (subtags.length); i++) {
                    if (java.util.Locale.LanguageRange.isSubtagIllFormed(subtags[i], false)) {
                        isIllFormed = true;
                        break;
                    }
                }
            }
            if (isIllFormed) {
                throw new java.lang.IllegalArgumentException(("range=" + range));
            }
            this.range = range;
            this.weight = weight;
        }

        private static boolean isSubtagIllFormed(java.lang.String subtag, boolean isFirstSubtag) {
            if ((subtag.equals("")) || ((subtag.length()) > 8)) {
                return true;
            }else
                if (subtag.equals("*")) {
                    return false;
                }

            char[] charArray = subtag.toCharArray();
            if (isFirstSubtag) {
                for (char c : charArray) {
                    if ((c < 'a') || (c > 'z')) {
                        return true;
                    }
                }
            }else {
                for (char c : charArray) {
                    if (((c < '0') || ((c > '9') && (c < 'a'))) || (c > 'z')) {
                        return true;
                    }
                }
            }
            return false;
        }

        public java.lang.String getRange() {
            return range;
        }

        public double getWeight() {
            return weight;
        }

        public static java.util.List<java.util.Locale.LanguageRange> parse(java.lang.String ranges) {
            return sun.util.locale.LocaleMatcher.parse(ranges);
        }

        public static java.util.List<java.util.Locale.LanguageRange> parse(java.lang.String ranges, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            return java.util.Locale.LanguageRange.mapEquivalents(java.util.Locale.LanguageRange.parse(ranges), map);
        }

        public static java.util.List<java.util.Locale.LanguageRange> mapEquivalents(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            return sun.util.locale.LocaleMatcher.mapEquivalents(priorityList, map);
        }

        @java.lang.Override
        public int hashCode() {
            if ((hash) == 0) {
                int result = 17;
                result = (37 * result) + (range.hashCode());
                long bitsWeight = java.lang.Double.doubleToLongBits(weight);
                result = (37 * result) + ((int) (bitsWeight ^ (bitsWeight >>> 32)));
                hash = result;
            }
            return hash;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object obj) {
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof java.util.Locale.LanguageRange)) {
                return false;
            }
            java.util.Locale.LanguageRange other = ((java.util.Locale.LanguageRange) (obj));
            return (((hash) == (other.hash)) && (range.equals(other.range))) && ((weight) == (other.weight));
        }
    }

    private static final java.util.Locale.Cache LOCALECACHE = new java.util.Locale.Cache();

    public static final java.util.Locale ENGLISH = java.util.Locale.createConstant("en", "");

    public static final java.util.Locale FRENCH = java.util.Locale.createConstant("fr", "");

    public static final java.util.Locale GERMAN = java.util.Locale.createConstant("de", "");

    public static final java.util.Locale ITALIAN = java.util.Locale.createConstant("it", "");

    public static final java.util.Locale JAPANESE = java.util.Locale.createConstant("ja", "");

    public static final java.util.Locale KOREAN = java.util.Locale.createConstant("ko", "");

    public static final java.util.Locale CHINESE = java.util.Locale.createConstant("zh", "");

    public static final java.util.Locale SIMPLIFIED_CHINESE = java.util.Locale.createConstant("zh", "CN");

    public static final java.util.Locale TRADITIONAL_CHINESE = java.util.Locale.createConstant("zh", "TW");

    public static final java.util.Locale FRANCE = java.util.Locale.createConstant("fr", "FR");

    public static final java.util.Locale GERMANY = java.util.Locale.createConstant("de", "DE");

    public static final java.util.Locale ITALY = java.util.Locale.createConstant("it", "IT");

    public static final java.util.Locale JAPAN = java.util.Locale.createConstant("ja", "JP");

    public static final java.util.Locale KOREA = java.util.Locale.createConstant("ko", "KR");

    public static final java.util.Locale CHINA = java.util.Locale.SIMPLIFIED_CHINESE;

    public static final java.util.Locale PRC = java.util.Locale.SIMPLIFIED_CHINESE;

    public static final java.util.Locale TAIWAN = java.util.Locale.TRADITIONAL_CHINESE;

    public static final java.util.Locale UK = java.util.Locale.createConstant("en", "GB");

    public static final java.util.Locale US = java.util.Locale.createConstant("en", "US");

    public static final java.util.Locale CANADA = java.util.Locale.createConstant("en", "CA");

    public static final java.util.Locale CANADA_FRENCH = java.util.Locale.createConstant("fr", "CA");

    public static final java.util.Locale ROOT = java.util.Locale.createConstant("", "");

    public static final char PRIVATE_USE_EXTENSION = 'x';

    public static final char UNICODE_LOCALE_EXTENSION = 'u';

    static final long serialVersionUID = 9149081749638150636L;

    private static final int DISPLAY_LANGUAGE = 0;

    private static final int DISPLAY_COUNTRY = 1;

    private static final int DISPLAY_VARIANT = 2;

    private static final int DISPLAY_SCRIPT = 3;

    private transient sun.util.locale.BaseLocale baseLocale;

    private transient sun.util.locale.LocaleExtensions localeExtensions;

    private volatile transient int hashCodeValue = 0;

    private static volatile java.util.Locale defaultLocale = java.util.Locale.initDefault();

    private static volatile java.util.Locale defaultDisplayLocale = null;

    private static volatile java.util.Locale defaultFormatLocale = null;

    private volatile transient java.lang.String languageTag;

    private static final java.io.ObjectStreamField[] serialPersistentFields = new java.io.ObjectStreamField[]{ new java.io.ObjectStreamField("language", java.lang.String.class), new java.io.ObjectStreamField("country", java.lang.String.class), new java.io.ObjectStreamField("variant", java.lang.String.class), new java.io.ObjectStreamField("hashcode", int.class), new java.io.ObjectStreamField("script", java.lang.String.class), new java.io.ObjectStreamField("extensions", java.lang.String.class) };

    private static volatile java.lang.String[] isoLanguages = null;

    private static volatile java.lang.String[] isoCountries = null;

    private Locale(sun.util.locale.BaseLocale baseLocale, sun.util.locale.LocaleExtensions extensions) {
        this.baseLocale = baseLocale;
        this.localeExtensions = extensions;
    }

    public Locale(java.lang.String language, java.lang.String country, java.lang.String variant) {
        if (((language == null) || (country == null)) || (variant == null)) {
            throw new java.lang.NullPointerException();
        }
        baseLocale = sun.util.locale.BaseLocale.getInstance(java.util.Locale.convertOldISOCodes(language), "", country, variant);
        localeExtensions = java.util.Locale.getCompatibilityExtensions(language, "", country, variant);
    }

    public Locale(java.lang.String language, java.lang.String country) {
        this(language, country, "");
    }

    public Locale(java.lang.String language) {
        this(language, "", "");
    }

    private static java.util.Locale createConstant(java.lang.String lang, java.lang.String country) {
        sun.util.locale.BaseLocale base = sun.util.locale.BaseLocale.createInstance(lang, country);
        return java.util.Locale.getInstance(base, null);
    }

    static java.util.Locale getInstance(java.lang.String language, java.lang.String country, java.lang.String variant) {
        return java.util.Locale.getInstance(language, "", country, variant, null);
    }

    static java.util.Locale getInstance(java.lang.String language, java.lang.String script, java.lang.String country, java.lang.String variant, sun.util.locale.LocaleExtensions extensions) {
        if ((((language == null) || (script == null)) || (country == null)) || (variant == null)) {
            throw new java.lang.NullPointerException();
        }
        if (extensions == null) {
            extensions = java.util.Locale.getCompatibilityExtensions(language, script, country, variant);
        }
        sun.util.locale.BaseLocale baseloc = sun.util.locale.BaseLocale.getInstance(language, script, country, variant);
        return java.util.Locale.getInstance(baseloc, extensions);
    }

    static java.util.Locale getInstance(sun.util.locale.BaseLocale baseloc, sun.util.locale.LocaleExtensions extensions) {
        java.util.Locale.LocaleKey key = new java.util.Locale.LocaleKey(baseloc, extensions);
        return java.util.Locale.LOCALECACHE.get(key);
    }

    public static java.util.Locale getDefault() {
        return java.util.Locale.defaultLocale;
    }

    public static java.util.Locale getDefault(java.util.Locale.Category category) {
        switch (category) {
            case DISPLAY :
                if ((java.util.Locale.defaultDisplayLocale) == null) {
                    synchronized(java.util.Locale.class) {
                        if ((java.util.Locale.defaultDisplayLocale) == null) {
                            java.util.Locale.defaultDisplayLocale = java.util.Locale.initDefault(category);
                        }
                    }
                }
                return java.util.Locale.defaultDisplayLocale;
            case FORMAT :
                if ((java.util.Locale.defaultFormatLocale) == null) {
                    synchronized(java.util.Locale.class) {
                        if ((java.util.Locale.defaultFormatLocale) == null) {
                            java.util.Locale.defaultFormatLocale = java.util.Locale.initDefault(category);
                        }
                    }
                }
                return java.util.Locale.defaultFormatLocale;
            default :
                assert false : "Unknown Category";
        }
        return java.util.Locale.getDefault();
    }

    private static java.util.Locale initDefault() {
        java.lang.String language;
        java.lang.String region;
        java.lang.String script;
        java.lang.String country;
        java.lang.String variant;
        language = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("user.language", "en"));
        region = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("user.region"));
        if (region != null) {
            int i = region.indexOf('_');
            if (i >= 0) {
                country = region.substring(0, i);
                variant = region.substring((i + 1));
            }else {
                country = region;
                variant = "";
            }
            script = "";
        }else {
            script = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("user.script", ""));
            country = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("user.country", ""));
            variant = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("user.variant", ""));
        }
        return java.util.Locale.getInstance(language, script, country, variant, null);
    }

    private static java.util.Locale initDefault(java.util.Locale.Category category) {
        return java.util.Locale.getInstance(java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction(category.languageKey, java.util.Locale.defaultLocale.getLanguage())), java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction(category.scriptKey, java.util.Locale.defaultLocale.getScript())), java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction(category.countryKey, java.util.Locale.defaultLocale.getCountry())), java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction(category.variantKey, java.util.Locale.defaultLocale.getVariant())), null);
    }

    public static synchronized void setDefault(java.util.Locale newLocale) {
        java.util.Locale.setDefault(java.util.Locale.Category.DISPLAY, newLocale);
        java.util.Locale.setDefault(java.util.Locale.Category.FORMAT, newLocale);
        java.util.Locale.defaultLocale = newLocale;
    }

    public static synchronized void setDefault(java.util.Locale.Category category, java.util.Locale newLocale) {
        if (category == null)
            throw new java.lang.NullPointerException("Category cannot be NULL");

        if (newLocale == null)
            throw new java.lang.NullPointerException("Can't set default locale to NULL");

        java.lang.SecurityManager sm = java.lang.System.getSecurityManager();
        if (sm != null)
            sm.checkPermission(new java.util.PropertyPermission("user.language", "write"));

        switch (category) {
            case DISPLAY :
                java.util.Locale.defaultDisplayLocale = newLocale;
                break;
            case FORMAT :
                java.util.Locale.defaultFormatLocale = newLocale;
                break;
            default :
                assert false : "Unknown Category";
        }
    }

    public static java.util.Locale[] getAvailableLocales() {
        return sun.util.locale.provider.LocaleServiceProviderPool.getAllAvailableLocales();
    }

    public static java.lang.String[] getISOCountries() {
        if ((java.util.Locale.isoCountries) == null) {
            java.util.Locale.isoCountries = java.util.Locale.getISO2Table(java.util.LocaleISOData.isoCountryTable);
        }
        java.lang.String[] result = new java.lang.String[java.util.Locale.isoCountries.length];
        java.lang.System.arraycopy(java.util.Locale.isoCountries, 0, result, 0, java.util.Locale.isoCountries.length);
        return result;
    }

    public static java.lang.String[] getISOLanguages() {
        if ((java.util.Locale.isoLanguages) == null) {
            java.util.Locale.isoLanguages = java.util.Locale.getISO2Table(java.util.LocaleISOData.isoLanguageTable);
        }
        java.lang.String[] result = new java.lang.String[java.util.Locale.isoLanguages.length];
        java.lang.System.arraycopy(java.util.Locale.isoLanguages, 0, result, 0, java.util.Locale.isoLanguages.length);
        return result;
    }

    private static java.lang.String[] getISO2Table(java.lang.String table) {
        int len = (table.length()) / 5;
        java.lang.String[] isoTable = new java.lang.String[len];
        for (int i = 0, j = 0; i < len; i++ , j += 5) {
            isoTable[i] = table.substring(j, (j + 2));
        }
        return isoTable;
    }

    public java.lang.String getLanguage() {
        return baseLocale.getLanguage();
    }

    public java.lang.String getScript() {
        return baseLocale.getScript();
    }

    public java.lang.String getCountry() {
        return baseLocale.getRegion();
    }

    public java.lang.String getVariant() {
        return baseLocale.getVariant();
    }

    public boolean hasExtensions() {
        return (localeExtensions) != null;
    }

    public java.util.Locale stripExtensions() {
        return hasExtensions() ? java.util.Locale.getInstance(baseLocale, null) : this;
    }

    public java.lang.String getExtension(char key) {
        if (!(sun.util.locale.LocaleExtensions.isValidKey(key))) {
            throw new java.lang.IllegalArgumentException(("Ill-formed extension key: " + key));
        }
        return hasExtensions() ? localeExtensions.getExtensionValue(key) : null;
    }

    public java.util.Set<java.lang.Character> getExtensionKeys() {
        if (!(hasExtensions())) {
            return java.util.Collections.emptySet();
        }
        return localeExtensions.getKeys();
    }

    public java.util.Set<java.lang.String> getUnicodeLocaleAttributes() {
        if (!(hasExtensions())) {
            return java.util.Collections.emptySet();
        }
        return localeExtensions.getUnicodeLocaleAttributes();
    }

    public java.lang.String getUnicodeLocaleType(java.lang.String key) {
        if (!(java.util.Locale.isUnicodeExtensionKey(key))) {
            throw new java.lang.IllegalArgumentException(("Ill-formed Unicode locale key: " + key));
        }
        return hasExtensions() ? localeExtensions.getUnicodeLocaleType(key) : null;
    }

    public java.util.Set<java.lang.String> getUnicodeLocaleKeys() {
        if ((localeExtensions) == null) {
            return java.util.Collections.emptySet();
        }
        return localeExtensions.getUnicodeLocaleKeys();
    }

    sun.util.locale.BaseLocale getBaseLocale() {
        return baseLocale;
    }

    sun.util.locale.LocaleExtensions getLocaleExtensions() {
        return localeExtensions;
    }

    @java.lang.Override
    public final java.lang.String toString() {
        boolean l = (baseLocale.getLanguage().length()) != 0;
        boolean s = (baseLocale.getScript().length()) != 0;
        boolean r = (baseLocale.getRegion().length()) != 0;
        boolean v = (baseLocale.getVariant().length()) != 0;
        boolean e = ((localeExtensions) != null) && ((localeExtensions.getID().length()) != 0);
        java.lang.StringBuilder result = new java.lang.StringBuilder(baseLocale.getLanguage());
        if (r || (l && ((v || s) || e))) {
            result.append('_').append(baseLocale.getRegion());
        }
        if (v && (l || r)) {
            result.append('_').append(baseLocale.getVariant());
        }
        if (s && (l || r)) {
            result.append("_#").append(baseLocale.getScript());
        }
        if (e && (l || r)) {
            result.append('_');
            if (!s) {
                result.append('#');
            }
            result.append(localeExtensions.getID());
        }
        return result.toString();
    }

    public java.lang.String toLanguageTag() {
        if ((languageTag) != null) {
            return languageTag;
        }
        sun.util.locale.LanguageTag tag = sun.util.locale.LanguageTag.parseLocale(baseLocale, localeExtensions);
        java.lang.StringBuilder buf = new java.lang.StringBuilder();
        java.lang.String subtag = tag.getLanguage();
        if ((subtag.length()) > 0) {
            buf.append(sun.util.locale.LanguageTag.canonicalizeLanguage(subtag));
        }
        subtag = tag.getScript();
        if ((subtag.length()) > 0) {
            buf.append(sun.util.locale.LanguageTag.SEP);
            buf.append(sun.util.locale.LanguageTag.canonicalizeScript(subtag));
        }
        subtag = tag.getRegion();
        if ((subtag.length()) > 0) {
            buf.append(sun.util.locale.LanguageTag.SEP);
            buf.append(sun.util.locale.LanguageTag.canonicalizeRegion(subtag));
        }
        java.util.List<java.lang.String> subtags = tag.getVariants();
        for (java.lang.String s : subtags) {
            buf.append(sun.util.locale.LanguageTag.SEP);
            buf.append(s);
        }
        subtags = tag.getExtensions();
        for (java.lang.String s : subtags) {
            buf.append(sun.util.locale.LanguageTag.SEP);
            buf.append(sun.util.locale.LanguageTag.canonicalizeExtension(s));
        }
        subtag = tag.getPrivateuse();
        if ((subtag.length()) > 0) {
            if ((buf.length()) > 0) {
                buf.append(sun.util.locale.LanguageTag.SEP);
            }
            buf.append(sun.util.locale.LanguageTag.PRIVATEUSE).append(sun.util.locale.LanguageTag.SEP);
            buf.append(subtag);
        }
        java.lang.String langTag = buf.toString();
        synchronized(this) {
            if ((languageTag) == null) {
                languageTag = langTag;
            }
        }
        return languageTag;
    }

    public static java.util.Locale forLanguageTag(java.lang.String languageTag) {
        sun.util.locale.LanguageTag tag = sun.util.locale.LanguageTag.parse(languageTag, null);
        sun.util.locale.InternalLocaleBuilder bldr = new sun.util.locale.InternalLocaleBuilder();
        bldr.setLanguageTag(tag);
        sun.util.locale.BaseLocale base = bldr.getBaseLocale();
        sun.util.locale.LocaleExtensions exts = bldr.getLocaleExtensions();
        if ((exts == null) && ((base.getVariant().length()) > 0)) {
            exts = java.util.Locale.getCompatibilityExtensions(base.getLanguage(), base.getScript(), base.getRegion(), base.getVariant());
        }
        return java.util.Locale.getInstance(base, exts);
    }

    public java.lang.String getISO3Language() throws java.util.MissingResourceException {
        java.lang.String lang = baseLocale.getLanguage();
        if ((lang.length()) == 3) {
            return lang;
        }
        java.lang.String language3 = java.util.Locale.getISO3Code(lang, java.util.LocaleISOData.isoLanguageTable);
        if (language3 == null) {
            throw new java.util.MissingResourceException(("Couldn't find 3-letter language code for " + lang), ("FormatData_" + (toString())), "ShortLanguage");
        }
        return language3;
    }

    public java.lang.String getISO3Country() throws java.util.MissingResourceException {
        java.lang.String country3 = java.util.Locale.getISO3Code(baseLocale.getRegion(), java.util.LocaleISOData.isoCountryTable);
        if (country3 == null) {
            throw new java.util.MissingResourceException(("Couldn't find 3-letter country code for " + (baseLocale.getRegion())), ("FormatData_" + (toString())), "ShortCountry");
        }
        return country3;
    }

    private static java.lang.String getISO3Code(java.lang.String iso2Code, java.lang.String table) {
        int codeLength = iso2Code.length();
        if (codeLength == 0) {
            return "";
        }
        int tableLength = table.length();
        int index = tableLength;
        if (codeLength == 2) {
            char c1 = iso2Code.charAt(0);
            char c2 = iso2Code.charAt(1);
            for (index = 0; index < tableLength; index += 5) {
                if (((table.charAt(index)) == c1) && ((table.charAt((index + 1))) == c2)) {
                    break;
                }
            }
        }
        return index < tableLength ? table.substring((index + 2), (index + 5)) : null;
    }

    public final java.lang.String getDisplayLanguage() {
        return getDisplayLanguage(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY));
    }

    public java.lang.String getDisplayLanguage(java.util.Locale inLocale) {
        return getDisplayString(baseLocale.getLanguage(), inLocale, java.util.Locale.DISPLAY_LANGUAGE);
    }

    public java.lang.String getDisplayScript() {
        return getDisplayScript(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY));
    }

    public java.lang.String getDisplayScript(java.util.Locale inLocale) {
        return getDisplayString(baseLocale.getScript(), inLocale, java.util.Locale.DISPLAY_SCRIPT);
    }

    public final java.lang.String getDisplayCountry() {
        return getDisplayCountry(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY));
    }

    public java.lang.String getDisplayCountry(java.util.Locale inLocale) {
        return getDisplayString(baseLocale.getRegion(), inLocale, java.util.Locale.DISPLAY_COUNTRY);
    }

    private java.lang.String getDisplayString(java.lang.String code, java.util.Locale inLocale, int type) {
        if ((code.length()) == 0) {
            return "";
        }
        if (inLocale == null) {
            throw new java.lang.NullPointerException();
        }
        sun.util.locale.provider.LocaleServiceProviderPool pool = sun.util.locale.provider.LocaleServiceProviderPool.getPool(java.util.spi.LocaleNameProvider.class);
        java.lang.String key = (type == (java.util.Locale.DISPLAY_VARIANT)) ? "%%" + code : code;
        java.lang.String result = pool.getLocalizedObject(java.util.Locale.LocaleNameGetter.INSTANCE, inLocale, key, type, code);
        if (result != null) {
            return result;
        }
        return code;
    }

    public final java.lang.String getDisplayVariant() {
        return getDisplayVariant(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY));
    }

    public java.lang.String getDisplayVariant(java.util.Locale inLocale) {
        if ((baseLocale.getVariant().length()) == 0)
            return "";

        sun.util.locale.provider.LocaleResources lr = sun.util.locale.provider.LocaleProviderAdapter.forJRE().getLocaleResources(inLocale);
        java.lang.String[] names = getDisplayVariantArray(inLocale);
        return java.util.Locale.formatList(names, lr.getLocaleName("ListPattern"), lr.getLocaleName("ListCompositionPattern"));
    }

    public final java.lang.String getDisplayName() {
        return getDisplayName(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY));
    }

    public java.lang.String getDisplayName(java.util.Locale inLocale) {
        sun.util.locale.provider.LocaleResources lr = sun.util.locale.provider.LocaleProviderAdapter.forJRE().getLocaleResources(inLocale);
        java.lang.String languageName = getDisplayLanguage(inLocale);
        java.lang.String scriptName = getDisplayScript(inLocale);
        java.lang.String countryName = getDisplayCountry(inLocale);
        java.lang.String[] variantNames = getDisplayVariantArray(inLocale);
        java.lang.String displayNamePattern = lr.getLocaleName("DisplayNamePattern");
        java.lang.String listPattern = lr.getLocaleName("ListPattern");
        java.lang.String listCompositionPattern = lr.getLocaleName("ListCompositionPattern");
        java.lang.String mainName = null;
        java.lang.String[] qualifierNames = null;
        if ((((languageName.length()) == 0) && ((scriptName.length()) == 0)) && ((countryName.length()) == 0)) {
            if ((variantNames.length) == 0) {
                return "";
            }else {
                return java.util.Locale.formatList(variantNames, listPattern, listCompositionPattern);
            }
        }
        java.util.ArrayList<java.lang.String> names = new java.util.ArrayList<>(4);
        if ((languageName.length()) != 0) {
            names.add(languageName);
        }
        if ((scriptName.length()) != 0) {
            names.add(scriptName);
        }
        if ((countryName.length()) != 0) {
            names.add(countryName);
        }
        if ((variantNames.length) != 0) {
            names.addAll(java.util.Arrays.asList(variantNames));
        }
        mainName = names.get(0);
        int numNames = names.size();
        qualifierNames = (numNames > 1) ? names.subList(1, numNames).toArray(new java.lang.String[numNames - 1]) : new java.lang.String[0];
        java.lang.Object[] displayNames = new java.lang.Object[]{ new java.lang.Integer(((qualifierNames.length) != 0 ? 2 : 1)), mainName, (qualifierNames.length) != 0 ? java.util.Locale.formatList(qualifierNames, listPattern, listCompositionPattern) : null };
        if (displayNamePattern != null) {
            return new java.text.MessageFormat(displayNamePattern).format(displayNames);
        }else {
            java.lang.StringBuilder result = new java.lang.StringBuilder();
            result.append(((java.lang.String) (displayNames[1])));
            if ((displayNames.length) > 2) {
                result.append(" (");
                result.append(((java.lang.String) (displayNames[2])));
                result.append(')');
            }
            return result.toString();
        }
    }

    @java.lang.Override
    public java.lang.Object clone() {
        try {
            java.util.Locale that = ((java.util.Locale) (super.clone()));
            return that;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.InternalError(e);
        }
    }

    @java.lang.Override
    public int hashCode() {
        int hc = hashCodeValue;
        if (hc == 0) {
            hc = baseLocale.hashCode();
            if ((localeExtensions) != null) {
                hc ^= localeExtensions.hashCode();
            }
            hashCodeValue = hc;
        }
        return hc;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if ((this) == obj)
            return true;

        if (!(obj instanceof java.util.Locale))
            return false;

        sun.util.locale.BaseLocale otherBase = ((java.util.Locale) (obj)).baseLocale;
        if (!(baseLocale.equals(otherBase))) {
            return false;
        }
        if ((localeExtensions) == null) {
            return (((java.util.Locale) (obj)).localeExtensions) == null;
        }
        return localeExtensions.equals(((java.util.Locale) (obj)).localeExtensions);
    }

    private java.lang.String[] getDisplayVariantArray(java.util.Locale inLocale) {
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(baseLocale.getVariant(), "_");
        java.lang.String[] names = new java.lang.String[tokenizer.countTokens()];
        for (int i = 0; i < (names.length); ++i) {
            names[i] = getDisplayString(tokenizer.nextToken(), inLocale, java.util.Locale.DISPLAY_VARIANT);
        }
        return names;
    }

    private static java.lang.String formatList(java.lang.String[] stringList, java.lang.String listPattern, java.lang.String listCompositionPattern) {
        if ((listPattern == null) || (listCompositionPattern == null)) {
            java.lang.StringBuilder result = new java.lang.StringBuilder();
            for (int i = 0; i < (stringList.length); ++i) {
                if (i > 0) {
                    result.append(',');
                }
                result.append(stringList[i]);
            }
            return result.toString();
        }
        if ((stringList.length) > 3) {
            java.text.MessageFormat format = new java.text.MessageFormat(listCompositionPattern);
            stringList = java.util.Locale.composeList(format, stringList);
        }
        java.lang.Object[] args = new java.lang.Object[(stringList.length) + 1];
        java.lang.System.arraycopy(stringList, 0, args, 1, stringList.length);
        args[0] = new java.lang.Integer(stringList.length);
        java.text.MessageFormat format = new java.text.MessageFormat(listPattern);
        return format.format(args);
    }

    private static java.lang.String[] composeList(java.text.MessageFormat format, java.lang.String[] list) {
        if ((list.length) <= 3)
            return list;

        java.lang.String[] listItems = new java.lang.String[]{ list[0], list[1] };
        java.lang.String newItem = format.format(listItems);
        java.lang.String[] newList = new java.lang.String[(list.length) - 1];
        java.lang.System.arraycopy(list, 2, newList, 1, ((newList.length) - 1));
        newList[0] = newItem;
        return java.util.Locale.composeList(format, newList);
    }

    private static boolean isUnicodeExtensionKey(java.lang.String s) {
        return ((s.length()) == 2) && (sun.util.locale.LocaleUtils.isAlphaNumericString(s));
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = out.putFields();
        fields.put("language", baseLocale.getLanguage());
        fields.put("script", baseLocale.getScript());
        fields.put("country", baseLocale.getRegion());
        fields.put("variant", baseLocale.getVariant());
        fields.put("extensions", ((localeExtensions) == null ? "" : localeExtensions.getID()));
        fields.put("hashcode", (-1));
        out.writeFields();
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        java.io.ObjectInputStream.GetField fields = in.readFields();
        java.lang.String language = ((java.lang.String) (fields.get("language", "")));
        java.lang.String script = ((java.lang.String) (fields.get("script", "")));
        java.lang.String country = ((java.lang.String) (fields.get("country", "")));
        java.lang.String variant = ((java.lang.String) (fields.get("variant", "")));
        java.lang.String extStr = ((java.lang.String) (fields.get("extensions", "")));
        baseLocale = sun.util.locale.BaseLocale.getInstance(java.util.Locale.convertOldISOCodes(language), script, country, variant);
        if ((extStr.length()) > 0) {
            try {
                sun.util.locale.InternalLocaleBuilder bldr = new sun.util.locale.InternalLocaleBuilder();
                bldr.setExtensions(extStr);
                localeExtensions = bldr.getLocaleExtensions();
            } catch (sun.util.locale.LocaleSyntaxException e) {
                throw new java.util.IllformedLocaleException(e.getMessage());
            }
        }else {
            localeExtensions = null;
        }
    }

    private java.lang.Object readResolve() throws java.io.ObjectStreamException {
        return java.util.Locale.getInstance(baseLocale.getLanguage(), baseLocale.getScript(), baseLocale.getRegion(), baseLocale.getVariant(), localeExtensions);
    }

    private static java.lang.String convertOldISOCodes(java.lang.String language) {
        language = sun.util.locale.LocaleUtils.toLowerString(language).intern();
        if (language == "he") {
            return "iw";
        }else
            if (language == "yi") {
                return "ji";
            }else
                if (language == "id") {
                    return "in";
                }else {
                    return language;
                }


    }

    private static sun.util.locale.LocaleExtensions getCompatibilityExtensions(java.lang.String language, java.lang.String script, java.lang.String country, java.lang.String variant) {
        sun.util.locale.LocaleExtensions extensions = null;
        if ((((sun.util.locale.LocaleUtils.caseIgnoreMatch(language, "ja")) && ((script.length()) == 0)) && (sun.util.locale.LocaleUtils.caseIgnoreMatch(country, "jp"))) && ("JP".equals(variant))) {
            extensions = sun.util.locale.LocaleExtensions.CALENDAR_JAPANESE;
        }else
            if ((((sun.util.locale.LocaleUtils.caseIgnoreMatch(language, "th")) && ((script.length()) == 0)) && (sun.util.locale.LocaleUtils.caseIgnoreMatch(country, "th"))) && ("TH".equals(variant))) {
                extensions = sun.util.locale.LocaleExtensions.NUMBER_THAI;
            }

        return extensions;
    }

    public static java.util.List<java.util.Locale> filter(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.util.Locale> locales, java.util.Locale.FilteringMode mode) {
        return sun.util.locale.LocaleMatcher.filter(priorityList, locales, mode);
    }

    public static java.util.List<java.util.Locale> filter(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.util.Locale> locales) {
        return java.util.Locale.filter(priorityList, locales, java.util.Locale.FilteringMode.AUTOSELECT_FILTERING);
    }

    public static java.util.List<java.lang.String> filterTags(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.lang.String> tags, java.util.Locale.FilteringMode mode) {
        return sun.util.locale.LocaleMatcher.filterTags(priorityList, tags, mode);
    }

    public static java.util.List<java.lang.String> filterTags(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.lang.String> tags) {
        return java.util.Locale.filterTags(priorityList, tags, java.util.Locale.FilteringMode.AUTOSELECT_FILTERING);
    }

    public static java.util.Locale lookup(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.util.Locale> locales) {
        return sun.util.locale.LocaleMatcher.lookup(priorityList, locales);
    }

    public static java.lang.String lookupTag(java.util.List<java.util.Locale.LanguageRange> priorityList, java.util.Collection<java.lang.String> tags) {
        return sun.util.locale.LocaleMatcher.lookupTag(priorityList, tags);
    }
}

