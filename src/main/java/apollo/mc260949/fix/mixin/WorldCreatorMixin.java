package apollo.mc260949.fix.mixin;
WorldCreator
import net.minecraft.client.gui.screen.world.WorldCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static net.minecraft.client.gui.screen.world.WorldCreator.getWorldPreset;

@Mixin(WorldCreator.class)
public abstract class WorldCreatorMixin {
	@Inject(at = @At("TAIL"), method = "updateWorldTypeLists()V")
	private void init(CallbackInfo ci) {
		((WorldCreator)(Object)this).setWorldType(getWorldPreset(((WorldCreator)(Object)this).getGeneratorOptionsHolder(), ((WorldCreator)(Object)this).worldType.preset().getKey()).map(WorldCreator.WorldType::new).orElse(((WorldCreator) (Object) this).getNormalWorldTypes().get(0)));
	}
}

