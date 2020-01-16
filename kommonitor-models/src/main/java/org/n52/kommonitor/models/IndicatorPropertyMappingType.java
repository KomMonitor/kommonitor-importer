package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for mapping datasource properties to required properties for indicators
 */
@ApiModel(description = "Definitions for mapping datasource properties to required properties for indicators")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-16T12:12:49.758+01:00")

public class IndicatorPropertyMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("spatialReferenceKeyProperty")
  private String spatialReferenceKeyProperty = null;

  @JsonProperty("indicatorValueProperty")
  private String indicatorValueProperty = null;

  @JsonProperty("timestamp")
  private LocalDate timestamp = null;

  @JsonProperty("timestampProperty")
  private String timestampProperty = null;

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

  public IndicatorPropertyMappingType indicatorValueProperty(String indicatorValueProperty) {
    this.indicatorValueProperty = indicatorValueProperty;
    return this;
  }

  /**
   * property that contains the numeric value of the indicator
   * @return indicatorValueProperty
  **/
  @ApiModelProperty(required = true, value = "property that contains the numeric value of the indicator")
  @NotNull


  public String getIndicatorValueProperty() {
    return indicatorValueProperty;
  }

  public void setIndicatorValueProperty(String indicatorValueProperty) {
    this.indicatorValueProperty = indicatorValueProperty;
  }

  public IndicatorPropertyMappingType timestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * optional timestamp value for the indicator that will be used if there is no property containing timestamp information
   * @return timestamp
  **/
  @ApiModelProperty(value = "optional timestamp value for the indicator that will be used if there is no property containing timestamp information")

  @Valid

  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  public IndicatorPropertyMappingType timestampProperty(String timestampProperty) {
    this.timestampProperty = timestampProperty;
    return this;
  }

  /**
   * property that contains the timestamp (year, month and date) according to ISO 8601 (e.g. 2018-01-30)
   * @return timestampProperty
  **/
  @ApiModelProperty(value = "property that contains the timestamp (year, month and date) according to ISO 8601 (e.g. 2018-01-30)")


  public String getTimestampProperty() {
    return timestampProperty;
  }

  public void setTimestampProperty(String timestampProperty) {
    this.timestampProperty = timestampProperty;
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
        Objects.equals(this.indicatorValueProperty, indicatorPropertyMappingType.indicatorValueProperty) &&
        Objects.equals(this.timestamp, indicatorPropertyMappingType.timestamp) &&
        Objects.equals(this.timestampProperty, indicatorPropertyMappingType.timestampProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialReferenceKeyProperty, indicatorValueProperty, timestamp, timestampProperty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPropertyMappingType {\n");
    
    sb.append("    spatialReferenceKeyProperty: ").append(toIndentedString(spatialReferenceKeyProperty)).append("\n");
    sb.append("    indicatorValueProperty: ").append(toIndentedString(indicatorValueProperty)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    timestampProperty: ").append(toIndentedString(timestampProperty)).append("\n");
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

