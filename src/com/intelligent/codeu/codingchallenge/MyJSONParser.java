// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.intelligent.codeu.codingchallenge;

import java.io.IOException;
import java.util.regex.*;

final class MyJSONParser implements JSONParser {
  @Override
  public JSON parse(String in) throws IOException {
    // TODO: implement this
      
	  
	  //create the myJSON object
	MyJSON json = new MyJSON();
	  
	//Split the string into an array for easier anaylsis 
	String[] s = in.split("\"");
	
	//Loop thorugh the array
	for(int i = 0 ;i< s.length; i++){
		
		//First Condition checks if the s[i] is an object
		if(s[i].contains("{") && i != 0){
			int n = i+1;
			
			//Set the beginning of the JSON String to a "}"
			String jsonString = "{";
			
			//Perform while loop to concatenate a string to parse
			while(!s[n].contains("}")){
				
				//Don't add quotes to the ":"
				if(!s[n].contains(":")){
					
					//Don't add quotes to the ","
					if(!s[n].contains(",")){	
						
						//Concatenate the s[n] value to the string
						jsonString += "\"" + s[n] + "\"";
					}else{
						//if s[n] does contain a "," just add "," without quotes 
						jsonString += s[n];
					}
				}else{
					//if s[n] does contain a ":" just add ":" without quotes 
					jsonString += s[n];
				}
				//Increase n by 1
				n++;
			}
			
			//Set the of the JSON string to a "}"
			jsonString += "}";
			
			//Set an object in the json to the parsed JSONString
			json.setObject(s[i-1], parse(jsonString));
		}else if(i+1 < s.length && s[i+1].contains(":") && !s[i+1].contains("{")){
		    //Set a string if the conditions are met
			//Array won't go out of bounds, is before the ":" and doesn't contain a "{".
			
			//Set JSONObject string s[i] = key, s[i+2] = value
			json.setString(s[i], s[i+2]);
		}
	}
	
	
	
	//Return the new json object
    return json;
  }
}
