package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.DataSourceDefinitionType;
import org.n52.kommonitor.importer.models.IndicatorPUTInputType;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for updating a new indicator from a certain datasource
 */
@ApiModel(description = "Definitions for updating a new indicator from a certain datasource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T15:02:58.461+01:00")

public class UpdateIndicatorPOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("indicatorPutBody")
  private IndicatorPUTInputType indicatorPutBody = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private IndicatorPropertyMappingType propertyMapping = null;

  public UpdateIndicatorPOSTInputType indicatorPutBody(IndicatorPUTInputType indicatorPutBody) {
    this.indicatorPutBody = indicatorPutBody;
    return this;
  }

  /**
   * Get indicatorPutBody
   * @return indicatorPutBody
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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

  public UpdateIndicatorPOSTInputType converter(ConverterDefinitionType converter) {
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

  public UpdateIndicatorPOSTInputType propertyMapping(IndicatorPropertyMappingType propertyMapping) {
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

  public IndicatorPropertyMappingType getPropertyMapping() {
    return propertyMapping;
  }

  public void setPropertyMapping(IndicatorPropertyMappingType propertyMapping) {
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
    UpdateIndicatorPOSTInputType updateIndicatorPOSTInputType = (UpdateIndicatorPOSTInputType) o;
    return Objects.equals(this.indicatorPutBody, updateIndicatorPOSTInputType.indicatorPutBody) &&
        Objects.equals(this.dataSource, updateIndicatorPOSTInputType.dataSource) &&
        Objects.equals(this.converter, updateIndicatorPOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, updateIndicatorPOSTInputType.propertyMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorPutBody, dataSource, converter, propertyMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateIndicatorPOSTInputType {\n");
    
    sb.append("    indicatorPutBody: ").append(toIndentedString(indicatorPutBody)).append("\n");
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

