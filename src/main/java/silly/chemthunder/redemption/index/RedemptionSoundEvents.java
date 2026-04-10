package silly.chemthunder.redemption.index;

import net.acoyt.acornlib.api.registrants.SoundEventRegistrant;
import net.minecraft.sound.SoundEvent;
import silly.chemthunder.redemption.Redemption;

public interface RedemptionSoundEvents {
    SoundEventRegistrant SOUND_EVENTS = new SoundEventRegistrant(Redemption.MOD_ID);

    SoundEvent HUNTER_BLACKOUT = SOUND_EVENTS.register("item.hunter.blackout");
    SoundEvent UNSHEATHE = SOUND_EVENTS.register("item.unsheathe");
    SoundEvent BECOME_JUDGE = SOUND_EVENTS.register("event.become_judge");
    SoundEvent JUDGE_DEATH = SOUND_EVENTS.register("event.judge_death");
    SoundEvent PING = SOUND_EVENTS.register("event.ping");
    SoundEvent SONAR_PING = SOUND_EVENTS.register("event.sonar_ping");

    static void index() {}
}