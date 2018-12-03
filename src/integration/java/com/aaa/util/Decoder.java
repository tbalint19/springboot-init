package com.aaa.util;

import java.util.Iterator;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

public class Decoder {

    public Decoder() {}

    public Object decodeJWTForField(String jwtToken, String field) throws JSONException {
        String base64EncodedBody = jwtToken.split("\\.")[1];

        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));

        JSONObject jsonObject = new JSONObject(body);
        Iterator<String> iterator = jsonObject.keys();

        while (iterator.hasNext()) {
            String key = iterator.next();
            if (field.equals(key)) return jsonObject.get(key);
        }

        return null;
    }
}
