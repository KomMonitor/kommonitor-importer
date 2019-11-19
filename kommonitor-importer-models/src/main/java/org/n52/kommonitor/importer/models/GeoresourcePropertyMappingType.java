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
 * GeoresourcePropertyMappingType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-19T09:41:06.276+01:00")

public class GeoresourcePropertyMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("datasetNameProperty")
  private String datasetNameProperty = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validStartDate")
  private String validStartDate = null;

  @JsonProperty("validEndDate")
  private String validEndDate = null;

  public GeoresourcePropertyMappingType datasetNameProperty(String datasetNameProperty) {
    this.datasetNameProperty = datasetNameProperty;
    return this;
  }

  /**
   * The property that contains each feature's unique identifier
   * @return datasetNameProperty
  **/
  @ApiModelProperty(required = true, value = "The property that contains each feature's unique identifier")
  @NotNull


  public String getDatasetNameProperty() {
    return datasetNameProperty;
  }

  public void setDatasetNameProperty(String datasetNameProperty) {
    this.datasetNameProperty = datasetNameProperty;
  }

  public GeoresourcePropertyMappingType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The property that contains each feature's unique name
   * @return name
  **/
  @ApiModelProperty(value = "The property that contains each feature's unique name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GeoresourcePropertyMappingType validStartDate(String validStartDate) {
    this.validStartDate = validStartDate;
    return this;
  }

  /**
   * The property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validStartDate
  **/
  @ApiModelProperty(value = "The property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidStartDate() {
    return validStartDate;
  }

  public void setValidStartDate(String validStartDate) {
    this.validStartDate = validStartDate;
  }

  public GeoresourcePropertyMappingType validEndDate(String validEndDate) {
    this.validEndDate = validEndDate;
    return this;
  }

  /**
   * The property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validEndDate
  **/
  @ApiModelProperty(value = "The property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidEndDate() {
    return validEndDate;
  }

  public void setValidEndDate(String validEndDate) {
    this.validEndDate = validEndDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoresourcePropertyMappingType georesourcePropertyMappingType = (GeoresourcePropertyMappingType) o;
    return Objects.equals(this.datasetNameProperty, georesourcePropertyMappingType.datasetNameProperty) &&
        Objects.equals(this.name, georesourcePropertyMappingType.name) &&
        Objects.equals(this.validStartDate, georesourcePropertyMappingType.validStartDate) &&
        Objects.equals(this.validEndDate, georesourcePropertyMappingType.validEndDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetNameProperty, name, validStartDate, validEndDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoresourcePropertyMappingType {\n");
    
    sb.append("    datasetNameProperty: ").append(toIndentedString(datasetNameProperty)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validStartDate: ").append(toIndentedString(validStartDate)).append("\n");
    sb.append("    validEndDate: ").append(toIndentedString(validEndDate)).append("\n");
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

