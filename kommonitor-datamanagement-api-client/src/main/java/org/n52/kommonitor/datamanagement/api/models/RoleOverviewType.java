/*
 * KomMonitor Data Access API
 * erster Entwurf einer Datenzugriffs-API, die den Zugriff auf die KomMonitor-Datenhaltungsschicht kapselt.
 *
 * OpenAPI spec version: 0.0.1
 * Contact: christian.danowski-buhren@hs-bochum.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.n52.kommonitor.datamanagement.api.models;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * RoleOverviewType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-13T15:34:17.820+01:00")
public class RoleOverviewType {
  @JsonProperty("roleId")
  private String roleId = null;

  @JsonProperty("roleName")
  private String roleName = null;

  @JsonProperty("priviledges")
  private List<String> priviledges = new ArrayList<>();

  public RoleOverviewType roleId(String roleId) {
    this.roleId = roleId;
    return this;
  }

   /**
   * the unique role identifier
   * @return roleId
  **/
  @ApiModelProperty(required = true, value = "the unique role identifier")
  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public RoleOverviewType roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

   /**
   * the role name
   * @return roleName
  **/
  @ApiModelProperty(required = true, value = "the role name")
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RoleOverviewType priviledges(List<String> priviledges) {
    this.priviledges = priviledges;
    return this;
  }

  public RoleOverviewType addPriviledgesItem(String priviledgesItem) {
    this.priviledges.add(priviledgesItem);
    return this;
  }

   /**
   * list of priviledges that are associated to this role. They indicate, what operations and data can be accessed by users.
   * @return priviledges
  **/
  @ApiModelProperty(required = true, value = "list of priviledges that are associated to this role. They indicate, what operations and data can be accessed by users.")
  public List<String> getPriviledges() {
    return priviledges;
  }

  public void setPriviledges(List<String> priviledges) {
    this.priviledges = priviledges;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleOverviewType roleOverviewType = (RoleOverviewType) o;
    return Objects.equals(this.roleId, roleOverviewType.roleId) &&
        Objects.equals(this.roleName, roleOverviewType.roleName) &&
        Objects.equals(this.priviledges, roleOverviewType.priviledges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, roleName, priviledges);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleOverviewType {\n");
    
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    priviledges: ").append(toIndentedString(priviledges)).append("\n");
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
