package CoordsLog.CoordsLog;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.nio.file.*;

public class LocationListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();

        // Define the file path using Path
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
        String fileName = formatter.format(LocalDateTime.now()) + ".txt";
        String dirName = "/home/ubuntu/mcserver/plugins/CoordsLogLogs";
        Path filePath = Paths.get(dirName, fileName);

        try {
            // Create parent directories if they don't exist
            Files.createDirectories(filePath.getParent());

            // Create the file
            Files.createFile(filePath);

            // Write player coordinates to the file
            String content = String.format("Player: %s\nX: %.2f\nY: %.2f\nZ: %.2f\n", player.getName(), loc.getX(), loc.getY(), loc.getZ());
            Files.write(filePath, content.getBytes(), StandardOpenOption.WRITE);

            System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
