package ashcraft.block;

import ashcraft.Ashcraft;
import ashcraft.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

public class BlockAshWorkbench extends Block {
    public BlockAshWorkbench(){
        super(Material.WOOD);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
                                    EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {
            CommonProxy.logger.log(Level.INFO, "Player has activated ash workbench");
            playerIn.displayGui(new IInterfaceCraftingTable());
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }

    public static class IInterfaceCraftingTable implements IInteractionObject {

        @Override
        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
            return new ContainerWorkbench(playerInventory, playerIn.world, playerIn.getPosition());
        }

        @Override
        public String getGuiID() {
            return "ashcraft:workbench";
        }

        @Override
        public String getName() {
            return "ash_crafting_table";
        }

        @Override
        public boolean hasCustomName() {
            return false;
        }

        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation("ash_workbench" + ".name");
        }
    }
}