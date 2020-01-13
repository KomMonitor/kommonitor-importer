package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * a reference to georesource, e.g. a resource that is used to compute the main indicator
 */
@ApiModel(description = "a reference to georesource, e.g. a resource that is used to compute the main indicator")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T17:03:30.872+01:00")

public class GeoresourceReferenceType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("referencedGeoresourceId")
  private String referencedGeoresourceId = null;

  @JsonProperty("referencedGeoresourceName")
  private String referencedGeoresourceName = null;

  @JsonProperty("referencedGeoresourceDescription")
  private String referencedGeoresourceDescription = null;

  public GeoresourceReferenceType referencedGeoresourceId(String referencedGeoresourceId) {
    this.referencedGeoresourceId = referencedGeoresourceId;
    return this;
  }

  /**
   * unique identifier of the referenced georesource
   * @return referencedGeoresourceId
  **/
  @ApiModelProperty(required = true, value = "unique identifier of the referenced georesource")
  @NotNull


  public String getReferencedGeoresourceId() {
    return referencedGeoresourceId;
  }

  public void setReferencedGeoresourceId(String referencedGeoresourceId) {
    this.referencedGeoresourceId = referencedGeoresourceId;
  }

  public GeoresourceReferenceType referencedGeoresourceName(String referencedGeoresourceName) {
    this.referencedGeoresourceName = referencedGeoresourceName;
    return this;
  }

  /**
   * the meaningful name of the referenced georesource
   * @return referencedGeoresourceName
  **/
  @ApiModelProperty(required = true, value = "the meaningful name of the referenced georesource")
  @NotNull


  public String getReferencedGeoresourceName() {
    return referencedGeoresourceName;
  }

  public void setReferencedGeoresourceName(String referencedGeoresourceName) {
    this.referencedGeoresourceName = referencedGeoresourceName;
  }

  public GeoresourceReferenceType referencedGeoresourceDescription(String referencedGeoresourceDescription) {
    this.referencedGeoresourceDescription = referencedGeoresourceDescription;
    return this;
  }

  /**
   * a meaningful description of how the referenced georesource is related to the main indicator
   * @return referencedGeoresourceDescription
  **/
  @ApiModelProperty(required = true, value = "a meaningful description of how the referenced georesource is related to the main indicator")
  @NotNull


  public String getReferencedGeoresourceDescription() {
    return referencedGeoresourceDescription;
  }

  public void setReferencedGeoresourceDescription(String referencedGeoresourceDescription) {
    this.referencedGeoresourceDescription = referencedGeoresourceDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoresourceReferenceType georesourceReferenceType = (GeoresourceReferenceType) o;
    return Objects.equals(this.referencedGeoresourceId, georesourceReferenceType.referencedGeoresourceId) &&
        Objects.equals(this.referencedGeoresourceName, georesourceReferenceType.referencedGeoresourceName) &&
        Objects.equals(this.referencedGeoresourceDescription, georesourceReferenceType.referencedGeoresourceDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referencedGeoresourceId, referencedGeoresourceName, referencedGeoresourceDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoresourceReferenceType {\n");
    
    sb.append("    referencedGeoresourceId: ").append(toIndentedString(referencedGeoresourceId)).append("\n");
    sb.append("    referencedGeoresourceName: ").append(toIndentedString(referencedGeoresourceName)).append("\n");
    sb.append("    referencedGeoresourceDescription: ").append(toIndentedString(referencedGeoresourceDescription)).append("\n");
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

