package org.miage.memoire.bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;

import org.miage.memoire.Converter;

/**
 * This bean is used for the conversion operations.
 * @author Guillaume Humbert
 */
public final class ConverterBean {

    /**
     * The string to convert.
     */
    private String stringToConvert = "";

    /**
     * The converted string.
     */
    private String convertedString = "";
    
    /**
     * Default constructor.
     */
    public ConverterBean() {
        super();
    }
    
    /**
     * Converts the stringToConvert in the Javascript toCharCode format.
     */
    public void convertToJavaScriptHexString() {
        final Converter converter = Converter.getInstance();
        this.convertedString = converter.convertToJavaScriptHexString(
                this.stringToConvert);
    }
    
    /**
     * Converts the stringToConvert in an hexadecimal URL format.
     */
    public void convertToUrlHexadecimalFormat() {
        final Converter converter = Converter.getInstance();
        this.convertedString = converter.convertToHexadecimalUrl(
                this.stringToConvert);
    }

    /**
     * Getter on the 'stringToConvert' field.
     * @return The string to convert.
     */
    public String getStringToConvert() {
        return this.stringToConvert;
    }

    /**
     * Setter on the 'stringToConvert' field.
     * @param stringToConvert The string to convert.
     */
    public void setStringToConvert(final String stringToConvert) {
        if (stringToConvert == null) {
            this.stringToConvert = "";
        } else {
            this.stringToConvert = stringToConvert.trim();
        }
        
        try {
            String s = "";
            byte[] buffer = stringToConvert.getBytes(Charset.forName("UTF-8"));
            for(byte b : buffer) {
                s = s + "%" + (Integer.toHexString(b & 0xff));
            }
            
            FileWriter fw = new FileWriter("/home/humbert/Desktop/toto.txt");
            fw.write(s + "\n");
            fw.close();
        } catch (Exception e) {
            
        }
    }

    /**
     * Getter on the 'convertedString' field.
     * @return The converted string.
     */
    public String getConvertedString() {
        return this.convertedString;
    }

}
