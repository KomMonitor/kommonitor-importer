package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for mapping datasource properties to required properties for timeseries values
 */

@Schema(name = "TimeseriesMappingType", description = "Definitions for mapping datasource properties to required properties for timeseries values")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-18T08:37:30.174370900+01:00[Europe/Berlin]")
public class TimeseriesMappingType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String indicatorValueProperty;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate timestamp;

  private String timestampProperty;

  public TimeseriesMappingType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeseriesMappingType(String indicatorValueProperty) {
    this.indicatorValueProperty = indicatorValueProperty;
  }

  public TimeseriesMappingType indicatorValueProperty(String indicatorValueProperty) {
    this.indicatorValueProperty = indicatorValueProperty;
    return this;
  }

  /**
   * property that contains the numeric value of the indicator
   * @return indicatorValueProperty
  */
  @NotNull 
  @Schema(name = "indicatorValueProperty", description = "property that contains the numeric value of the indicator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorValueProperty")
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
  */
  @Valid 
  @Schema(name = "timestamp", description = "optional timestamp value for the indicator that will be used if there is no property containing timestamp information", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
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
  */
  
  @Schema(name = "timestampProperty", description = "property that contains the timestamp (year, month and date) according to ISO 8601 (e.g. 2018-01-30)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestampProperty")
  public String getTimestampProperty() {
    return timestampProperty;
  }

  public void setTimestampProperty(String timestampProperty) {
    this.timestampProperty = timestampProperty;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

