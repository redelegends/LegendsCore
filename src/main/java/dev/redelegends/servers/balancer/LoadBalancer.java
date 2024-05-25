package dev.redelegends.servers.balancer;

import dev.redelegends.servers.balancer.elements.LoadBalancerObject;
import dev.redelegends.servers.balancer.elements.LoadBalancerObject;
import dev.redelegends.servers.balancer.elements.LoadBalancerObject;

public interface LoadBalancer<T extends LoadBalancerObject> {
  T next();
}
