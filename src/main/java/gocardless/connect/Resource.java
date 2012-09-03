package gocardless.connect;

import java.io.Serializable;
import java.net.URI;

public class Resource implements Serializable {

  private static final long serialVersionUID = 1L;

  public interface Params {
    public final static String RESOURCE_ID = "resource_id";
    public final static String RESOURCE_TYPE = "resource_type";
    public final static String RESOURCE_URI = "resource_uri";
    public final static String STATE = "state";
    public final static String SIGNATURE = "signature";
  }
  
  private String resourceId;
  
  private String resourceType;
  
  private URI resourceUri;
  
  private String state;
  
  private String signature;
  
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public URI getResourceUri() {
    return resourceUri;
  }

  public void setResourceUri(URI resourceUri) {
    this.resourceUri = resourceUri;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }
  
  public static class Builder {

    private String resourceId;
    
    private String resourceType;
    
    private URI resourceUri;
    
    private String state;
    
    private String signature;

    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }
    
    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }
    
    public Builder resourceUri(URI resourceUri) {
      this.resourceUri = resourceUri;
      return this;
    }
    
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    public Builder signature(String signature) {
      this.signature = signature;
      return this;
    }
    
    public Resource build() {
      Resource resource = new Resource();
      resource.resourceId = this.resourceId;
      resource.resourceType = this.resourceType;
      resource.resourceUri = this.resourceUri;
      resource.state = this.state;
      resource.signature = this.signature;
      return resource;
    }

  }
  
}
