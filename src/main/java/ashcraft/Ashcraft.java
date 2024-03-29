package ashcraft;

import ashcraft.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Ashcraft.MODID, name = Ashcraft.NAME, version = Ashcraft.VERSION)

public class Ashcraft {
    public static final String MODID = "ashcraft";
    public static final String NAME = "Ashcraft";
    public static final String VERSION = "1.0";



    @SidedProxy(clientSide = "ashcraft.proxy.ClientProxy",
            serverSide = "ashcraft.proxy.CommonProxy")

    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
