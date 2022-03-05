package enemeez.simplefarming;

import enemeez.simplefarming.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod("simplefarming")
public class SimpleFarming {
	public static final String MOD_ID = "simplefarming";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab("simplefarming") {
		public ItemStack makeIcon() {
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
