package com.juanmuscaria.playercontainerfix;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("MagiHandlers")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class FMLCoreMod implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public static Logger logger = LogManager.getLogger("PlayerContainerFix");

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public String getMixinConfig() {
        return "mixins.PlayerContainerFix.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        try {
            Class.forName("org.bukkit.World");
            logger.info("Adding ContainerPlayer patches!");
            return Collections.singletonList("MixinContainerPlayer");
        } catch (ClassNotFoundException e) {
            logger.info("Thermos/Bukkit/Crucible not found, doing nothing!");
            return Collections.emptyList();
        }
    }
}
