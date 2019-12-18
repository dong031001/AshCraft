package ashcraft.registry;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemRegistry {

    private ArrayList<Item> itemList = new ArrayList<>();

    public ItemRegistry(){
        MinecraftForge.EVENT_BUS.register(this);



    }

    private void register(Item item, String name){
        itemList.add(item.setUnlocalizedName(name).setRegistryName(name));
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
        for(Item i:itemList) event.getRegistry().register(i);
    }
}
