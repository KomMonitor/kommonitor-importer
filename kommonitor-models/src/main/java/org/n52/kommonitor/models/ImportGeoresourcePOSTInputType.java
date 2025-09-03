package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
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
 * Definitions for importing an new georesource
 */

@Schema(name = "Import_GeoresourcePOSTInputType", description = "Definitions for importing an new georesource")
@JsonTypeName("Import_GeoresourcePOSTInputType")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:24:59.129000700+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ImportGeoresourcePOSTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private GeoresourcePOSTInputType georesourcePostBody;

  private DataSourceDefinitionType dataSource;

  private ConverterDefinitionType converter;

  private SpatialResourcePropertyMappingType propertyMapping;

  private Boolean dryRun;

  public ImportGeoresourcePOSTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ImportGeoresourcePOSTInputType(GeoresourcePOSTInputType georesourcePostBody, DataSourceDefinitionType dataSource, ConverterDefinitionType converter, SpatialResourcePropertyMappingType propertyMapping, Boolean dryRun) {
    this.georesourcePostBody = georesourcePostBody;
    this.dataSource = dataSource;
    this.converter = converter;
    this.propertyMapping = propertyMapping;
    this.dryRun = dryRun;
  }

  public ImportGeoresourcePOSTInputType georesourcePostBody(GeoresourcePOSTInputType georesourcePostBody) {
    this.georesourcePostBody = georesourcePostBody;
    return this;
  }

  /**
   * Get georesourcePostBody
   * @return georesourcePostBody
   */
  @NotNull @Valid 
  @Schema(name = "georesourcePostBody", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("georesourcePostBody")
  public GeoresourcePOSTInputType getGeoresourcePostBody() {
    return georesourcePostBody;
  }

  public void setGeoresourcePostBody(GeoresourcePOSTInputType georesourcePostBody) {
    this.georesourcePostBody = georesourcePostBody;
  }

  public ImportGeoresourcePOSTInputType dataSource(DataSourceDefinitionType dataSource) {
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

  public ImportGeoresourcePOSTInputType converter(ConverterDefinitionType converter) {
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

  public ImportGeoresourcePOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
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
  public SpatialResourcePropertyMappingType getPropertyMapping() {
    return propertyMapping;
  }

  public void setPropertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
  }

  public ImportGeoresourcePOSTInputType dryRun(Boolean dryRun) {
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
    ImportGeoresourcePOSTInputType importGeoresourcePOSTInputType = (ImportGeoresourcePOSTInputType) o;
    return Objects.equals(this.georesourcePostBody, importGeoresourcePOSTInputType.georesourcePostBody) &&
        Objects.equals(this.dataSource, importGeoresourcePOSTInputType.dataSource) &&
        Objects.equals(this.converter, importGeoresourcePOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, importGeoresourcePOSTInputType.propertyMapping) &&
        Objects.equals(this.dryRun, importGeoresourcePOSTInputType.dryRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(georesourcePostBody, dataSource, converter, propertyMapping, dryRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportGeoresourcePOSTInputType {\n");
    sb.append("    georesourcePostBody: ").append(toIndentedString(georesourcePostBody)).append("\n");
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

