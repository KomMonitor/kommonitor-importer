package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.importer.models.CommonMetadataType;
import org.n52.kommonitor.importer.models.ImportDataSourceType;
import org.n52.kommonitor.importer.models.PeriodOfValidityType;
import org.n52.kommonitor.importer.models.SpatialUnitPropertyMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImportSpatialUnitPOSTInputType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-19T09:41:06.276+01:00")

public class ImportSpatialUnitPOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("spatialUnitLevel")
  private String spatialUnitLevel = null;

  @JsonProperty("periodOfValidity")
  private PeriodOfValidityType periodOfValidity = null;

  @JsonProperty("metadata")
  private CommonMetadataType metadata = null;

  @JsonProperty("nextLowerHierarchyLevel")
  private String nextLowerHierarchyLevel = null;

  @JsonProperty("nextUpperHierarchyLevel")
  private String nextUpperHierarchyLevel = null;

  @JsonProperty("jsonSchema")
  private String jsonSchema = null;

  @JsonProperty("dataSource")
  private ImportDataSourceType dataSource = null;

  @JsonProperty("propertyMapping")
  private SpatialUnitPropertyMappingType propertyMapping = null;

  public ImportSpatialUnitPOSTInputType spatialUnitLevel(String spatialUnitLevel) {
    this.spatialUnitLevel = spatialUnitLevel;
    return this;
  }

  /**
   * the name and identifier of the spatial unit level the features apply to
   * @return spatialUnitLevel
  **/
  @ApiModelProperty(required = true, value = "the name and identifier of the spatial unit level the features apply to")
  @NotNull


  public String getSpatialUnitLevel() {
    return spatialUnitLevel;
  }

  public void setSpatialUnitLevel(String spatialUnitLevel) {
    this.spatialUnitLevel = spatialUnitLevel;
  }

  public ImportSpatialUnitPOSTInputType periodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
    return this;
  }

  /**
   * Get periodOfValidity
   * @return periodOfValidity
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PeriodOfValidityType getPeriodOfValidity() {
    return periodOfValidity;
  }

  public void setPeriodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
  }

  public ImportSpatialUnitPOSTInputType metadata(CommonMetadataType metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CommonMetadataType getMetadata() {
    return metadata;
  }

  public void setMetadata(CommonMetadataType metadata) {
    this.metadata = metadata;
  }

  public ImportSpatialUnitPOSTInputType nextLowerHierarchyLevel(String nextLowerHierarchyLevel) {
    this.nextLowerHierarchyLevel = nextLowerHierarchyLevel;
    return this;
  }

  /**
   * the identifier/name of the spatial unit level that contains the features of the nearest lower hierarchy level
   * @return nextLowerHierarchyLevel
  **/
  @ApiModelProperty(required = true, value = "the identifier/name of the spatial unit level that contains the features of the nearest lower hierarchy level")
  @NotNull


  public String getNextLowerHierarchyLevel() {
    return nextLowerHierarchyLevel;
  }

  public void setNextLowerHierarchyLevel(String nextLowerHierarchyLevel) {
    this.nextLowerHierarchyLevel = nextLowerHierarchyLevel;
  }

  public ImportSpatialUnitPOSTInputType nextUpperHierarchyLevel(String nextUpperHierarchyLevel) {
    this.nextUpperHierarchyLevel = nextUpperHierarchyLevel;
    return this;
  }

  /**
   * the identifier/name of the spatial unit level that contains the features of the nearest upper hierarchy level
   * @return nextUpperHierarchyLevel
  **/
  @ApiModelProperty(required = true, value = "the identifier/name of the spatial unit level that contains the features of the nearest upper hierarchy level")
  @NotNull


  public String getNextUpperHierarchyLevel() {
    return nextUpperHierarchyLevel;
  }

  public void setNextUpperHierarchyLevel(String nextUpperHierarchyLevel) {
    this.nextUpperHierarchyLevel = nextUpperHierarchyLevel;
  }

  public ImportSpatialUnitPOSTInputType jsonSchema(String jsonSchema) {
    this.jsonSchema = jsonSchema;
    return this;
  }

  /**
   * a JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property.
   * @return jsonSchema
  **/
  @ApiModelProperty(required = true, value = "a JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property.")
  @NotNull


  public String getJsonSchema() {
    return jsonSchema;
  }

  public void setJsonSchema(String jsonSchema) {
    this.jsonSchema = jsonSchema;
  }

  public ImportSpatialUnitPOSTInputType dataSource(ImportDataSourceType dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  /**
   * Contains information for retrieving Spatial Units from an underlying datasource
   * @return dataSource
  **/
  @ApiModelProperty(required = true, value = "Contains information for retrieving Spatial Units from an underlying datasource")
  @NotNull

  @Valid

  public ImportDataSourceType getDataSource() {
    return dataSource;
  }

  public void setDataSource(ImportDataSourceType dataSource) {
    this.dataSource = dataSource;
  }

  public ImportSpatialUnitPOSTInputType propertyMapping(SpatialUnitPropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
    return this;
  }

  /**
   * Definitions for mapping datasource properties to Spatial Unit properties
   * @return propertyMapping
  **/
  @ApiModelProperty(required = true, value = "Definitions for mapping datasource properties to Spatial Unit properties")
  @NotNull

  @Valid

  public SpatialUnitPropertyMappingType getPropertyMapping() {
    return propertyMapping;
  }

  public void setPropertyMapping(SpatialUnitPropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
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
    return Objects.equals(this.spatialUnitLevel, importSpatialUnitPOSTInputType.spatialUnitLevel) &&
        Objects.equals(this.periodOfValidity, importSpatialUnitPOSTInputType.periodOfValidity) &&
        Objects.equals(this.metadata, importSpatialUnitPOSTInputType.metadata) &&
        Objects.equals(this.nextLowerHierarchyLevel, importSpatialUnitPOSTInputType.nextLowerHierarchyLevel) &&
        Objects.equals(this.nextUpperHierarchyLevel, importSpatialUnitPOSTInputType.nextUpperHierarchyLevel) &&
        Objects.equals(this.jsonSchema, importSpatialUnitPOSTInputType.jsonSchema) &&
        Objects.equals(this.dataSource, importSpatialUnitPOSTInputType.dataSource) &&
        Objects.equals(this.propertyMapping, importSpatialUnitPOSTInputType.propertyMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialUnitLevel, periodOfValidity, metadata, nextLowerHierarchyLevel, nextUpperHierarchyLevel, jsonSchema, dataSource, propertyMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportSpatialUnitPOSTInputType {\n");
    
    sb.append("    spatialUnitLevel: ").append(toIndentedString(spatialUnitLevel)).append("\n");
    sb.append("    periodOfValidity: ").append(toIndentedString(periodOfValidity)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    nextLowerHierarchyLevel: ").append(toIndentedString(nextLowerHierarchyLevel)).append("\n");
    sb.append("    nextUpperHierarchyLevel: ").append(toIndentedString(nextUpperHierarchyLevel)).append("\n");
    sb.append("    jsonSchema: ").append(toIndentedString(jsonSchema)).append("\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    propertyMapping: ").append(toIndentedString(propertyMapping)).append("\n");
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

