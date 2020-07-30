package enemeez.simplefarming;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod("simplefarming")
public class SimpleFarming {
	public static final String MOD_ID = "simplefarming";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup ITEM_GROUP = new ItemGroup("simplefarming") {
		public ItemStack createIcon() {
			return new ItemStack(ModItems.tomato);
		}
	};

	public SimpleFarming() {
		DistExecutor.unsafeRunForDist(() -> () -> new SideProxy.Client(), () -> () -> new SideProxy.Server());
	}

	@Nonnull
	public static ResourceLocation getId(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

}
