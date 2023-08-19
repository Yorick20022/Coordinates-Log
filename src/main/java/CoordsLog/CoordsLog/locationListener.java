package CoordsLog.CoordsLog;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class locationListener implements Listener {
    @EventHandler

    public void onPlayerLeave(PlayerQuitEvent event) throws IOException {
        Player player = event.getPlayer();
        Location loc = player.getLocation();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh.mm.ss");
        Date date = new Date();
        String path = dateFormat.format(date) + ".txt";
        String dirName = "/home/ubuntu/mcserver/plugins/CoordsLogLogs";
        File logFile = new File(dirName, path);

        if (logFile.createNewFile()) {
            System.out.println("File created: " + logFile.getName());
            System.out.println("Location: " + logFile.getPath());
        } else {
            System.out.println("File already exists.");
        }
        FileWriter myWriter = new FileWriter(logFile);
        String string = String.format("Player: %s\nX: %.2f\nY: %.2f\nZ: %.2f\n", player.getName(), loc.x(), loc.y(), loc.z());
        myWriter.write(string);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
}
