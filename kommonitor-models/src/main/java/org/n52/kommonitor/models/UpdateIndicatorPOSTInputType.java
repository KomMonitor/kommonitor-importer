package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.AggregationType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.IndicatorPUTInputType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
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
 * Definitions for updating a new indicator from a certain datasource
 */

@Schema(name = "Update_IndicatorPOSTInputType", description = "Definitions for updating a new indicator from a certain datasource")
@JsonTypeName("Update_IndicatorPOSTInputType")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-03T15:33:10.965342700+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class UpdateIndicatorPOSTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private @Nullable List<@Valid AggregationType> aggregations;

  private String indicatorId;

  private IndicatorPUTInputType indicatorPutBody;

  private DataSourceDefinitionType dataSource;

  private ConverterDefinitionType converter;

  private IndicatorPropertyMappingType propertyMapping;

  private Boolean dryRun;

  public UpdateIndicatorPOSTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateIndicatorPOSTInputType(String indicatorId, IndicatorPUTInputType indicatorPutBody, DataSourceDefinitionType dataSource, ConverterDefinitionType converter, IndicatorPropertyMappingType propertyMapping, Boolean dryRun) {
    this.indicatorId = indicatorId;
    this.indicatorPutBody = indicatorPutBody;
    this.dataSource = dataSource;
    this.converter = converter;
    this.propertyMapping = propertyMapping;
    this.dryRun = dryRun;
  }

  public UpdateIndicatorPOSTInputType aggregations(@Nullable List<@Valid AggregationType> aggregations) {
    this.aggregations = aggregations;
    return this;
  }

  public UpdateIndicatorPOSTInputType addAggregationsItem(AggregationType aggregationsItem) {
    if (this.aggregations == null) {
      this.aggregations = new ArrayList<>();
    }
    this.aggregations.add(aggregationsItem);
    return this;
  }

  /**
   * list of aggregations for higher spatial units
   * @return aggregations
   */
  @Valid 
  @Schema(name = "aggregations", description = "list of aggregations for higher spatial units", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("aggregations")
  public @Nullable List<@Valid AggregationType> getAggregations() {
    return aggregations;
  }

  public void setAggregations(@Nullable List<@Valid AggregationType> aggregations) {
    this.aggregations = aggregations;
  }

  public UpdateIndicatorPOSTInputType indicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
    return this;
  }

  /**
   * the unique ID of the indicator that shall be updated
   * @return indicatorId
   */
  @NotNull 
  @Schema(name = "indicatorId", description = "the unique ID of the indicator that shall be updated", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorId")
  public String getIndicatorId() {
    return indicatorId;
  }

  public void setIndicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
  }

  public UpdateIndicatorPOSTInputType indicatorPutBody(IndicatorPUTInputType indicatorPutBody) {
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

  public UpdateIndicatorPOSTInputType dataSource(DataSourceDefinitionType dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  /**
   * Get dataSource
   * @return dataSource
   */
  @NotNull @Valid 
  @Schema(name = "dataSource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dataSource")
  public DataSourceDefinitionType getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSourceDefinitionType dataSource) {
    this.dataSource = dataSource;
  }

  public UpdateIndicatorPOSTInputType converter(ConverterDefinitionType converter) {
    this.converter = converter;
    return this;
  }

  /**
   * Get converter
   * @return converter
   */
  @NotNull @Valid 
  @Schema(name = "converter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("converter")
  public ConverterDefinitionType getConverter() {
    return converter;
  }

  public void setConverter(ConverterDefinitionType converter) {
    this.converter = converter;
  }

  public UpdateIndicatorPOSTInputType propertyMapping(IndicatorPropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
    return this;
  }

  /**
   * Get propertyMapping
   * @return propertyMapping
   */
  @NotNull @Valid 
  @Schema(name = "propertyMapping", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("propertyMapping")
  public IndicatorPropertyMappingType getPropertyMapping() {
    return propertyMapping;
  }

  public void setPropertyMapping(IndicatorPropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
  }

  public UpdateIndicatorPOSTInputType dryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

  /**
   * Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.
   * @return dryRun
   */
  @NotNull 
  @Schema(name = "dryRun", description = "Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dryRun")
  public Boolean getDryRun() {
    return dryRun;
  }

  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateIndicatorPOSTInputType updateIndicatorPOSTInputType = (UpdateIndicatorPOSTInputType) o;
    return Objects.equals(this.aggregations, updateIndicatorPOSTInputType.aggregations) &&
        Objects.equals(this.indicatorId, updateIndicatorPOSTInputType.indicatorId) &&
        Objects.equals(this.indicatorPutBody, updateIndicatorPOSTInputType.indicatorPutBody) &&
        Objects.equals(this.dataSource, updateIndicatorPOSTInputType.dataSource) &&
        Objects.equals(this.converter, updateIndicatorPOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, updateIndicatorPOSTInputType.propertyMapping) &&
        Objects.equals(this.dryRun, updateIndicatorPOSTInputType.dryRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregations, indicatorId, indicatorPutBody, dataSource, converter, propertyMapping, dryRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateIndicatorPOSTInputType {\n");
    sb.append("    aggregations: ").append(toIndentedString(aggregations)).append("\n");
    sb.append("    indicatorId: ").append(toIndentedString(indicatorId)).append("\n");
    sb.append("    indicatorPutBody: ").append(toIndentedString(indicatorPutBody)).append("\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    converter: ").append(toIndentedString(converter)).append("\n");
    sb.append("    propertyMapping: ").append(toIndentedString(propertyMapping)).append("\n");
    sb.append("    dryRun: ").append(toIndentedString(dryRun)).append("\n");
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

