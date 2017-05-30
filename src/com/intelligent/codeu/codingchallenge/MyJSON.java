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

import java.util.Collection;

final class MyJSON implements JSON {

  @Override
  public JSON getObject(String name) {
    if(object.containsKey(name)) {
			Object o = object.get(name);
			if(o instanceof JSON) 
        return (JSON) o;
			else if(o instanceof HashMap) 
        return new JSON((HashMap<String, Object>) o);
		}
    return null;
  }

  @Override
  public JSON setObject(String name, JSON value) {
    object.put(name, value);
    return this;
  }

  @Override
  public String getString(String name) {
    if(object.containsKey(name)) {
			return object.get(name).toString();
		}
    return null;
  }

  @Override
  public JSON setString(String name, String value) {
    object.put(name, value);
    return this;
  }

  @Override
  public void getObjects(Collection<String> names) {
    // TODO: implement this
  }

  @Override
  public void getStrings(Collection<String> names) {
    // TODO: implement this
  }
}
