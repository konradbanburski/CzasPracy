package support;

import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.Base64;

public class Hash {

    public String encodeValue(String value)
    {
        String encode = "";
        try {
            encode = Base64.getEncoder().encodeToString(value.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

    public String decodeValue(String value)
    {
        byte[] decodedBytes;
        String decode = "";
        try {
            decodedBytes = Base64.getDecoder().decode(value);
            decode = new String(decodedBytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decode;
    }
}
