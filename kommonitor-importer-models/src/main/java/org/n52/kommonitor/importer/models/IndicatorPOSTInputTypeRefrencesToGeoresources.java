package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IndicatorPOSTInputTypeRefrencesToGeoresources
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-10T12:37:10.215+01:00")

public class IndicatorPOSTInputTypeRefrencesToGeoresources  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("georesourceId")
  private String georesourceId = null;

  @JsonProperty("referenceDescription")
  private String referenceDescription = null;

  public IndicatorPOSTInputTypeRefrencesToGeoresources georesourceId(String georesourceId) {
    this.georesourceId = georesourceId;
    return this;
  }

  /**
   * identifier of the referenced georesource
   * @return georesourceId
  **/
  @ApiModelProperty(value = "identifier of the referenced georesource")


  public String getGeoresourceId() {
    return georesourceId;
  }

  public void setGeoresourceId(String georesourceId) {
    this.georesourceId = georesourceId;
  }

  public IndicatorPOSTInputTypeRefrencesToGeoresources referenceDescription(String referenceDescription) {
    this.referenceDescription = referenceDescription;
    return this;
  }

  /**
   * short description of how the georesource is referenced to the indicator
   * @return referenceDescription
  **/
  @ApiModelProperty(value = "short description of how the georesource is referenced to the indicator")


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
    IndicatorPOSTInputTypeRefrencesToGeoresources indicatorPOSTInputTypeRefrencesToGeoresources = (IndicatorPOSTInputTypeRefrencesToGeoresources) o;
    return Objects.equals(this.georesourceId, indicatorPOSTInputTypeRefrencesToGeoresources.georesourceId) &&
        Objects.equals(this.referenceDescription, indicatorPOSTInputTypeRefrencesToGeoresources.referenceDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(georesourceId, referenceDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPOSTInputTypeRefrencesToGeoresources {\n");
    
    sb.append("    georesourceId: ").append(toIndentedString(georesourceId)).append("\n");
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

