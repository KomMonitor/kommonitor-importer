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
 * Definitions for mapping datasource properties to required properties for timeseries values
 */
@ApiModel(description = "Definitions for mapping datasource properties to required properties for timeseries values")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-16T14:30:37.706+01:00")

public class TimeseriesMappingType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("indicatorValueProperty")
  private String indicatorValueProperty = null;

  @JsonProperty("timestamp")
  private LocalDate timestamp = null;

  @JsonProperty("timestampProperty")
  private String timestampProperty = null;

  public TimeseriesMappingType indicatorValueProperty(String indicatorValueProperty) {
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

  public TimeseriesMappingType timestamp(LocalDate timestamp) {
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

  public TimeseriesMappingType timestampProperty(String timestampProperty) {
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
    TimeseriesMappingType timeseriesMappingType = (TimeseriesMappingType) o;
    return Objects.equals(this.indicatorValueProperty, timeseriesMappingType.indicatorValueProperty) &&
        Objects.equals(this.timestamp, timeseriesMappingType.timestamp) &&
        Objects.equals(this.timestampProperty, timeseriesMappingType.timestampProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorValueProperty, timestamp, timestampProperty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeseriesMappingType {\n");
    
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

