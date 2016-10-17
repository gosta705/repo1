package ru.sberbank.javaschool;

import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        URL url = new URL(pluginRootDirectory);
        PluginClassLoader loader = new PluginClassLoader(new URL[]{url});
        Class<Plugin> plugin = (Class<Plugin>) loader.loadClass(pluginName);
        return plugin.newInstance();

    }

}
