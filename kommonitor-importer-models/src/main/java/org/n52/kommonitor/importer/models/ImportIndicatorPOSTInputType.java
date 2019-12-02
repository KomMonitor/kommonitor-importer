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
import org.n52.kommonitor.importer.models.DataSourceType;
import org.n52.kommonitor.importer.models.DefaultClassificationMappingType;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.ResourceReferenceType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definitions for importing an new indicator
 */
@ApiModel(description = "Definitions for importing an new indicator")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T13:04:22.865+01:00")

public class ImportIndicatorPOSTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("datasetName")
  private String datasetName = null;

  /**
   * indicates whether the indicator is a status indicator (values represent the extent of the watched phenomenon for a certain point in time) or a dynamic indicator (values represent the change of extent of the watched phenomenon within a certain period of time)
   */
  public enum IndicatorTypeEnum {
    STATUS_ABSOLUTE("STATUS_ABSOLUTE"),
    
    DYNAMIC_ABSOLUTE("DYNAMIC_ABSOLUTE"),
    
    STATUS_RELATIVE("STATUS_RELATIVE"),
    
    DYNAMIC_RELATIVE("DYNAMIC_RELATIVE"),
    
    STATUS_STANDARDIZED("STATUS_STANDARDIZED"),
    
    DYNAMIC_STANDARDIZED("DYNAMIC_STANDARDIZED");

    private String value;

    IndicatorTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IndicatorTypeEnum fromValue(String text) {
      for (IndicatorTypeEnum b : IndicatorTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("indicatorType")
  private IndicatorTypeEnum indicatorType = null;

  @JsonProperty("applicableSpatialUnit")
  private String applicableSpatialUnit = null;

  @JsonProperty("applicableTopics")
  @Valid
  private List<String> applicableTopics = new ArrayList<String>();

  @JsonProperty("metadata")
  private CommonMetadataType metadata = null;

  @JsonProperty("processDescription")
  private String processDescription = null;

  @JsonProperty("unit")
  private String unit = null;

  /**
   * indicates if the data is simply inserted (INSERTION), computed by an automated script (COMPUTATION) or automatically aggregated by a script (AGGREGATION)
   */
  public enum CreationTypeEnum {
    INSERTION("INSERTION"),
    
    COMPUTATION("COMPUTATION"),
    
    AGGREGATION("AGGREGATION");

    private String value;

    CreationTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CreationTypeEnum fromValue(String text) {
      for (CreationTypeEnum b : CreationTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("creationType")
  private CreationTypeEnum creationType = null;

  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("interpretation")
  private String interpretation = null;

  @JsonProperty("isHeadlineIndicator")
  private Boolean isHeadlineIndicator = false;

  @JsonProperty("tags")
  @Valid
  private List<String> tags = new ArrayList<String>();

  @JsonProperty("lowestSpatialUnitForComputation")
  private String lowestSpatialUnitForComputation = null;

  @JsonProperty("defaultClassificationMapping")
  private DefaultClassificationMappingType defaultClassificationMapping = null;

  @JsonProperty("allowedRoles")
  @Valid
  private List<String> allowedRoles = new ArrayList<String>();

  @JsonProperty("referencesToOtherIndicators")
  @Valid
  private List<ResourceReferenceType> referencesToOtherIndicators = null;

  @JsonProperty("referencesToGeoresources")
  @Valid
  private List<ResourceReferenceType> referencesToGeoresources = null;

  @JsonProperty("dataSource")
  private DataSourceType dataSource = null;

  @JsonProperty("converter")
  private ConverterDefinitionType converter = null;

  @JsonProperty("propertyMapping")
  private IndicatorPropertyMappingType propertyMapping = null;

  public ImportIndicatorPOSTInputType datasetName(String datasetName) {
    this.datasetName = datasetName;
    return this;
  }

  /**
   * the meaningful name of the indicator
   * @return datasetName
  **/
  @ApiModelProperty(required = true, value = "the meaningful name of the indicator")
  @NotNull


  public String getDatasetName() {
    return datasetName;
  }

  public void setDatasetName(String datasetName) {
    this.datasetName = datasetName;
  }

  public ImportIndicatorPOSTInputType indicatorType(IndicatorTypeEnum indicatorType) {
    this.indicatorType = indicatorType;
    return this;
  }

  /**
   * indicates whether the indicator is a status indicator (values represent the extent of the watched phenomenon for a certain point in time) or a dynamic indicator (values represent the change of extent of the watched phenomenon within a certain period of time)
   * @return indicatorType
  **/
  @ApiModelProperty(value = "indicates whether the indicator is a status indicator (values represent the extent of the watched phenomenon for a certain point in time) or a dynamic indicator (values represent the change of extent of the watched phenomenon within a certain period of time)")


  public IndicatorTypeEnum getIndicatorType() {
    return indicatorType;
  }

  public void setIndicatorType(IndicatorTypeEnum indicatorType) {
    this.indicatorType = indicatorType;
  }

  public ImportIndicatorPOSTInputType applicableSpatialUnit(String applicableSpatialUnit) {
    this.applicableSpatialUnit = applicableSpatialUnit;
    return this;
  }

  /**
   * identifier/name of the spatial unit level
   * @return applicableSpatialUnit
  **/
  @ApiModelProperty(required = true, value = "identifier/name of the spatial unit level")
  @NotNull


  public String getApplicableSpatialUnit() {
    return applicableSpatialUnit;
  }

  public void setApplicableSpatialUnit(String applicableSpatialUnit) {
    this.applicableSpatialUnit = applicableSpatialUnit;
  }

  public ImportIndicatorPOSTInputType applicableTopics(List<String> applicableTopics) {
    this.applicableTopics = applicableTopics;
    return this;
  }

  public ImportIndicatorPOSTInputType addApplicableTopicsItem(String applicableTopicsItem) {
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

  public ImportIndicatorPOSTInputType metadata(CommonMetadataType metadata) {
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

  public ImportIndicatorPOSTInputType processDescription(String processDescription) {
    this.processDescription = processDescription;
    return this;
  }

  /**
   * description about how the indicator was computed
   * @return processDescription
  **/
  @ApiModelProperty(required = true, value = "description about how the indicator was computed")
  @NotNull


  public String getProcessDescription() {
    return processDescription;
  }

  public void setProcessDescription(String processDescription) {
    this.processDescription = processDescription;
  }

  public ImportIndicatorPOSTInputType unit(String unit) {
    this.unit = unit;
    return this;
  }

  /**
   * unit of the indicator values
   * @return unit
  **/
  @ApiModelProperty(required = true, value = "unit of the indicator values")
  @NotNull


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public ImportIndicatorPOSTInputType creationType(CreationTypeEnum creationType) {
    this.creationType = creationType;
    return this;
  }

  /**
   * indicates if the data is simply inserted (INSERTION), computed by an automated script (COMPUTATION) or automatically aggregated by a script (AGGREGATION)
   * @return creationType
  **/
  @ApiModelProperty(required = true, value = "indicates if the data is simply inserted (INSERTION), computed by an automated script (COMPUTATION) or automatically aggregated by a script (AGGREGATION)")
  @NotNull


  public CreationTypeEnum getCreationType() {
    return creationType;
  }

  public void setCreationType(CreationTypeEnum creationType) {
    this.creationType = creationType;
  }

  public ImportIndicatorPOSTInputType abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * abbreviated mark of the indicator
   * @return abbreviation
  **/
  @ApiModelProperty(required = true, value = "abbreviated mark of the indicator")
  @NotNull


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public ImportIndicatorPOSTInputType interpretation(String interpretation) {
    this.interpretation = interpretation;
    return this;
  }

  /**
   * interpretation of the indicator values
   * @return interpretation
  **/
  @ApiModelProperty(required = true, value = "interpretation of the indicator values")
  @NotNull


  public String getInterpretation() {
    return interpretation;
  }

  public void setInterpretation(String interpretation) {
    this.interpretation = interpretation;
  }

  public ImportIndicatorPOSTInputType isHeadlineIndicator(Boolean isHeadlineIndicator) {
    this.isHeadlineIndicator = isHeadlineIndicator;
    return this;
  }

  /**
   * boolean value indicating if the indicator is a headline indicator
   * @return isHeadlineIndicator
  **/
  @ApiModelProperty(required = true, value = "boolean value indicating if the indicator is a headline indicator")
  @NotNull


  public Boolean isIsHeadlineIndicator() {
    return isHeadlineIndicator;
  }

  public void setIsHeadlineIndicator(Boolean isHeadlineIndicator) {
    this.isHeadlineIndicator = isHeadlineIndicator;
  }

  public ImportIndicatorPOSTInputType tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ImportIndicatorPOSTInputType addTagsItem(String tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * list of tag labels for the indicator
   * @return tags
  **/
  @ApiModelProperty(required = true, value = "list of tag labels for the indicator")
  @NotNull


  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public ImportIndicatorPOSTInputType lowestSpatialUnitForComputation(String lowestSpatialUnitForComputation) {
    this.lowestSpatialUnitForComputation = lowestSpatialUnitForComputation;
    return this;
  }

  /**
   * identifier/name of the lowest spatial unit for which the indicator can be computed and thus is available (only necessary for computable indicators)
   * @return lowestSpatialUnitForComputation
  **/
  @ApiModelProperty(value = "identifier/name of the lowest spatial unit for which the indicator can be computed and thus is available (only necessary for computable indicators)")


  public String getLowestSpatialUnitForComputation() {
    return lowestSpatialUnitForComputation;
  }

  public void setLowestSpatialUnitForComputation(String lowestSpatialUnitForComputation) {
    this.lowestSpatialUnitForComputation = lowestSpatialUnitForComputation;
  }

  public ImportIndicatorPOSTInputType defaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
    this.defaultClassificationMapping = defaultClassificationMapping;
    return this;
  }

  /**
   * Get defaultClassificationMapping
   * @return defaultClassificationMapping
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public DefaultClassificationMappingType getDefaultClassificationMapping() {
    return defaultClassificationMapping;
  }

  public void setDefaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
    this.defaultClassificationMapping = defaultClassificationMapping;
  }

  public ImportIndicatorPOSTInputType allowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
    return this;
  }

  public ImportIndicatorPOSTInputType addAllowedRolesItem(String allowedRolesItem) {
    this.allowedRoles.add(allowedRolesItem);
    return this;
  }

  /**
   * list of role identifiers that have read access rights for this dataset
   * @return allowedRoles
  **/
  @ApiModelProperty(required = true, value = "list of role identifiers that have read access rights for this dataset")
  @NotNull


  public List<String> getAllowedRoles() {
    return allowedRoles;
  }

  public void setAllowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
  }

  public ImportIndicatorPOSTInputType referencesToOtherIndicators(List<ResourceReferenceType> referencesToOtherIndicators) {
    this.referencesToOtherIndicators = referencesToOtherIndicators;
    return this;
  }

  public ImportIndicatorPOSTInputType addReferencesToOtherIndicatorsItem(ResourceReferenceType referencesToOtherIndicatorsItem) {
    if (this.referencesToOtherIndicators == null) {
      this.referencesToOtherIndicators = new ArrayList<ResourceReferenceType>();
    }
    this.referencesToOtherIndicators.add(referencesToOtherIndicatorsItem);
    return this;
  }

  /**
   * Array of references to other indicators. E.g., if an indicator is defined by combining four other indicators, then the identifiers of those other indicators can be referenced here.
   * @return referencesToOtherIndicators
  **/
  @ApiModelProperty(value = "Array of references to other indicators. E.g., if an indicator is defined by combining four other indicators, then the identifiers of those other indicators can be referenced here.")

  @Valid

  public List<ResourceReferenceType> getReferencesToOtherIndicators() {
    return referencesToOtherIndicators;
  }

  public void setReferencesToOtherIndicators(List<ResourceReferenceType> referencesToOtherIndicators) {
    this.referencesToOtherIndicators = referencesToOtherIndicators;
  }

  public ImportIndicatorPOSTInputType referencesToGeoresources(List<ResourceReferenceType> referencesToGeoresources) {
    this.referencesToGeoresources = referencesToGeoresources;
    return this;
  }

  public ImportIndicatorPOSTInputType addReferencesToGeoresourcesItem(ResourceReferenceType referencesToGeoresourcesItem) {
    if (this.referencesToGeoresources == null) {
      this.referencesToGeoresources = new ArrayList<ResourceReferenceType>();
    }
    this.referencesToGeoresources.add(referencesToGeoresourcesItem);
    return this;
  }

  /**
   * Array of references to other georesource datasets. E.g., if an indicator is defined by performing geometric-topological operations, then the identifiers of those required georesources can be referenced here.
   * @return referencesToGeoresources
  **/
  @ApiModelProperty(value = "Array of references to other georesource datasets. E.g., if an indicator is defined by performing geometric-topological operations, then the identifiers of those required georesources can be referenced here.")

  @Valid

  public List<ResourceReferenceType> getReferencesToGeoresources() {
    return referencesToGeoresources;
  }

  public void setReferencesToGeoresources(List<ResourceReferenceType> referencesToGeoresources) {
    this.referencesToGeoresources = referencesToGeoresources;
  }

  public ImportIndicatorPOSTInputType dataSource(DataSourceType dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  /**
   * Get dataSource
   * @return dataSource
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DataSourceType getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSourceType dataSource) {
    this.dataSource = dataSource;
  }

  public ImportIndicatorPOSTInputType converter(ConverterDefinitionType converter) {
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

  public ImportIndicatorPOSTInputType propertyMapping(IndicatorPropertyMappingType propertyMapping) {
    this.propertyMapping = propertyMapping;
    return this;
  }

  /**
   * Get propertyMapping
   * @return propertyMapping
  **/
  @ApiModelProperty(value = "")

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
    ImportIndicatorPOSTInputType importIndicatorPOSTInputType = (ImportIndicatorPOSTInputType) o;
    return Objects.equals(this.datasetName, importIndicatorPOSTInputType.datasetName) &&
        Objects.equals(this.indicatorType, importIndicatorPOSTInputType.indicatorType) &&
        Objects.equals(this.applicableSpatialUnit, importIndicatorPOSTInputType.applicableSpatialUnit) &&
        Objects.equals(this.applicableTopics, importIndicatorPOSTInputType.applicableTopics) &&
        Objects.equals(this.metadata, importIndicatorPOSTInputType.metadata) &&
        Objects.equals(this.processDescription, importIndicatorPOSTInputType.processDescription) &&
        Objects.equals(this.unit, importIndicatorPOSTInputType.unit) &&
        Objects.equals(this.creationType, importIndicatorPOSTInputType.creationType) &&
        Objects.equals(this.abbreviation, importIndicatorPOSTInputType.abbreviation) &&
        Objects.equals(this.interpretation, importIndicatorPOSTInputType.interpretation) &&
        Objects.equals(this.isHeadlineIndicator, importIndicatorPOSTInputType.isHeadlineIndicator) &&
        Objects.equals(this.tags, importIndicatorPOSTInputType.tags) &&
        Objects.equals(this.lowestSpatialUnitForComputation, importIndicatorPOSTInputType.lowestSpatialUnitForComputation) &&
        Objects.equals(this.defaultClassificationMapping, importIndicatorPOSTInputType.defaultClassificationMapping) &&
        Objects.equals(this.allowedRoles, importIndicatorPOSTInputType.allowedRoles) &&
        Objects.equals(this.referencesToOtherIndicators, importIndicatorPOSTInputType.referencesToOtherIndicators) &&
        Objects.equals(this.referencesToGeoresources, importIndicatorPOSTInputType.referencesToGeoresources) &&
        Objects.equals(this.dataSource, importIndicatorPOSTInputType.dataSource) &&
        Objects.equals(this.converter, importIndicatorPOSTInputType.converter) &&
        Objects.equals(this.propertyMapping, importIndicatorPOSTInputType.propertyMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetName, indicatorType, applicableSpatialUnit, applicableTopics, metadata, processDescription, unit, creationType, abbreviation, interpretation, isHeadlineIndicator, tags, lowestSpatialUnitForComputation, defaultClassificationMapping, allowedRoles, referencesToOtherIndicators, referencesToGeoresources, dataSource, converter, propertyMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportIndicatorPOSTInputType {\n");
    
    sb.append("    datasetName: ").append(toIndentedString(datasetName)).append("\n");
    sb.append("    indicatorType: ").append(toIndentedString(indicatorType)).append("\n");
    sb.append("    applicableSpatialUnit: ").append(toIndentedString(applicableSpatialUnit)).append("\n");
    sb.append("    applicableTopics: ").append(toIndentedString(applicableTopics)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    processDescription: ").append(toIndentedString(processDescription)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    creationType: ").append(toIndentedString(creationType)).append("\n");
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    interpretation: ").append(toIndentedString(interpretation)).append("\n");
    sb.append("    isHeadlineIndicator: ").append(toIndentedString(isHeadlineIndicator)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    lowestSpatialUnitForComputation: ").append(toIndentedString(lowestSpatialUnitForComputation)).append("\n");
    sb.append("    defaultClassificationMapping: ").append(toIndentedString(defaultClassificationMapping)).append("\n");
    sb.append("    allowedRoles: ").append(toIndentedString(allowedRoles)).append("\n");
    sb.append("    referencesToOtherIndicators: ").append(toIndentedString(referencesToOtherIndicators)).append("\n");
    sb.append("    referencesToGeoresources: ").append(toIndentedString(referencesToGeoresources)).append("\n");
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

