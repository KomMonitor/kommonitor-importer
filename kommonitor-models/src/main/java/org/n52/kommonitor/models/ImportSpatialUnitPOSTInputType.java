package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.models.SpatialUnitPOSTInputType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for importing an new spatial unit from a certain datasource
 */
@ApiModel(description = "Definitions for importing an new spatial unit from a certain datasource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-26T14:10:46.280+01:00")

public class ImportSpatialUnitPOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("spatialUnitPostBody")
  private SpatialUnitPOSTInputType spatialUnitPostBody = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private SpatialResourcePropertyMappingType propertyMapping = null;

  @JsonProperty("dryRun")
  private Boolean dryRun = null;

  public ImportSpatialUnitPOSTInputType spatialUnitPostBody(SpatialUnitPOSTInputType spatialUnitPostBody) {
    this.spatialUnitPostBody = spatialUnitPostBody;
    return this;
  }

  /**
   * Get spatialUnitPostBody
   * @return spatialUnitPostBody
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SpatialUnitPOSTInputType getSpatialUnitPostBody() {
    return spatialUnitPostBody;
  }

  public void setSpatialUnitPostBody(SpatialUnitPOSTInputType spatialUnitPostBody) {
    this.spatialUnitPostBody = spatialUnitPostBody;
  }

  public ImportSpatialUnitPOSTInputType dataSource(DataSourceDefinitionType dataSource) {
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

  public ImportSpatialUnitPOSTInputType converter(ConverterDefinitionType converter) {
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

  public ImportSpatialUnitPOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
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

  public ImportSpatialUnitPOSTInputType dryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

  /**
   * Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.
   * @return dryRun
  **/
  @ApiModelProperty(value = "Indicate wether to perform a dry run ('true') or not (default 'false'). If true the import will be performed without doing a POST request to the Data Management API. However, the response contains information about the entitites that would have been imported and possbile import errors.")


  public Boolean isDryRun() {
    return dryRun;
  }

  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportSpatialUnitPOSTInputType importSpatialUnitPOSTInputType = (ImportSpatialUnitPOSTInputType) o;
    return Objects.equals(this.spatialUnitPostBody, importSpatialUnitPOSTInputType.spatialUnitPostBody) &&
        Objects.equals(this.dataSource, importSpatialUnitPOSTInputType.dataSource) &&
        Objects.equals(this.converter, importSpatialUnitPOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, importSpatialUnitPOSTInputType.propertyMapping) &&
        Objects.equals(this.dryRun, importSpatialUnitPOSTInputType.dryRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialUnitPostBody, dataSource, converter, propertyMapping, dryRun);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportSpatialUnitPOSTInputType {\n");
    
    sb.append("    spatialUnitPostBody: ").append(toIndentedString(spatialUnitPostBody)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

