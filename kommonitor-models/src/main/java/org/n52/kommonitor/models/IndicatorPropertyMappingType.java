package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.TimeseriesMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for mapping datasource properties to required properties for indicators
 */
@ApiModel(description = "Definitions for mapping datasource properties to required properties for indicators")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-16T14:30:37.706+01:00")

public class IndicatorPropertyMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("spatialReferenceKeyProperty")
  private String spatialReferenceKeyProperty = null;

  @JsonProperty("timeseriesMappings")
  @Valid
  private List<TimeseriesMappingType> timeseriesMappings = null;

  public IndicatorPropertyMappingType spatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
    return this;
  }

  /**
   * property that contains the identifier of the spatial feature to which the values shall be applied
   * @return spatialReferenceKeyProperty
  **/
  @ApiModelProperty(required = true, value = "property that contains the identifier of the spatial feature to which the values shall be applied")
  @NotNull


  public String getSpatialReferenceKeyProperty() {
    return spatialReferenceKeyProperty;
  }

  public void setSpatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
  }

  public IndicatorPropertyMappingType timeseriesMappings(List<TimeseriesMappingType> timeseriesMappings) {
    this.timeseriesMappings = timeseriesMappings;
    return this;
  }

  public IndicatorPropertyMappingType addTimeseriesMappingsItem(TimeseriesMappingType timeseriesMappingsItem) {
    if (this.timeseriesMappings == null) {
      this.timeseriesMappings = new ArrayList<>();
    }
    this.timeseriesMappings.add(timeseriesMappingsItem);
    return this;
  }

  /**
   * list of property mappings for timeseries values
   * @return timeseriesMappings
  **/
  @ApiModelProperty(value = "list of property mappings for timeseries values")

  @Valid

  public List<TimeseriesMappingType> getTimeseriesMappings() {
    return timeseriesMappings;
  }

  public void setTimeseriesMappings(List<TimeseriesMappingType> timeseriesMappings) {
    this.timeseriesMappings = timeseriesMappings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPropertyMappingType indicatorPropertyMappingType = (IndicatorPropertyMappingType) o;
    return Objects.equals(this.spatialReferenceKeyProperty, indicatorPropertyMappingType.spatialReferenceKeyProperty) &&
        Objects.equals(this.timeseriesMappings, indicatorPropertyMappingType.timeseriesMappings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialReferenceKeyProperty, timeseriesMappings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPropertyMappingType {\n");
    
    sb.append("    spatialReferenceKeyProperty: ").append(toIndentedString(spatialReferenceKeyProperty)).append("\n");
    sb.append("    timeseriesMappings: ").append(toIndentedString(timeseriesMappings)).append("\n");
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

