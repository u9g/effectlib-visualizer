package dev.u9g.effectspreviewer;

import de.slikey.effectlib.EffectManager;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.commandmanager.ArgType;
import redempt.redlib.commandmanager.CommandParser;

public final class EffectsPreviewer extends JavaPlugin {
    @Override
    public void onEnable() {
        ArgType<Particle> particleArgType = ArgType.of("particle", Particle.class);
        new CommandParser(this.getResource("commands.rdcml")).setArgTypes(particleArgType).parse().register("particles", new Commands(new EffectManager(this)));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
