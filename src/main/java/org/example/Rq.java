package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String prefix;
    private String suffix;
    private Map<String,String> param = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdParts = cmd.split("\\?");
        prefix = cmdParts[0].trim();
        suffix = cmdParts.length > 1 ? cmdParts[1].trim() : "";

        String[] query = suffix.split("&");
        for (String q : query) {
            String [] parts = q.split("=");
            if (parts.length > 1) {
                param.put(parts[0], parts[1]);
            }
        }
    }

    public String getActionName() {
        return prefix;
    }

    public int getParamAsInt(String key, int _default) {
        String value = getParam(key, "");
        int result = _default;

        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException _) { }

        return result;
    }

    public String getParam(String key, String _default) {
        if (key.isEmpty()) return _default;
        if (param.containsKey(key)) return param.get(key);

        return _default;
    }
}
