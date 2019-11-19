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
 * SpatialUnitPropertyMappingType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-19T09:41:06.276+01:00")

public class SpatialUnitPropertyMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idProperty")
  private String idProperty = null;

  @JsonProperty("nameProperty")
  private String nameProperty = null;

  @JsonProperty("validStartDateProperty")
  private String validStartDateProperty = null;

  @JsonProperty("validEndDateProperty")
  private String validEndDateProperty = null;

  public SpatialUnitPropertyMappingType idProperty(String idProperty) {
    this.idProperty = idProperty;
    return this;
  }

  /**
   * The property that contains each feature's unique identifier
   * @return idProperty
  **/
  @ApiModelProperty(required = true, value = "The property that contains each feature's unique identifier")
  @NotNull


  public String getIdProperty() {
    return idProperty;
  }

  public void setIdProperty(String idProperty) {
    this.idProperty = idProperty;
  }

  public SpatialUnitPropertyMappingType nameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
    return this;
  }

  /**
   * The property that contains each feature's unique name
   * @return nameProperty
  **/
  @ApiModelProperty(required = true, value = "The property that contains each feature's unique name")
  @NotNull


  public String getNameProperty() {
    return nameProperty;
  }

  public void setNameProperty(String nameProperty) {
    this.nameProperty = nameProperty;
  }

  public SpatialUnitPropertyMappingType validStartDateProperty(String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
    return this;
  }

  /**
   * The property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validStartDateProperty
  **/
  @ApiModelProperty(value = "The property that contains information about each feature's period of validity start date (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidStartDateProperty() {
    return validStartDateProperty;
  }

  public void setValidStartDateProperty(String validStartDateProperty) {
    this.validStartDateProperty = validStartDateProperty;
  }

  public SpatialUnitPropertyMappingType validEndDateProperty(String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
    return this;
  }

  /**
   * The property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)
   * @return validEndDateProperty
  **/
  @ApiModelProperty(value = "The property that contains information about each feature's period of validity end date - might be null to indicator that feature is most current feature (optional, can also be configured globally for all features in POST and PUT requests)")


  public String getValidEndDateProperty() {
    return validEndDateProperty;
  }

  public void setValidEndDateProperty(String validEndDateProperty) {
    this.validEndDateProperty = validEndDateProperty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpatialUnitPropertyMappingType spatialUnitPropertyMappingType = (SpatialUnitPropertyMappingType) o;
    return Objects.equals(this.idProperty, spatialUnitPropertyMappingType.idProperty) &&
        Objects.equals(this.nameProperty, spatialUnitPropertyMappingType.nameProperty) &&
        Objects.equals(this.validStartDateProperty, spatialUnitPropertyMappingType.validStartDateProperty) &&
        Objects.equals(this.validEndDateProperty, spatialUnitPropertyMappingType.validEndDateProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProperty, nameProperty, validStartDateProperty, validEndDateProperty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpatialUnitPropertyMappingType {\n");
    
    sb.append("    idProperty: ").append(toIndentedString(idProperty)).append("\n");
    sb.append("    nameProperty: ").append(toIndentedString(nameProperty)).append("\n");
    sb.append("    validStartDateProperty: ").append(toIndentedString(validStartDateProperty)).append("\n");
    sb.append("    validEndDateProperty: ").append(toIndentedString(validEndDateProperty)).append("\n");
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

