/*
 * � Copyright IBM Corp. 2016
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
dojo.provide("extlib.dijit.Checkbox");

XSP.toggleCheckboxAria = function xe_chx(checkboxId) {
	var checkbox = dojo.byId(checkboxId);
	
	if(null != checkbox) {
		var isChecked = checkbox.getAttribute("aria-checked");
		if(isChecked == "true") {
			dojo.setAttr(checkbox, "aria-checked", "false");
		}else if(isChecked == "false"){
			dojo.setAttr(checkbox, "aria-checked", "true");
		}
	}
}

XSP.toggleHeaderCheckboxAria = function xe_hdChx(viewId, checkboxId) {
	var checkbox = dojo.byId(checkboxId);
	if (null != checkbox) {
		dojo.query('input[type=checkbox]').forEach(function(node) {
			if (XSP.startsWith(node.name,viewId) && XSP.endsWith(node.name, ':_colcbox')) {
				XSP.toggleCheckboxAria(node.id);
			}
		});
	}

	XSP.toggleCheckboxAria(checkboxId);
}