package com.libmod_mystay.util_mystayapp_lib.utils;


/**
 * Created by Saket on 29/6/17.
 */

public class DvcCommand_Encryption {

    // This method will call when we want to encrypt over request responce............... saket

    public static synchronized String encode(String response, String encryptionKey, boolean checkFirstRequestIsUnicodeFlag) {
        if (checkFirstRequestIsUnicodeFlag) {         ////////////////////////////////// Using Unicode //////////////////////////////////////////
            try {
                String encodedString = "";
                String key = encryptionKey;
                for (int i = 0; i < response.length(); i++) {
                    char c = response.charAt(i);
                    int index = (i % key.length()) - 1;
                    if (index < 0) {
                        index = index + key.length();
                    }
                    char kc = key.charAt(index);
                    char encodedChar = (char) ((int) c + (int) kc);
                    encodedString = encodedString + encodedChar;
                }
                String returnString = Base64.encode(encodedString);
                return returnString;
            } catch (Exception ex) {
              /*  Log.e("Error in encoding String : ", ex.toString());*/

                ex.printStackTrace();
                return null;
            }
        } else {         //////////////////////////////////Using Ascii //////////////////////////////////////////

            try {
                String cmdstr = "";
                byte result[] = new byte[response.length()];
                for (int i = 0; i < response.length(); i++) {
                    cmdstr = response.substring(i, i + 1);
                    int ch = i % encryptionKey.length() - 1;
                    if (ch < 0)
                        ch = encryptionKey.length() + ch;
                    String keystr = encryptionKey.substring(ch, ch + 1);
                    byte encry[] = new byte[1];
                    encry[0] = (byte) (cmdstr.getBytes()[0] + keystr.getBytes()[0]);
                    result[i] = encry[0];
                }
                return Base64.encode(result);
            } catch (Exception ex) {
                // log.error("Error in encoding String is " + ex);

                ex.printStackTrace();
            }
        }
        return null;
    }
}
