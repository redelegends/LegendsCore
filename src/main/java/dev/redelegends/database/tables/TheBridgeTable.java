package dev.redelegends.database.tables;

import dev.redelegends.database.Database;
import dev.redelegends.database.HikariDatabase;
import dev.redelegends.database.MySQLDatabase;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.DataTable;
import dev.redelegends.database.data.interfaces.DataTableInfo;
import dev.redelegends.database.Database;
import dev.redelegends.database.HikariDatabase;
import dev.redelegends.database.MySQLDatabase;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.DataTable;
import dev.redelegends.database.data.interfaces.DataTableInfo;
import dev.redelegends.database.Database;
import dev.redelegends.database.HikariDatabase;
import dev.redelegends.database.MySQLDatabase;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.DataTable;
import dev.redelegends.database.data.interfaces.DataTableInfo;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

@DataTableInfo(name = "LegendsCoreTheBridge",
    create = "CREATE TABLE IF NOT EXISTS `LegendsCoreTheBridge` (`name` VARCHAR(32), `1v1kills` LONG, `1v1deaths` LONG, `1v1games` LONG, `1v1points` LONG, `1v1wins` LONG, `2v2kills` LONG, `2v2deaths` LONG, `2v2games` LONG, `2v2points` LONG, `2v2wins` LONG, `monthlykills` LONG, `monthlydeaths` LONG, `monthlypoints` LONG, `monthlywins` LONG, `monthlygames` LONG, `month` TEXT, `coins` DOUBLE, `winstreak` LONG, `laststreak` LONG, `lastmap` LONG, `hotbar` TEXT, `cosmetics` TEXT, `selected` TEXT, PRIMARY KEY(`name`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_bin;",
    select = "SELECT * FROM `LegendsCoreTheBridge` WHERE LOWER(`name`) = ?",
    insert = "INSERT INTO `LegendsCoreTheBridge` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
    update = "UPDATE `LegendsCoreTheBridge` SET `1v1kills` = ?, `1v1deaths` = ?, `1v1games` = ?, `1v1points` = ?, `1v1wins` = ?, `2v2kills` = ?, `2v2deaths` = ?, `2v2games` = ?, `2v2points` = ?, `2v2wins` = ?, `monthlykills` = ?, `montlhydeaths` = ?, `monthlypoints` = ?, `monthlywins` = ?, `monthlygames` = ?, `month` = ?, `coins` = ?, `winstreak` = ?, `laststreak` = ?, `lastmap` = ?, `hotbar` = ?, `cosmetics` = ?, `selected` = ? WHERE LOWER(`name`) = ?")
public class TheBridgeTable extends DataTable {
  
  @Override
  public void init(Database database) {
    if (database instanceof MySQLDatabase) {
      if (((MySQLDatabase) database).query("SHOW COLUMNS FROM `LegendsCoreTheBridge` LIKE 'hotbar'") == null) {
        ((MySQLDatabase) database).execute("ALTER TABLE `LegendsCoreTheBridge` ADD `hotbar` TEXT AFTER `lastmap`");
      }
    } else if (database instanceof HikariDatabase) {
      if (((HikariDatabase) database).query("SHOW COLUMNS FROM `LegendsCoreTheBridge` LIKE 'hotbar'") == null) {
        ((HikariDatabase) database).execute("ALTER TABLE `LegendsCoreTheBridge` ADD `hotbar` TEXT AFTER `lastmap`");
      }
    }
  }
  
  public Map<String, DataContainer> getDefaultValues() {
    Map<String, DataContainer> defaultValues = new LinkedHashMap<>();
    defaultValues.put("1v1kills", new DataContainer(0L));
    defaultValues.put("1v1deaths", new DataContainer(0L));
    defaultValues.put("1v1games", new DataContainer(0L));
    defaultValues.put("1v1points", new DataContainer(0L));
    defaultValues.put("1v1wins", new DataContainer(0L));
    defaultValues.put("2v2kills", new DataContainer(0L));
    defaultValues.put("2v2deaths", new DataContainer(0L));
    defaultValues.put("2v2games", new DataContainer(0L));
    defaultValues.put("2v2points", new DataContainer(0L));
    defaultValues.put("2v2wins", new DataContainer(0L));
    for (String key : new String[]{"kills", "deaths", "points", "wins", "games"}) {
      defaultValues.put("monthly" + key, new DataContainer(0L));
    }
    defaultValues.put("month", new DataContainer((Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" +
        Calendar.getInstance().get(Calendar.YEAR)));
    defaultValues.put("coins", new DataContainer(0.0D));
    defaultValues.put("winstreak", new DataContainer(0L));
    defaultValues.put("laststreak", new DataContainer(System.currentTimeMillis()));
    defaultValues.put("lastmap", new DataContainer(0L));
    defaultValues.put("hotbar", new DataContainer("{}"));
    defaultValues.put("cosmetics", new DataContainer("{}"));
    defaultValues.put("selected", new DataContainer("{}"));
    return defaultValues;
  }
}
