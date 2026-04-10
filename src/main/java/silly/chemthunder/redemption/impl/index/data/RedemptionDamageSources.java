package silly.chemthunder.redemption.impl.index.data;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import silly.chemthunder.redemption.impl.Redemption;

import java.util.HashMap;
import java.util.Map;

public interface RedemptionDamageSources {
    Map<RegistryKey<DamageType>, String> SOURCES = new HashMap<>();

    RegistryKey<DamageType> KATANA = of("katana");
    static DamageSource katana(LivingEntity entity) {
        return entity.getDamageSources().create(KATANA); }

    RegistryKey<DamageType> DESCEND = of("descend");
    static DamageSource descend(LivingEntity entity) {
        return entity.getDamageSources().create(DESCEND); }

    RegistryKey<DamageType> IMMOLATION = of("immolation");
    static DamageSource immolation(LivingEntity entity) {
        return entity.getDamageSources().create(IMMOLATION); }

    private static RegistryKey<DamageType> of(String name) {
        RegistryKey<DamageType> gen = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Redemption.id(name));
        SOURCES.put(gen, name);
        return gen;
    }

    static void bootstrap(Registerable<DamageType> registerable) {
        SOURCES.forEach((damageTypeRegistryKey, s) -> registerable.register(damageTypeRegistryKey, new DamageType(s, 0.0f)));
    }
}