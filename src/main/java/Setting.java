import java.util.HashMap;
import java.util.Map;

//public class Setting {
//    public final String getSetting(String key) {
////        String value = readFromDatabase(key);
////        return value;
//        String value = lookupCache(key);
//        if (value == null) {
//            value = readFromDatabase(key);
//            System.out.println("[DEBUG] load from db: " + key + " = " + value);
//            putintoCache(key, value);
//        } else {
//            System.out.println("[DEBUG] load from cache: " + key + " = " + value);
//        }
//        return value;
//    }
//
//    private String readFromDatabase(String key) {
//        //从数据库读取
//        return null;
//    }
//}

abstract class AbstractSetting {
    public final String getSetting(String key) {
        String value = lookupCache(key);
        if (value == null) {
            value = readFromDatabase(key);
            putIntoCache(key, value);
        }
        return value;
    }

    protected abstract String lookupCache(String key);

    protected abstract void putIntoCache(String key, String value);

    private String readFromDatabase(String key) {
        //从数据库读取
        return null;
    }
}

class LocalSetting extends AbstractSetting {
    private Map<String, String> cache = new HashMap<>();

    protected String lookupCache(String key) {
        return cache.get(key);
    }

    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }
}

//class RedisSetting extends AbstractSetting {
//    private RedisClient client = RedisClient.create("redis://localhost:6379");
//
//    protected String lookupCache(String key) {
//        try (StatefulRedisConnection<String, String> connection = client.connect()) {
//            RedisCommands<String, String> commands = connection.sync();
//            return commands.get(key);
//        }
//    }
//
//    protected void putIntoCache(String key, String value) {
//        try (StatefulRedisConnection<String, String> connection = client.connect()) {
//            RedisCommands<String, String> commands = connection.sync();
//            commands.set(key, value);
//        }
//    }
//}