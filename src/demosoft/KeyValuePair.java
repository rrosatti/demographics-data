/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

/**
 *
 * @author rogis
 */
public class KeyValuePair {
   private final String key;
   private final String value;
   public KeyValuePair(String key, String value) {
   this.key = key;
   this.value = value;
   }

  public String getKey()   {    return key;    }

  public String toString() {    return value;  }
}