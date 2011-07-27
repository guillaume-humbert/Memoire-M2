package org.miage.memoire;

import java.nio.charset.Charset;

/**
 * This class provides utility conversion methods, like String in hex.
 * @author Guillaume Humbert
 */
public final class Converter {
    
    /**
     * The unique instance of this class.
     */
    private static Converter instance = new Converter();
    
    /**
     * Singleton.
     */
    private Converter() {
        // Singleton.
    }

    /**
     * Converts a string in the format used in the Javascript
     * String.fromCharCode method.
     * @param s The string to convert.
     * @return The converted string.
     */
    public String convertToJavaScriptHexString(final String s) {
        final byte[] bytes = s.getBytes();
        final StringBuilder buffer = new StringBuilder();

        for (byte b : bytes) {
            buffer.append(new Byte(b).toString() + ",");
        }
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }

        return buffer.toString();
    }
    
    /**
     * Converts a string in an hexadecimal url format. All characters are
     * converted except the numbers.
     * @param s The string to convert.
     * @return A hexadecimal url format string.
     */
    public String convertToHexadecimalUrl(final String s) {
        final byte[] bytes = s.getBytes();
        final StringBuilder buffer = new StringBuilder();
        final int extraBytes = 0xff;
        final int zeroCode = 0x30;
        final int nineCode = 0x39;
        
        for (byte b : bytes) {
            int i = new Integer(b).intValue();
            i = i & extraBytes;
            
            if (i >= zeroCode && i <= nineCode) {
                buffer.append(new String(new byte[]{b}));
            } else {
                buffer.append("%" + Integer.toHexString(i));
            }
        }

        return buffer.toString();
        
    }
    
    public static void main(String[] args) throws Exception {
        String s = "abcdeé";
        StringBuilder buffer = new StringBuilder();
        
        byte[] bytes = s.getBytes(Charset.forName("utf-8"));
        
        /*
        for (byte b : bytes) {
            System.out.println(Integer.toHexString(b & 0xff) + " " +  (char)(b & 0xff));
            buffer.append(new )
        }
        */
        
        String x = new String(bytes, "iso-8859-1");
        System.out.println(x);
    }
    
    /**
     * Gets the unique instance of this class.
     * @return The unique instance of this class.
     */
    public static Converter getInstance() {
        return Converter.instance;
    }
    
}
