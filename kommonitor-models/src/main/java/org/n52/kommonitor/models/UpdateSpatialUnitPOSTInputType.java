package org.n52.kommonitor.models;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Definitions for updating an spatial unit from a certain datasource
 */
@ApiModel(description = "Definitions for updating an spatial unit from a certain datasource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-31T19:51:59.009Z")


public class UpdateSpatialUnitPOSTInputType   {
  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("dryRun")
  private Boolean dryRun = null;

  @JsonProperty("propertyMapping")
  private SpatialResourcePropertyMappingType propertyMapping = null;

  @JsonProperty("spatialUnitId")
  private String spatialUnitId = null;

  @JsonProperty("spatialUnitPutBody")
  private SpatialUnitPUTInputType spatialUnitPutBody = null;

  @JsonProperty("isPartialUpdate")
  private Boolean isPartialUpdate = false;

  public UpdateSpatialUnitPOSTInputType converter(ConverterDefinitionType converter) {
    this.converter = converter;
    return this;
  }

  /**
   * Get converter
   * @return converter
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ConverterDefinitionType getConverter() {
    return converter;
  }

  public void setConverter(ConverterDefinitionType converter) {
    this.converter = converter;
  }

  public UpdateSpatialUnitPOSTInputType dataSource(DataSourceDefinitionType dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  /**
   * Get dataSource
   * @return dataSource
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public DataSourceDefinitionType getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSourceDefinitionType dataSource) {
    this.dataSource = dataSource;
  }

  public UpdateSpatialUnitPOSTInputType dryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

  /**
   * Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.
   * @return dryRun
  **/
  @ApiModelProperty(required = true, value = "Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.")
  @NotNull


  public Boolean isDryRun() {
    return dryRun;
  }

  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }

  public UpdateSpatialUnitPOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
    return this;
  }

  /**
   * Get propertyMapping
   * @return propertyMapping
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SpatialResourcePropertyMappingType getPropertyMapping() {
    return propertyMapping;
  }

  public void setPropertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
  }

  public UpdateSpatialUnitPOSTInputType spatialUnitId(String spatialUnitId) {
    this.spatialUnitId = spatialUnitId;
    return this;
  }

  /**
   * the unique ID of the spatial unit that shall be updated
   * @return spatialUnitId
  **/
  @ApiModelProperty(required = true, value = "the unique ID of the spatial unit that shall be updated")
  @NotNull


  public String getSpatialUnitId() {
    return spatialUnitId;
  }

  public void setSpatialUnitId(String spatialUnitId) {
    this.spatialUnitId = spatialUnitId;
  }

  public UpdateSpatialUnitPOSTInputType spatialUnitPutBody(SpatialUnitPUTInputType spatialUnitPutBody) {
    this.spatialUnitPutBody = spatialUnitPutBody;
    return this;
  }

  /**
   * Get spatialUnitPutBody
   * @return spatialUnitPutBody
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SpatialUnitPUTInputType getSpatialUnitPutBody() {
    return spatialUnitPutBody;
  }

  public void setSpatialUnitPutBody(SpatialUnitPUTInputType spatialUnitPutBody) {
    this.spatialUnitPutBody = spatialUnitPutBody;
  }

  public UpdateSpatialUnitPOSTInputType isPartialUpdate(Boolean isPartialUpdate) {
    this.isPartialUpdate = isPartialUpdate;
    return this;
  }

  /**
   * if set to TRUE, then a partial upload of geometries is possible. Missing features that are already in the database will then not be deleted
   * @return isPartialUpdate
  **/
  @ApiModelProperty(value = "if set to TRUE, then a partial upload of geometries is possible. Missing features that are already in the database will then not be deleted")


  public Boolean isIsPartialUpdate() {
    return isPartialUpdate;
  }

  public void setIsPartialUpdate(Boolean isPartialUpdate) {
    this.isPartialUpdate = isPartialUpdate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSpatialUnitPOSTInputType updateSpatialUnitPOSTInputType = (UpdateSpatialUnitPOSTInputType) o;
    return Objects.equals(this.converter, updateSpatialUnitPOSTInputType.converter) &&
        Objects.equals(this.dataSource, updateSpatialUnitPOSTInputType.dataSource) &&
        Objects.equals(this.dryRun, updateSpatialUnitPOSTInputType.dryRun) &&
        Objects.equals(this.propertyMapping, updateSpatialUnitPOSTInputType.propertyMapping) &&
        Objects.equals(this.spatialUnitId, updateSpatialUnitPOSTInputType.spatialUnitId) &&
        Objects.equals(this.spatialUnitPutBody, updateSpatialUnitPOSTInputType.spatialUnitPutBody) &&
        Objects.equals(this.isPartialUpdate, updateSpatialUnitPOSTInputType.isPartialUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(converter, dataSource, dryRun, propertyMapping, spatialUnitId, spatialUnitPutBody, isPartialUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSpatialUnitPOSTInputType {\n");
    
    sb.append("    converter: ").append(toIndentedString(converter)).append("\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    dryRun: ").append(toIndentedString(dryRun)).append("\n");
    sb.append("    propertyMapping: ").append(toIndentedString(propertyMapping)).append("\n");
    sb.append("    spatialUnitId: ").append(toIndentedString(spatialUnitId)).append("\n");
    sb.append("    spatialUnitPutBody: ").append(toIndentedString(spatialUnitPutBody)).append("\n");
    sb.append("    isPartialUpdate: ").append(toIndentedString(isPartialUpdate)).append("\n");
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

