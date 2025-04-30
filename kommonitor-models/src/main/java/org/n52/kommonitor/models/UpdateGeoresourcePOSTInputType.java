package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.GeoresourcePUTInputType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for updating a georesource from a certain datasource
 */

@Schema(name = "Update_GeoresourcePOSTInputType", description = "Definitions for updating a georesource from a certain datasource")
@JsonTypeName("Update_GeoresourcePOSTInputType")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T07:59:21.228371+02:00[Europe/Berlin]")
public class UpdateGeoresourcePOSTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String georesourceId;

  private GeoresourcePUTInputType georesourcePutBody;

  private DataSourceDefinitionType dataSource;

  private ConverterDefinitionType converter;

  private SpatialResourcePropertyMappingType propertyMapping;

  private Boolean dryRun;

  public UpdateGeoresourcePOSTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateGeoresourcePOSTInputType(String georesourceId, GeoresourcePUTInputType georesourcePutBody, DataSourceDefinitionType dataSource, ConverterDefinitionType converter, SpatialResourcePropertyMappingType propertyMapping, Boolean dryRun) {
    this.georesourceId = georesourceId;
    this.georesourcePutBody = georesourcePutBody;
    this.dataSource = dataSource;
    this.converter = converter;
    this.propertyMapping = propertyMapping;
    this.dryRun = dryRun;
  }

  public UpdateGeoresourcePOSTInputType georesourceId(String georesourceId) {
    this.georesourceId = georesourceId;
    return this;
  }

  /**
   * the unique ID of the georesource that shall be updated
   * @return georesourceId
  */
  @NotNull 
  @Schema(name = "georesourceId", description = "the unique ID of the georesource that shall be updated", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("georesourceId")
  public String getGeoresourceId() {
    return georesourceId;
  }

  public void setGeoresourceId(String georesourceId) {
    this.georesourceId = georesourceId;
  }

  public UpdateGeoresourcePOSTInputType georesourcePutBody(GeoresourcePUTInputType georesourcePutBody) {
    this.georesourcePutBody = georesourcePutBody;
    return this;
  }

  /**
   * Get georesourcePutBody
   * @return georesourcePutBody
  */
  @NotNull @Valid 
  @Schema(name = "georesourcePutBody", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("georesourcePutBody")
  public GeoresourcePUTInputType getGeoresourcePutBody() {
    return georesourcePutBody;
  }

  public void setGeoresourcePutBody(GeoresourcePUTInputType georesourcePutBody) {
    this.georesourcePutBody = georesourcePutBody;
  }

  public UpdateGeoresourcePOSTInputType dataSource(DataSourceDefinitionType dataSource) {
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

  public UpdateGeoresourcePOSTInputType converter(ConverterDefinitionType converter) {
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

  public UpdateGeoresourcePOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
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

  public UpdateGeoresourcePOSTInputType dryRun(Boolean dryRun) {
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
    UpdateGeoresourcePOSTInputType updateGeoresourcePOSTInputType = (UpdateGeoresourcePOSTInputType) o;
    return Objects.equals(this.georesourceId, updateGeoresourcePOSTInputType.georesourceId) &&
        Objects.equals(this.georesourcePutBody, updateGeoresourcePOSTInputType.georesourcePutBody) &&
        Objects.equals(this.dataSource, updateGeoresourcePOSTInputType.dataSource) &&
        Objects.equals(this.converter, updateGeoresourcePOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, updateGeoresourcePOSTInputType.propertyMapping) &&
        Objects.equals(this.dryRun, updateGeoresourcePOSTInputType.dryRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(georesourceId, georesourcePutBody, dataSource, converter, propertyMapping, dryRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGeoresourcePOSTInputType {\n");
    sb.append("    georesourceId: ").append(toIndentedString(georesourceId)).append("\n");
    sb.append("    georesourcePutBody: ").append(toIndentedString(georesourcePutBody)).append("\n");
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

