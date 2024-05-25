package dev.redelegends.database.data.container;

import dev.redelegends.achievements.Achievement;
import dev.redelegends.database.data.interfaces.AbstractContainer;
import dev.redelegends.achievements.Achievement;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.interfaces.AbstractContainer;
import org.json.simple.JSONArray;
import dev.redelegends.achievements.Achievement;
import dev.redelegends.database.data.interfaces.AbstractContainer;

@SuppressWarnings("unchecked")
public class AchievementsContainer extends AbstractContainer {
  
  public AchievementsContainer(DataContainer dataContainer) {
    super(dataContainer);
  }
  
  public void complete(Achievement achievement) {
    JSONArray achievements = this.dataContainer.getAsJsonArray();
    achievements.add(achievement.getId());
    this.dataContainer.set(achievements.toString());
    achievements.clear();
  }
  
  public boolean isCompleted(Achievement achievement) {
    return this.dataContainer.getAsJsonArray().contains(achievement.getId());
  }
}
