package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for importing an new georesource
 */
@ApiModel(description = "Definitions for importing an new georesource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-26T14:10:46.280+01:00")

public class ImportGeoresourcePOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("georesourcePostBody")
  private GeoresourcePOSTInputType georesourcePostBody = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private SpatialResourcePropertyMappingType propertyMapping = null;

  @JsonProperty("dryRun")
  private Boolean dryRun = null;

  public ImportGeoresourcePOSTInputType georesourcePostBody(GeoresourcePOSTInputType georesourcePostBody) {
    this.georesourcePostBody = georesourcePostBody;
    return this;
  }

  /**
   * Get georesourcePostBody
   * @return georesourcePostBody
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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

  public ImportGeoresourcePOSTInputType converter(ConverterDefinitionType converter) {
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

  public ImportGeoresourcePOSTInputType propertyMapping(SpatialResourcePropertyMappingType propertyMapping) {
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

  public ImportGeoresourcePOSTInputType dryRun(Boolean dryRun) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

