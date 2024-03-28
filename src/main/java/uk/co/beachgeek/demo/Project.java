// SPDX-License-Identifier: MIT
package uk.co.beachgeek.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model class representing a project resource retrieved from the GitHub API. 
 * 
 * This class maps the JSON response fields to Java bean properties to represent 
 * a Project object. It defines the following properties:
 *
 * name - The name of the project 
 * full_name - The full name including owner/organization 
 * id - The GitHub ID of the project
 * 
 * These properties mirror the JSON response fields from the GitHub API 
 * /repos endpoint. The getters and setters allow accessing these properties 
 * in code.
 *
 * This class is used by the ProjectsController to map the API response to a 
 * List of Project objects that can be returned from the /projects endpoint.
 */



@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

  private String name;
  private String full_name;
  private String id;


  // getters and setters
   public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}

