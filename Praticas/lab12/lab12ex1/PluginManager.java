package lab12ex1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

abstract class PluginManager {
    public static IPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (IPlugin) c.getDeclaredConstructor().newInstance();
    }
}


