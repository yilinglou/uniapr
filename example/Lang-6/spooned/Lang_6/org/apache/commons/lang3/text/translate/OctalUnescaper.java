package org.apache.commons.lang3.text.translate;


public class OctalUnescaper extends org.apache.commons.lang3.text.translate.CharSequenceTranslator {
    private static int OCTAL_MAX = 377;

    @java.lang.Override
    public int translate(java.lang.CharSequence input, int index, java.io.Writer out) throws java.io.IOException {
        if ((((input.charAt(index)) == '\\') && (index < ((input.length()) - 1))) && (java.lang.Character.isDigit(input.charAt((index + 1))))) {
            int start = index + 1;
            int end = index + 2;
            while ((end < (input.length())) && (java.lang.Character.isDigit(input.charAt(end)))) {
                end++;
                if ((java.lang.Integer.parseInt(input.subSequence(start, end).toString(), 10)) > (org.apache.commons.lang3.text.translate.OctalUnescaper.OCTAL_MAX)) {
                    end--;
                    break;
                }
            } 
            out.write(java.lang.Integer.parseInt(input.subSequence(start, end).toString(), 8));
            return (1 + end) - start;
        }
        return 0;
    }
}

