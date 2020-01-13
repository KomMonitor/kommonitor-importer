package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.GeoresourcePUTInputType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for updating a georesource from a certain datasource
 */
@ApiModel(description = "Definitions for updating a georesource from a certain datasource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T18:37:59.179+01:00")

public class UpdateGeoresourcePOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("georesourceId")
  private String georesourceId = null;

  @JsonProperty("georesourcePutBody")
  private GeoresourcePUTInputType georesourcePutBody = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private SpatialResourcePropertyMappingType propertyMapping = null;

  public UpdateGeoresourcePOSTInputType georesourceId(String georesourceId) {
    this.georesourceId = georesourceId;
    return this;
  }

  /**
   * the unique ID of the georesource that shall be updated
   * @return georesourceId
  **/
  @ApiModelProperty(required = true, value = "the unique ID of the georesource that shall be updated")
  @NotNull


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
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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

  public UpdateGeoresourcePOSTInputType converter(ConverterDefinitionType converter) {
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

  public UpdateGeoresourcePOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
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


  @Override
  public boolean equals(java.lang.Object o) {
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
        Objects.equals(this.propertyMapping, updateGeoresourcePOSTInputType.propertyMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(georesourceId, georesourcePutBody, dataSource, converter, propertyMapping);
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

