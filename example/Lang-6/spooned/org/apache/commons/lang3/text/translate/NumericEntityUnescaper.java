package org.apache.commons.lang3.text.translate;


public class NumericEntityUnescaper extends org.apache.commons.lang3.text.translate.CharSequenceTranslator {
    public static enum OPTION {
        semiColonRequired, semiColonOptional, errorIfNoSemiColon;}

    private final java.util.EnumSet<org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION> options;

    public NumericEntityUnescaper(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION... options) {
        if ((options.length) > 0) {
            this.options = java.util.EnumSet.copyOf(java.util.Arrays.asList(options));
        }else {
            this.options = java.util.EnumSet.copyOf(java.util.Arrays.asList(new org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[]{ org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired }));
        }
    }

    public boolean isSet(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION option) {
        return (options) == null ? false : options.contains(option);
    }

    @java.lang.Override
    public int translate(java.lang.CharSequence input, int index, java.io.Writer out) throws java.io.IOException {
        int seqEnd = input.length();
        if ((((input.charAt(index)) == '&') && (index < (seqEnd - 2))) && ((input.charAt((index + 1))) == '#')) {
            int start = index + 2;
            boolean isHex = false;
            char firstChar = input.charAt(start);
            if ((firstChar == 'x') || (firstChar == 'X')) {
                start++;
                isHex = true;
                if (start == seqEnd) {
                    return 0;
                }
            }
            int end = start;
            while ((end < seqEnd) && (((((input.charAt(end)) >= '0') && ((input.charAt(end)) <= '9')) || (((input.charAt(end)) >= 'a') && ((input.charAt(end)) <= 'f'))) || (((input.charAt(end)) >= 'A') && ((input.charAt(end)) <= 'F')))) {
                end++;
            } 
            boolean semiNext = (end != seqEnd) && ((input.charAt(end)) == ';');
            if (!semiNext) {
                if (isSet(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired)) {
                    return 0;
                }else
                    if (isSet(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.errorIfNoSemiColon)) {
                        throw new java.lang.IllegalArgumentException("Semi-colon required at end of numeric entity");
                    }

            }
            int entityValue;
            try {
                if (isHex) {
                    entityValue = java.lang.Integer.parseInt(input.subSequence(start, end).toString(), 16);
                }else {
                    entityValue = java.lang.Integer.parseInt(input.subSequence(start, end).toString(), 10);
                }
            } catch (java.lang.NumberFormatException nfe) {
                return 0;
            }
            if (entityValue > 65535) {
                char[] chrs = java.lang.Character.toChars(entityValue);
                out.write(chrs[0]);
                out.write(chrs[1]);
            }else {
                out.write(entityValue);
            }
            return (((2 + end) - start) + (isHex ? 1 : 0)) + (semiNext ? 1 : 0);
        }
        return 0;
    }
}

