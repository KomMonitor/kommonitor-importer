package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.importer.models.CommonMetadataType;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.DataSourceDefinitionType;
import org.n52.kommonitor.importer.models.PeriodOfValidityType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for importing an new georesource
 */
@ApiModel(description = "Definitions for importing an new georesource")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-04T14:14:58.429+01:00")

public class ImportGeoresourcePOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("datasetName")
  private String datasetName = null;

  @JsonProperty("periodOfValidity")
  private PeriodOfValidityType periodOfValidity = null;

  @JsonProperty("metadata")
  private CommonMetadataType metadata = null;

  @JsonProperty("allowedRoles")
  @Valid
  private List<String> allowedRoles = null;

  @JsonProperty("applicableTopics")
  @Valid
  private List<String> applicableTopics = new ArrayList<String>();

  @JsonProperty("isPOI")
  private Boolean isPOI = false;

  @JsonProperty("poiSymbolBootstrap3Name")
  private String poiSymbolBootstrap3Name = null;

  /**
   * If georesource is a POI then custom POI marker color can be set by specifying one of the following color names
   */
  public enum PoiMarkerColorEnum {
    WHITE("white"),
    
    RED("red"),
    
    ORANGE("orange"),
    
    BEIGE("beige"),
    
    GREEN("green"),
    
    BLUE("blue"),
    
    PURPLE("purple"),
    
    PINK("pink"),
    
    GRAY("gray"),
    
    BLACK("black");

    private String value;

    PoiMarkerColorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PoiMarkerColorEnum fromValue(String text) {
      for (PoiMarkerColorEnum b : PoiMarkerColorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("poiMarkerColor")
  private PoiMarkerColorEnum poiMarkerColor = null;

  /**
   * If georesource is a POI then custom POI symbol color can be set by specifying one of the following color names
   */
  public enum PoiSymbolColorEnum {
    WHITE("white"),
    
    RED("red"),
    
    ORANGE("orange"),
    
    BEIGE("beige"),
    
    GREEN("green"),
    
    BLUE("blue"),
    
    PURPLE("purple"),
    
    PINK("pink"),
    
    GRAY("gray"),
    
    BLACK("black");

    private String value;

    PoiSymbolColorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PoiSymbolColorEnum fromValue(String text) {
      for (PoiSymbolColorEnum b : PoiSymbolColorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("poiSymbolColor")
  private PoiSymbolColorEnum poiSymbolColor = null;

  @JsonProperty("jsonSchema")
  private String jsonSchema = null;

  @JsonProperty("dataSource")
  private DataSourceDefinitionType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private SpatialResourcePropertyMappingType propertyMapping = null;

  public ImportGeoresourcePOSTInputType datasetName(String datasetName) {
    this.datasetName = datasetName;
    return this;
  }

  /**
   * the meaningful name of the dataset
   * @return datasetName
  **/
  @ApiModelProperty(required = true, value = "the meaningful name of the dataset")
  @NotNull


  public String getDatasetName() {
    return datasetName;
  }

  public void setDatasetName(String datasetName) {
    this.datasetName = datasetName;
  }

  public ImportGeoresourcePOSTInputType periodOfValidity(PeriodOfValidityType periodOfValidity) {
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

  public ImportGeoresourcePOSTInputType metadata(CommonMetadataType metadata) {
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

  public ImportGeoresourcePOSTInputType allowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
    return this;
  }

  public ImportGeoresourcePOSTInputType addAllowedRolesItem(String allowedRolesItem) {
    if (this.allowedRoles == null) {
      this.allowedRoles = new ArrayList<String>();
    }
    this.allowedRoles.add(allowedRolesItem);
    return this;
  }

  /**
   * list of role identifiers that have read access rights for this dataset
   * @return allowedRoles
  **/
  @ApiModelProperty(value = "list of role identifiers that have read access rights for this dataset")


  public List<String> getAllowedRoles() {
    return allowedRoles;
  }

  public void setAllowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
  }

  public ImportGeoresourcePOSTInputType applicableTopics(List<String> applicableTopics) {
    this.applicableTopics = applicableTopics;
    return this;
  }

  public ImportGeoresourcePOSTInputType addApplicableTopicsItem(String applicableTopicsItem) {
    this.applicableTopics.add(applicableTopicsItem);
    return this;
  }

  /**
   * Array of thematic categories for which the dataset is applicable. Note that the used topicName has to be defined under /topics.
   * @return applicableTopics
  **/
  @ApiModelProperty(required = true, value = "Array of thematic categories for which the dataset is applicable. Note that the used topicName has to be defined under /topics.")
  @NotNull


  public List<String> getApplicableTopics() {
    return applicableTopics;
  }

  public void setApplicableTopics(List<String> applicableTopics) {
    this.applicableTopics = applicableTopics;
  }

  public ImportGeoresourcePOSTInputType isPOI(Boolean isPOI) {
    this.isPOI = isPOI;
    return this;
  }

  /**
   * boolean value indicating if the dataset contains points of interest
   * @return isPOI
  **/
  @ApiModelProperty(value = "boolean value indicating if the dataset contains points of interest")


  public Boolean isIsPOI() {
    return isPOI;
  }

  public void setIsPOI(Boolean isPOI) {
    this.isPOI = isPOI;
  }

  public ImportGeoresourcePOSTInputType poiSymbolBootstrap3Name(String poiSymbolBootstrap3Name) {
    this.poiSymbolBootstrap3Name = poiSymbolBootstrap3Name;
    return this;
  }

  /**
   * If georesource is a POI then custom POI marker symbol can be set by specifying the name of a Bootstrap 3 glyphicon symbol (i.e. \"home\" for a home symbol or \"education\" for a students hat symbol)
   * @return poiSymbolBootstrap3Name
  **/
  @ApiModelProperty(value = "If georesource is a POI then custom POI marker symbol can be set by specifying the name of a Bootstrap 3 glyphicon symbol (i.e. \"home\" for a home symbol or \"education\" for a students hat symbol)")


  public String getPoiSymbolBootstrap3Name() {
    return poiSymbolBootstrap3Name;
  }

  public void setPoiSymbolBootstrap3Name(String poiSymbolBootstrap3Name) {
    this.poiSymbolBootstrap3Name = poiSymbolBootstrap3Name;
  }

  public ImportGeoresourcePOSTInputType poiMarkerColor(PoiMarkerColorEnum poiMarkerColor) {
    this.poiMarkerColor = poiMarkerColor;
    return this;
  }

  /**
   * If georesource is a POI then custom POI marker color can be set by specifying one of the following color names
   * @return poiMarkerColor
  **/
  @ApiModelProperty(value = "If georesource is a POI then custom POI marker color can be set by specifying one of the following color names")


  public PoiMarkerColorEnum getPoiMarkerColor() {
    return poiMarkerColor;
  }

  public void setPoiMarkerColor(PoiMarkerColorEnum poiMarkerColor) {
    this.poiMarkerColor = poiMarkerColor;
  }

  public ImportGeoresourcePOSTInputType poiSymbolColor(PoiSymbolColorEnum poiSymbolColor) {
    this.poiSymbolColor = poiSymbolColor;
    return this;
  }

  /**
   * If georesource is a POI then custom POI symbol color can be set by specifying one of the following color names
   * @return poiSymbolColor
  **/
  @ApiModelProperty(value = "If georesource is a POI then custom POI symbol color can be set by specifying one of the following color names")


  public PoiSymbolColorEnum getPoiSymbolColor() {
    return poiSymbolColor;
  }

  public void setPoiSymbolColor(PoiSymbolColorEnum poiSymbolColor) {
    this.poiSymbolColor = poiSymbolColor;
  }

  public ImportGeoresourcePOSTInputType jsonSchema(String jsonSchema) {
    this.jsonSchema = jsonSchema;
    return this;
  }

  /**
   * A JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property.
   * @return jsonSchema
  **/
  @ApiModelProperty(required = true, value = "A JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property.")
  @NotNull


  public String getJsonSchema() {
    return jsonSchema;
  }

  public void setJsonSchema(String jsonSchema) {
    this.jsonSchema = jsonSchema;
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
  @ApiModelProperty(value = "")

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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportGeoresourcePOSTInputType importGeoresourcePOSTInputType = (ImportGeoresourcePOSTInputType) o;
    return Objects.equals(this.datasetName, importGeoresourcePOSTInputType.datasetName) &&
        Objects.equals(this.periodOfValidity, importGeoresourcePOSTInputType.periodOfValidity) &&
        Objects.equals(this.metadata, importGeoresourcePOSTInputType.metadata) &&
        Objects.equals(this.allowedRoles, importGeoresourcePOSTInputType.allowedRoles) &&
        Objects.equals(this.applicableTopics, importGeoresourcePOSTInputType.applicableTopics) &&
        Objects.equals(this.isPOI, importGeoresourcePOSTInputType.isPOI) &&
        Objects.equals(this.poiSymbolBootstrap3Name, importGeoresourcePOSTInputType.poiSymbolBootstrap3Name) &&
        Objects.equals(this.poiMarkerColor, importGeoresourcePOSTInputType.poiMarkerColor) &&
        Objects.equals(this.poiSymbolColor, importGeoresourcePOSTInputType.poiSymbolColor) &&
        Objects.equals(this.jsonSchema, importGeoresourcePOSTInputType.jsonSchema) &&
        Objects.equals(this.dataSource, importGeoresourcePOSTInputType.dataSource) &&
        Objects.equals(this.converter, importGeoresourcePOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, importGeoresourcePOSTInputType.propertyMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetName, periodOfValidity, metadata, allowedRoles, applicableTopics, isPOI, poiSymbolBootstrap3Name, poiMarkerColor, poiSymbolColor, jsonSchema, dataSource, converter, propertyMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportGeoresourcePOSTInputType {\n");
    
    sb.append("    datasetName: ").append(toIndentedString(datasetName)).append("\n");
    sb.append("    periodOfValidity: ").append(toIndentedString(periodOfValidity)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    allowedRoles: ").append(toIndentedString(allowedRoles)).append("\n");
    sb.append("    applicableTopics: ").append(toIndentedString(applicableTopics)).append("\n");
    sb.append("    isPOI: ").append(toIndentedString(isPOI)).append("\n");
    sb.append("    poiSymbolBootstrap3Name: ").append(toIndentedString(poiSymbolBootstrap3Name)).append("\n");
    sb.append("    poiMarkerColor: ").append(toIndentedString(poiMarkerColor)).append("\n");
    sb.append("    poiSymbolColor: ").append(toIndentedString(poiSymbolColor)).append("\n");
    sb.append("    jsonSchema: ").append(toIndentedString(jsonSchema)).append("\n");
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

