package dev.redelegends.servers.balancer;

import dev.redelegends.servers.ServerItem;
import dev.redelegends.servers.ServerPing;
import dev.redelegends.servers.balancer.elements.LoadBalancerObject;
import dev.redelegends.servers.balancer.elements.NumberConnection;
import dev.redelegends.servers.ServerItem;
import dev.redelegends.servers.ServerPing;
import dev.redelegends.servers.balancer.elements.LoadBalancerObject;
import dev.redelegends.servers.balancer.elements.NumberConnection;
import dev.redelegends.servers.ServerItem;
import dev.redelegends.servers.ServerPing;
import dev.redelegends.servers.balancer.elements.LoadBalancerObject;
import dev.redelegends.servers.balancer.elements.NumberConnection;

import java.net.InetSocketAddress;

public class Server implements LoadBalancerObject, NumberConnection {
  
  protected ServerPing serverPing;
  protected String name;
  protected int max;
  
  public Server(String ip, String name, int max) {
    this.serverPing = new ServerPing(new InetSocketAddress(ip.split(":")[0], Integer.parseInt(ip.split(":")[1])));
    this.name = name;
    this.max = max;
  }
  
  public void fetch() {
    this.serverPing.fetch();
    ServerItem.SERVER_COUNT.put(this.name, this.serverPing.getOnline());
  }
  
  public String getName() {
    return this.name;
  }
  
  @Override
  public int getActualNumber() {
    return ServerItem.getServerCount(this.name);
  }
  
  @Override
  public int getMaxNumber() {
    return this.max;
  }
  
  @Override
  public boolean canBeSelected() {
    return this.serverPing.getMotd() != null && this.getActualNumber() < this.max;
  }
}
