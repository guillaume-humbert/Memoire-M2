<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.Socket"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>

<%!public String getHttpIndexPage(String host) throws IOException {
    
    // Socket is opened.
    Socket socket = new Socket(host, 80);
    
    // A HTTP GET request is sent to the host.
    OutputStream ostream = socket.getOutputStream();
    ostream.write(new String("GET / HTTP1.1\r\n"
            + "Host: " + host + "\r\n\r\n").getBytes());
    ostream.flush();

    // The response is stored in a buffer.
    InputStream istream = socket.getInputStream();
    byte[] bytes = new byte[4096]; // Temp buffer.
    int read = istream.read(bytes);
    // Buffer that stores the response.
    LinkedList<Byte> list = new LinkedList<Byte>();

    while (read != -1) {
        for(int i = 0; i < read; i++) {
            byte b = bytes[i];
            list.add(new Byte(b));
        }
        read = istream.read(bytes);
    }

    bytes = ArrayUtils.toPrimitive(list.toArray(new Byte[]{}));
    
    // Encoding of the response is not checked.
    String res = new String(bytes);
    return res;
    // The socket and the streams are not closed.
}

public String toto(String host) throws IOException {

    String res = null;
    InputStream iStream = null;
    OutputStream oStream = null;
    
    // Socket is opened.
    Socket socket = new Socket(host, 80);
    iStream = socket.getInputStream();
    oStream = socket.getOutputStream();
    
    // Code ...
    // ...
    
    iStream.close();
    oStream.close();
    socket.close();
    return res;
}

public String tata(String host) throws IOException {
    
    String res = null;
    InputStream iStream = null;
    OutputStream oStream = null;
    
    // Socket is opened.
    Socket socket = new Socket(host, 80);
    
    try {
	    iStream = socket.getInputStream();
	    oStream = socket.getOutputStream();
    
	    // Code ...
	    // ...
    
    } finally {
        socket.close();
    }
    
    return res;
    
}
%>

<%

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
String res = new String(bytes);

%>

<%= res %>
