package ashcraft.registry;

import ashcraft.block.BlockAshWorkbench;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class BlockRegistry {

    private ArrayList<Block> listBlock;

    public BlockRegistry(){
        MinecraftForge.EVENT_BUS.register(this);
        listBlock = new ArrayList<>();
        register(new BlockAshWorkbench(), "ash_workbench");
    }

    private void register(Block block, String name){
        listBlock.add(block.setUnlocalizedName(name).setRegistryName(name));
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event){
        for(Block b:listBlock) event.getRegistry().register(b);
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event){
        for(Block b:listBlock) event.getRegistry().register(new ItemBlock(b).setRegistryName(b.getUnlocalizedName()));
    }
}
