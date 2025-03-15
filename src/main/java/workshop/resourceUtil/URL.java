package workshop.resourceUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String text){
            try {
                URLDecoder.decode(text, "UTF- 8");
            } catch (UnsupportedEncodingException e) {
                
               return "";
            }
             return text;
    }
}
