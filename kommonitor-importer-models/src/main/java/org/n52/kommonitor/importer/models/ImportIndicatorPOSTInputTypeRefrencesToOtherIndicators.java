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
 * ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("indicatorId")
  private String indicatorId = null;

  @JsonProperty("referenceDescription")
  private String referenceDescription = null;

  public ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators indicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
    return this;
  }

  /**
   * identifier of the referenced indicator
   * @return indicatorId
  **/
  @ApiModelProperty(value = "identifier of the referenced indicator")


  public String getIndicatorId() {
    return indicatorId;
  }

  public void setIndicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
  }

  public ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators referenceDescription(String referenceDescription) {
    this.referenceDescription = referenceDescription;
    return this;
  }

  /**
   * short description of how the indicator is referenced to the superior one
   * @return referenceDescription
  **/
  @ApiModelProperty(value = "short description of how the indicator is referenced to the superior one")


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
    ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators importIndicatorPOSTInputTypeRefrencesToOtherIndicators = (ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators) o;
    return Objects.equals(this.indicatorId, importIndicatorPOSTInputTypeRefrencesToOtherIndicators.indicatorId) &&
        Objects.equals(this.referenceDescription, importIndicatorPOSTInputTypeRefrencesToOtherIndicators.referenceDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorId, referenceDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportIndicatorPOSTInputTypeRefrencesToOtherIndicators {\n");
    
    sb.append("    indicatorId: ").append(toIndentedString(indicatorId)).append("\n");
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

