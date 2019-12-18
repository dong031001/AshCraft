package ashcraft.proxy;

import ashcraft.registry.BlockRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

public class CommonProxy{

    public static Logger logger;

    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        new BlockRegistry();
    }

    public void init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
