package dev.redelegends.database.data.container;

import dev.redelegends.titles.Title;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.interfaces.AbstractContainer;
import dev.redelegends.titles.Title;
import org.json.simple.JSONArray;
import dev.redelegends.titles.Title;

@SuppressWarnings("unchecked")
public class TitlesContainer extends AbstractContainer {
  
  public TitlesContainer(DataContainer dataContainer) {
    super(dataContainer);
  }
  
  public void add(Title title) {
    JSONArray titles = this.dataContainer.getAsJsonArray();
    titles.add(title.getId());
    this.dataContainer.set(titles.toString());
    titles.clear();
  }
  
  public boolean has(Title title) {
    return this.dataContainer.getAsJsonArray().contains(title.getId());
  }
}
