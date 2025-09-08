package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.n52.kommonitor.models.IndicatorPUTInputType;
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
 * Definition of an aggregation for a higher spatial unit
 */

@Schema(name = "AggregationType", description = "Definition of an aggregation for a higher spatial unit")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-08T15:57:13.274083500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class AggregationType implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Function to use for the aggregation
   */
  public enum AggregateFunctionEnum {
    COUNT("COUNT"),
    
    MEAN("MEAN"),
    
    MAX("MAX"),
    
    MIN("MIN"),
    
    SUM("SUM"),
    
    MEDIAN("MEDIAN");

    private final String value;

    AggregateFunctionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AggregateFunctionEnum fromValue(String value) {
      for (AggregateFunctionEnum b : AggregateFunctionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private AggregateFunctionEnum aggregateFunction;

  private IndicatorPUTInputType indicatorPutBody;

  private String spatialReferenceKeyProperty;

  public AggregationType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AggregationType(AggregateFunctionEnum aggregateFunction, IndicatorPUTInputType indicatorPutBody, String spatialReferenceKeyProperty) {
    this.aggregateFunction = aggregateFunction;
    this.indicatorPutBody = indicatorPutBody;
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
  }

  public AggregationType aggregateFunction(AggregateFunctionEnum aggregateFunction) {
    this.aggregateFunction = aggregateFunction;
    return this;
  }

  /**
   * Function to use for the aggregation
   * @return aggregateFunction
   */
  @NotNull 
  @Schema(name = "aggregateFunction", description = "Function to use for the aggregation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("aggregateFunction")
  public AggregateFunctionEnum getAggregateFunction() {
    return aggregateFunction;
  }

  public void setAggregateFunction(AggregateFunctionEnum aggregateFunction) {
    this.aggregateFunction = aggregateFunction;
  }

  public AggregationType indicatorPutBody(IndicatorPUTInputType indicatorPutBody) {
    this.indicatorPutBody = indicatorPutBody;
    return this;
  }

  /**
   * Get indicatorPutBody
   * @return indicatorPutBody
   */
  @NotNull @Valid 
  @Schema(name = "indicatorPutBody", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorPutBody")
  public IndicatorPUTInputType getIndicatorPutBody() {
    return indicatorPutBody;
  }

  public void setIndicatorPutBody(IndicatorPUTInputType indicatorPutBody) {
    this.indicatorPutBody = indicatorPutBody;
  }

  public AggregationType spatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
    return this;
  }

  /**
   * property that contains the identifier of the spatial feature to which the aggregated values shall be applied
   * @return spatialReferenceKeyProperty
   */
  @NotNull 
  @Schema(name = "spatialReferenceKeyProperty", description = "property that contains the identifier of the spatial feature to which the aggregated values shall be applied", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spatialReferenceKeyProperty")
  public String getSpatialReferenceKeyProperty() {
    return spatialReferenceKeyProperty;
  }

  public void setSpatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AggregationType aggregationType = (AggregationType) o;
    return Objects.equals(this.aggregateFunction, aggregationType.aggregateFunction) &&
        Objects.equals(this.indicatorPutBody, aggregationType.indicatorPutBody) &&
        Objects.equals(this.spatialReferenceKeyProperty, aggregationType.spatialReferenceKeyProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregateFunction, indicatorPutBody, spatialReferenceKeyProperty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AggregationType {\n");
    sb.append("    aggregateFunction: ").append(toIndentedString(aggregateFunction)).append("\n");
    sb.append("    indicatorPutBody: ").append(toIndentedString(indicatorPutBody)).append("\n");
    sb.append("    spatialReferenceKeyProperty: ").append(toIndentedString(spatialReferenceKeyProperty)).append("\n");
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

