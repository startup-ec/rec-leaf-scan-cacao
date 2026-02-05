package com.rec_leaf_scan_cacao.util;

import java.util.UUID;

public class UUIDUtils {

    public static UUID parseUUID(Object id) {
        if (id == null) {
            return null;
        }

        if (id instanceof UUID) {
            return (UUID) id;
        } else if (id instanceof String) {
            String idString = (String) id;
            if (idString.isEmpty()) return null;
            try {
                return UUID.fromString(idString);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (id instanceof Long) {
            Long longId = (Long) id;
            // Creamos UUID usando la parte alta como 0 y la baja como el long
            return new UUID(0L, longId);
        } else {
            return null; // tipo no soportado
        }
    }
}
