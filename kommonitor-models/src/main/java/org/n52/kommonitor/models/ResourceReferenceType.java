package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;

/**
 * Reference on another resource
 */
@ApiModel(description = "Reference on another resource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-10T12:32:58.267+01:00")

public class ResourceReferenceType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("resourceId")
  private String resourceId = null;

  @JsonProperty("referenceDescription")
  private String referenceDescription = null;

  public ResourceReferenceType resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  /**
   * identifier of the referenced resource
   * @return resourceId
  **/
  @ApiModelProperty(value = "identifier of the referenced resource")


  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public ResourceReferenceType referenceDescription(String referenceDescription) {
    this.referenceDescription = referenceDescription;
    return this;
  }

  /**
   * short description of how the resource is referenced to the superior one
   * @return referenceDescription
  **/
  @ApiModelProperty(value = "short description of how the resource is referenced to the superior one")


  public String getReferenceDescription() {
    return referenceDescription;
  }

  public void setReferenceDescription(String referenceDescription) {
    this.referenceDescription = referenceDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceReferenceType resourceReferenceType = (ResourceReferenceType) o;
    return Objects.equals(this.resourceId, resourceReferenceType.resourceId) &&
        Objects.equals(this.referenceDescription, resourceReferenceType.referenceDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceId, referenceDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceReferenceType {\n");
    
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    referenceDescription: ").append(toIndentedString(referenceDescription)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

