package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorPOSTInputTypeNumericalValueMapping
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T12:40:19.067418300+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class IndicatorPOSTInputTypeNumericalValueMapping extends IndicatorPOSTInputTypeValueMapping implements Serializable {

  private static final long serialVersionUID = 1L;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate timestamp;

  private Float indicatorValue;

  public IndicatorPOSTInputTypeNumericalValueMapping() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPOSTInputTypeNumericalValueMapping(LocalDate timestamp, Float indicatorValue) {
    this.timestamp = timestamp;
    this.indicatorValue = indicatorValue;
  }

  public IndicatorPOSTInputTypeNumericalValueMapping timestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", description = "timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public LocalDate getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  public IndicatorPOSTInputTypeNumericalValueMapping indicatorValue(Float indicatorValue) {
    this.indicatorValue = indicatorValue;
    return this;
  }

  /**
   * the numeric extent of the indicator for the timestamp
   * @return indicatorValue
   */
  @NotNull 
  @Schema(name = "indicatorValue", example = "0.0", description = "the numeric extent of the indicator for the timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorValue")
  public Float getIndicatorValue() {
    return indicatorValue;
  }

  @JsonProperty("indicatorValue")
  public void setIndicatorValue(Float indicatorValue) {
    this.indicatorValue = indicatorValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPOSTInputTypeNumericalValueMapping indicatorPOSTInputTypeNumericalValueMapping = (IndicatorPOSTInputTypeNumericalValueMapping) o;
    return Objects.equals(this.timestamp, indicatorPOSTInputTypeNumericalValueMapping.timestamp) &&
        Objects.equals(this.indicatorValue, indicatorPOSTInputTypeNumericalValueMapping.indicatorValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, indicatorValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPOSTInputTypeNumericalValueMapping {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    indicatorValue: ").append(toIndentedString(indicatorValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

