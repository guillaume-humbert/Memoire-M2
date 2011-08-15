package org.miage.memoire.bean;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;

import org.apache.commons.lang.ArrayUtils;
import org.miage.memoire.Converter;

/**
 * This bean is used for the conversion operations.
 * @author Guillaume Humbert
 */
public final class ConverterBean {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.google.com", 80);
        OutputStream ostream = socket.getOutputStream();
        ostream.write(new String("GET / HTTP1.1\r\n"
                + "Host: www.google.com\r\n\r\n").getBytes());
        ostream.flush();
        
        InputStream istream = socket.getInputStream();

        byte[] bytes = new byte[496];
        int read = istream.read(bytes);

        LinkedList<Byte> list = new LinkedList<Byte>();
        
        while (read != -1) {
            System.out.println("Read: " + read);
            for(int i = 0; i < read; i++) {
                byte b = bytes[i];
                list.add(new Byte(b));
            }
            read = istream.read(bytes);
        }

        bytes = ArrayUtils.toPrimitive(list.toArray(new Byte[]{}));
        System.out.println(new String(bytes));
    }
    
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
    }

    /**
     * Getter on the 'convertedString' field.
     * @return The converted string.
     */
    public String getConvertedString() {
        return this.convertedString;
    }

}
