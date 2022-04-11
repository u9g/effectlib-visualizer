package dev.u9g.effectspreviewer;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.*;
import de.slikey.effectlib.util.DynamicLocation;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.util.Ticks;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import redempt.redlib.misc.Task;

import java.util.function.BiFunction;

public class Commands {
    private final EffectManager effectManager;
    private final Particle particle = Particle.SOUL_FIRE_FLAME;
    private final BiFunction<Player, Integer, Location> xForwardFromPlayer = (player, x) -> player.getLocation().add(0,2,0).add(player.getLocation().getDirection().multiply(x));

    public Commands(EffectManager effectManager) {
        this.effectManager = effectManager;
    }

    @CommandHook("animatedball")
    public void onAnimatedBall(Player player) {
        AnimatedBallEffect effect = new AnimatedBallEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("arc")
    public void onArc(Player player) {
        ArcEffect effect = new ArcEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.setDynamicTarget(new DynamicLocation(xForwardFromPlayer.apply(player, 9)));
        effect.particles = 50;
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("atom")
    public void onAtom(Player player) {
        AtomEffect effect = new AtomEffect(effectManager);
        // add 3 blocks from player's y, this is a tall effect
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3).add(0,1,0)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("bigbang")
    public void onBigBang(Player player) {
        BigBangEffect effect = new BigBangEffect(effectManager);
        // add a lot of blocks to player's location, this is a large
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 15).add(0,10,0)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("bleed")
    public void onBleed(Player player) {
        BleedEffect effect = new BleedEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("circle")
    public void onCircle(Player player) {
        CircleEffect effect = new CircleEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("cloud")
    public void onCloud(Player player) {
        CloudEffect effect = new CloudEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("coloredimage")
    public void onColoredImage(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
    }

    @CommandHook("cone")
    public void onCone(Player player) {
        ConeEffect effect = new ConeEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("cube")
    public void onCube(Player player) {
        CubeEffect effect = new CubeEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.angularVelocityX *= 2;
        effect.angularVelocityY *= 2;
        effect.angularVelocityZ *= 2;
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 20);
    }

    @CommandHook("cuboid")
    public void onCuboid(Player player) {
        CuboidEffect effect = new CuboidEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3).add(1,0,0)));
        effect.setDynamicTarget(new DynamicLocation(xForwardFromPlayer.apply(player, 5).subtract(0,2,1)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("cylinder")
    public void onCylinder(Player player, Particle particle) {
        CylinderEffect effect = new CylinderEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.angularVelocityX *= 4;
        effect.angularVelocityY *= 4;
        effect.angularVelocityZ *= 4;
        // /cylinder DAMAGE_INDICATOR
        effect.particle = particle == null ? this.particle : particle;
//        effect.particles = 25;
        effect.particles *= 4;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 20);
    }

    @CommandHook("discoball")
    public void onDiscoBall(Player player) {
        DiscoBallEffect effect = new DiscoBallEffect(effectManager);
        // add 3 to y because this is a large effect
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5).add(0,3,0)));
        effect.sphereParticle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("dna")
    public void onDna(Player player) {
        DnaEffect effect = new DnaEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.particleHelix = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("donut")
    public void onDonut(Player player) {
        DonutEffect effect = new DonutEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("dragon")
    public void onDragon(Player player) {
        DragonEffect effect = new DragonEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 2)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("earth")
    public void onEarth(Player player) {
        EarthEffect effect = new EarthEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("equation")
    public void onEquation(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Relies on you giving your own equations."));
//        EquationEffect effect = new EquationEffect(effectManager);
//        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 1)));
//        effect.start();
//        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("explode")
    public void onExplode(Player player) {
        ExplodeEffect effect = new ExplodeEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("flame")
    public void onFlame(Player player) {
        FlameEffect effect = new FlameEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("fountain")
    public void onFountain(Player player) {
        FountainEffect effect = new FountainEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 9)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("grid")
    public void onGrid(Player player) {
        GridEffect effect = new GridEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 9)));
        effect.particle = particle;
        effect.type = EffectType.REPEATING;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("heart")
    public void onHeart(Player player) {
        HeartEffect effect = new HeartEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("helix")
    public void onHelix(Player player) {
        HelixEffect effect = new HelixEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(player.getLocation().add(0, 0.5, 0)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Look down!"));
    }

    @CommandHook("hill")
    public void onHill(Player player) {
        HillEffect effect = new HillEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 6)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("icon")
    public void onIcon(Player player) {
        IconEffect effect = new IconEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 6)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("jump")
    public void onJump(Player player) {
        JumpEffect effect = new JumpEffect(effectManager);
        effect.setEntity(player);
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Literally makes the player jump..."));
    }

    @CommandHook("line")
    public void onLine(Player player) {
        LineEffect effect = new LineEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.setDynamicTarget(new DynamicLocation(xForwardFromPlayer.apply(player, 6)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("love")
    public void onLove(Player player) {
        LoveEffect effect = new LoveEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("modified")
    public void onModified(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Relies on you giving your own modified equations."));
    }

    @CommandHook("music")
    public void onMusic(Player player) {
        MusicEffect effect = new MusicEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("plot")
    public void onPlot(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Relies on you giving your own plot equations."));
    }

    @CommandHook("pyramid")
    public void onPyramid(Player player) {
        PyramidEffect effect = new PyramidEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.radius = 2;
        effect.particles = 100;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("shield")
    public void onShield(Player player) {
        ShieldEffect effect = new ShieldEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.particles = 250;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("skyrocket")
    public void onSkyRocket(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
        // doesn't work
//        SkyRocketEffect effect = new SkyRocketEffect(effectManager);
//        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
//        effect.setDynamicTarget(new DynamicLocation(xForwardFromPlayer.apply(player, 10)));
//        effect.start();
//        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("sound")
    public void onSound(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
    }

    @CommandHook("sphere")
    public void onSphere(Player player) {
        SphereEffect effect = new SphereEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.radius *= 3;
        effect.particles *= 3;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("square")
    public void onSquare(Player player) {
        SquareEffect effect = new SquareEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("star")
    public void onStar(Player player) {
        StarEffect effect = new StarEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("text")
    public void onText(Player player, String text) {
        TextEffect effect = new TextEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 9)));
        effect.particle = particle;
        effect.text = text;
        effect.period = 10;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("tornado")
    public void onTornado(Player player) {
        TornadoEffect effect = new TornadoEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
        effect.tornadoParticle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("trace")
    public void onTrace(Player player) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Unimplemented"));
        // need to add waypoints
//        TraceEffect effect = new TraceEffect(effectManager);
//        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 3)));
//        effect.particle = particle;
//        effect.start();
//        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("turn")
    public void onTurn(Player player) {
        TurnEffect effect = new TurnEffect(effectManager);
        effect.setEntity(player);
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("vortex")
    public void onVortex(Player player) {
        VortexEffect effect = new VortexEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("warp")
    public void onWarp(Player player) {
        WarpEffect effect = new WarpEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }

    @CommandHook("wave")
    public void onWave(Player player) {
        WaveEffect effect = new WaveEffect(effectManager);
        effect.setDynamicOrigin(new DynamicLocation(xForwardFromPlayer.apply(player, 5)));
        effect.particle = particle;
        effect.start();
        Task.syncDelayed(() -> effect.cancel(), Ticks.TICKS_PER_SECOND * 5);
    }
}
