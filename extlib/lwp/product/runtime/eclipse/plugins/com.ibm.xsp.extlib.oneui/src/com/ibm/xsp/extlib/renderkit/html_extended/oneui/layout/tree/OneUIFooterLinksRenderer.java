/*
 * � Copyright IBM Corp. 2010
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

package com.ibm.xsp.extlib.renderkit.html_extended.oneui.layout.tree;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ibm.xsp.extlib.renderkit.html_extended.outline.tree.HtmlListRenderer;
import com.ibm.xsp.extlib.tree.ITreeNode;


public class OneUIFooterLinksRenderer extends HtmlListRenderer {
    
    private static final long serialVersionUID = 1L;

    public OneUIFooterLinksRenderer() {
    }

    @Override
    public void renderChildren(FacesContext context, ResponseWriter writer, TreeContextImpl tree) throws IOException {
        // Get the tree node list for the outline
        if(tree.getNodeContext().hasChildren()) {
//	          int i=0;
//	          for(ITreeNode.NodeIterator it = tree.getNodeContext().iterateChildren(0,Integer.MAX_VALUE); it.hasNext(); i++ ) {
//	              ITreeNode node = it.next();
//	              tree.push(node, i, !it.hasNext());
//	              // Discussed on Oct 25th, 2011 and agreed to change into <ul>/<li> way
//	              writer.startElement("ul", null); // $NON-NLS-1$
//	              writer.writeAttribute("class","xspFooterLinks",null); // $NON-NLS-1$ $NON-NLS-2$
//	              if(tree.getNodeContext().hasChildren()) {
//	            	  writer.startElement("li", null); // $NON-NLS-1$
//		              writer.writeAttribute("class","xspFooterLinkTitle",null); // $NON-NLS-1$ $NON-NLS-2$
//	            	  writer.writeText(tree.getNode().getLabel(),null);
//		              writer.endElement("li"); // $NON-NLS-1$
//	            	  renderList(context, writer, tree);
//	              }
//	              writer.endElement("ul"); // $NON-NLS-1$
//	              tree.pop();
//	          }
            writer.startElement("table",null); // $NON-NLS-1$
            writer.writeAttribute("cellspacing","0",null); // $NON-NLS-1$
//           	writer.writeAttribute("role","presentation",null); // $NON-NLS-1$ $NON-NLS-2$
           	writer.writeAttribute("role","contentinfo",null); // $NON-NLS-1$ $NON-NLS-2$
            writer.startElement("tbody",null); // $NON-NLS-1$

            // Don't write any title, in other case table will be not accessible
//            writer.startElement("tr",null); // $NON-NLS-1$
//            int i=0;
//            for(ITreeNode.NodeIterator it = tree.getNodeContext().iterateChildren(0,Integer.MAX_VALUE); it.hasNext(); i++ ) {
//                ITreeNode node = it.next();
//                tree.push(node, i, !it.hasNext());
//                writer.startElement("th",null); // $NON-NLS-1$
//                if(!it.hasNext()) {
//                    writer.writeAttribute("class","lotusLast",null); // $NON-NLS-1$ $NON-NLS-2$
//                }
//                writer.writeText(tree.getNode().getLabel(),null);
//                writer.endElement("th"); // $NON-NLS-1$
//                tree.pop();
//            }
//            writer.endElement("tr"); // $NON-NLS-1$

            // Write the links
            writer.startElement("tr",null); // $NON-NLS-1$
            int i=0;
            for(ITreeNode.NodeIterator it = tree.getNodeContext().iterateChildren(0,Integer.MAX_VALUE); it.hasNext(); i++ ) {
                ITreeNode node = it.next();
                tree.push(node, i, !it.hasNext());
                writer.startElement("td",null); // $NON-NLS-1$
                if(!it.hasNext()) {
                    writer.writeAttribute("class","lotusLast",null); // $NON-NLS-1$ $NON-NLS-2$
                }
                if(tree.getNodeContext().hasChildren()) {
                    preRenderList(context, writer, tree);
                    renderList(context, writer, tree);
                    postRenderList(context, writer, tree);
                }
                writer.endElement("td"); // $NON-NLS-1$
                tree.pop();
            }
            writer.endElement("tr"); // $NON-NLS-1$

            writer.endElement("tbody"); // $NON-NLS-1$
            writer.endElement("table"); // $NON-NLS-1$
        }
    }
}