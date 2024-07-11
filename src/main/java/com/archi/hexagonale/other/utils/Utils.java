package com.archi.hexagonale.other.utils;

import java.util.UUID;

public class Utils {

    public static boolean isStringUUID(String id) {
        try {
            UUID.fromString(id);
            return true;
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
