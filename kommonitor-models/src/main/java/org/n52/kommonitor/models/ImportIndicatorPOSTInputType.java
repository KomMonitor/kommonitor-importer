package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for importing an new indicator from a certain datasource
 */

@Schema(name = "Import_IndicatorPOSTInputType", description = "Definitions for importing an new indicator from a certain datasource")
@JsonTypeName("Import_IndicatorPOSTInputType")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-07T11:22:38.142409800+02:00[Europe/Berlin]")
public class ImportIndicatorPOSTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private IndicatorPOSTInputType indicatorPostBody;

  private DataSourceDefinitionType dataSource;

  private ConverterDefinitionType converter;

  private IndicatorPropertyMappingType propertyMapping;

  private Boolean dryRun;

  /**
   * Default constructor
   * @deprecated Use {@link ImportIndicatorPOSTInputType#ImportIndicatorPOSTInputType(IndicatorPOSTInputType, DataSourceDefinitionType, ConverterDefinitionType, IndicatorPropertyMappingType, Boolean)}
   */
  @Deprecated
  public ImportIndicatorPOSTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ImportIndicatorPOSTInputType(IndicatorPOSTInputType indicatorPostBody, DataSourceDefinitionType dataSource, ConverterDefinitionType converter, IndicatorPropertyMappingType propertyMapping, Boolean dryRun) {
    this.indicatorPostBody = indicatorPostBody;
    this.dataSource = dataSource;
    this.converter = converter;
    this.propertyMapping = propertyMapping;
    this.dryRun = dryRun;
  }

  public ImportIndicatorPOSTInputType indicatorPostBody(IndicatorPOSTInputType indicatorPostBody) {
    this.indicatorPostBody = indicatorPostBody;
    return this;
  }

  /**
   * Get indicatorPostBody
   * @return indicatorPostBody
  */
  @NotNull @Valid 
  @Schema(name = "indicatorPostBody", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorPostBody")
  public IndicatorPOSTInputType getIndicatorPostBody() {
    return indicatorPostBody;
  }

  public void setIndicatorPostBody(IndicatorPOSTInputType indicatorPostBody) {
    this.indicatorPostBody = indicatorPostBody;
  }

  public ImportIndicatorPOSTInputType dataSource(DataSourceDefinitionType dataSource) {
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

  public ImportIndicatorPOSTInputType converter(ConverterDefinitionType converter) {
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

  public ImportIndicatorPOSTInputType propertyMapping(IndicatorPropertyMappingType propertyMapping) {
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

  public ImportIndicatorPOSTInputType dryRun(Boolean dryRun) {
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
    ImportIndicatorPOSTInputType importIndicatorPOSTInputType = (ImportIndicatorPOSTInputType) o;
    return Objects.equals(this.indicatorPostBody, importIndicatorPOSTInputType.indicatorPostBody) &&
        Objects.equals(this.dataSource, importIndicatorPOSTInputType.dataSource) &&
        Objects.equals(this.converter, importIndicatorPOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, importIndicatorPOSTInputType.propertyMapping) &&
        Objects.equals(this.dryRun, importIndicatorPOSTInputType.dryRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorPostBody, dataSource, converter, propertyMapping, dryRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportIndicatorPOSTInputType {\n");
    sb.append("    indicatorPostBody: ").append(toIndentedString(indicatorPostBody)).append("\n");
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

