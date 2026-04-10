package silly.chemthunder.redemption.datagen.provider;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import silly.chemthunder.redemption.index.RedemptionItems;

import java.util.concurrent.CompletableFuture;

public class RedemptionLangGen extends FabricLanguageProvider {
    public RedemptionLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        RedemptionItems.ITEMS.registerLang(wrapperLookup, translationBuilder);

        translationBuilder.add("itemGroup.redemption", "Redemption");

        translationBuilder.add("death.attack.katana", "%1$s was cut in half");
        translationBuilder.add("death.attack.katana.player", "%1$s was cut in half by %2$s");
        translationBuilder.add("death.attack.katana.item", "%1$s was cut in half by %2$s wielding %3$s");

        translationBuilder.add("death.attack.descend", "%1$s's purpose was revoked");
        translationBuilder.add("death.attack.descend.player", "%1$s's purpose was revoked");
        translationBuilder.add("death.attack.descend.item", "%1$s's purpose was revoked");

        translationBuilder.add("lore.court_glass.0", "An ancient artifact that has been passed down");
        translationBuilder.add("lore.court_glass.1", "time and time again from one Judge to the next.");
        translationBuilder.add("lore.court_glass.2", "It's your turn now.");

        translationBuilder.add("lore.hunters_glass.0", "An artifact from a time long ago.");
        translationBuilder.add("lore.hunters_glass.1", "It was said to be once wielded by the Last Judge.");
        translationBuilder.add("lore.hunters_glass.2", "Now, it's in your hands. Don't let her down.");

        translationBuilder.add("category.redemption", "Ikir Abilities");
        translationBuilder.add("key.redemption.switch_gamemodes", "Switch Game Modes");
        translationBuilder.add("key.redemption.use_immolation", "Use Immolation");
    }
}