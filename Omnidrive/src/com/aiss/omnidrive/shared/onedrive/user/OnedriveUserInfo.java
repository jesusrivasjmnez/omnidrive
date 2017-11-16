
package com.aiss.omnidrive.shared.onedrive.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "driveType",
    "owner",
    "quota"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class OnedriveUserInfo implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("driveType")
    private String driveType;
    @JsonProperty("owner")
    private OnedriveOwner owner;
    @JsonProperty("quota")
    private OnedriveQuota quota;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The driveType
     */
    @JsonProperty("driveType")
    public String getDriveType() {
        return driveType;
    }

    /**
     * 
     * @param driveType
     *     The driveType
     */
    @JsonProperty("driveType")
    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    /**
     * 
     * @return
     *     The owner
     */
    @JsonProperty("owner")
    public OnedriveOwner getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    @JsonProperty("owner")
    public void setOwner(OnedriveOwner owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The quota
     */
    @JsonProperty("quota")
    public OnedriveQuota getQuota() {
        return quota;
    }

    /**
     * 
     * @param quota
     *     The quota
     */
    @JsonProperty("quota")
    public void setQuota(OnedriveQuota quota) {
        this.quota = quota;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}