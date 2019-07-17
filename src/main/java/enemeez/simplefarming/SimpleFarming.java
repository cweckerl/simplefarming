package enemeez.simplefarming;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod("simplefarming")
public class SimpleFarming
{
    public static final String MOD_ID = "simplefarming";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup ITEM_GROUP = new ItemGroup("simplefarming")
    		{
				public ItemStack createIcon() 
				{
					return new ItemStack(ModItems.tomato);
				}
				
    		};

    public SimpleFarming() 
    {
    	  DistExecutor.runForDist
    	  (
                  () -> () -> new SideProxy.Client(),
                  () -> () -> new SideProxy.Server()
          );
    }
    
    @Nonnull
    public static String getVersion() 
    {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(MOD_ID);
        if (o.isPresent()) 
        {
            return o.get().getModInfo().getVersion().toString();
        }
        return "NONE";
    }


    public static boolean isDevBuild() 
    {
        String version = getVersion();
        return "NONE".equals(version);
    }

    @Nonnull
    public static ResourceLocation getId(String path) 
    {
        return new ResourceLocation(MOD_ID, path);
    }
    
}
