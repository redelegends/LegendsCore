package dev.redelegends.database.data.container;

import dev.redelegends.database.data.interfaces.AbstractContainer;
import dev.redelegends.database.data.DataContainer;
import dev.redelegends.database.data.interfaces.AbstractContainer;
import org.json.simple.JSONObject;
import dev.redelegends.database.data.interfaces.AbstractContainer;

@SuppressWarnings("unchecked")
public class DeliveriesContainer extends AbstractContainer {
  
  public DeliveriesContainer(DataContainer dataContainer) {
    super(dataContainer);
  }
  
  public void claimDelivery(long id, long time) {
    JSONObject deliveries = this.dataContainer.getAsJsonObject();
    deliveries.put(String.valueOf(id), System.currentTimeMillis() + time);
    this.dataContainer.set(deliveries.toString());
    deliveries.clear();
  }
  
  public long getClaimTime(long id) {
    JSONObject deliveries = this.dataContainer.getAsJsonObject();
    long time = deliveries.containsKey(String.valueOf(id)) ? (long) deliveries.get(String.valueOf(id)) : 0;
    deliveries.clear();
    return time;
  }
  
  public boolean alreadyClaimed(long id) {
    return this.getClaimTime(id) > System.currentTimeMillis();
  }
}
