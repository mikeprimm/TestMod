package com.mikeprimm.BUKKIT5319;
 
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class TestMod extends JavaPlugin
{
    public void onEnable()
    {
    }

    public void onDisable() {
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdid, String[] args) {
        if (cmdid.equals("dumpvalue")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                Location loc = p.getLocation();
                Chunk c = loc.getWorld().getChunkAt(loc);
                ChunkSnapshot css = c.getChunkSnapshot();
                sender.sendMessage("Inhabited time for " + loc.toString() + " = " + c.getInhabitedTime() + ", for snapshot=" + css.getInhabitedTime());
            }
        }
        else if (cmdid.equals("setvalue")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                Location loc = p.getLocation();
                Chunk c = loc.getWorld().getChunkAt(loc);
                if (args.length > 0) {
                    long val = Long.parseLong(args[0]);
                    c.setInhabitedTime(val);
                    sender.sendMessage("Set inhabited TS for " + loc.toString() + " to " + val);
                }
            }
        }
        return true;
    }
}

