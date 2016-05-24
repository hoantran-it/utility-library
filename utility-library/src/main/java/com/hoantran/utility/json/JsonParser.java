/**
 * This file Copyright (c) 2016 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package com.hoantran.utility.json;

import com.google.gson.Gson;

/**
 * @author hoan.tran
 */
public class JsonParser {

    /**
     * Convert object to json.
     * 
     * @param object
     * @return
     */
    public static String converFromObjectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * Convert json to object based on given class.
     * 
     * @param objecClass
     * @param json
     * @return
     */
    public static Object converFromJsonToObject(Class<?> objecClass, String json) {
        Gson gson = new Gson();
        Object object = gson.fromJson(json, objecClass);
        return object;
    }
}
