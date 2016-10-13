package com.galileo.netbeans.module;

import java.awt.Image;
import javax.swing.Action;
import javax.swing.Icon;
import org.openide.awt.Actions;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;

public class ExplorerLeafNode extends AbstractNode {
   
   private Action action = null;

   public ExplorerLeafNode(Action action) {
      super(Children.LEAF);
      this.action = action;
      setDisplayName(Actions.cutAmpersand((String)action.getValue(Action.NAME)));
   }
   
   @Override
   public Action getPreferredAction() {
      return action;
   }
   
   @Override
   public Image getIcon(int type) {

       Object icon = action.getValue(Action.SMALL_ICON);

       if (icon instanceof Icon) {
           return ImageUtilities.icon2Image((Icon) icon);
       }
       else if (icon instanceof Image) {
           return (Image) icon;
       }
       else {
           return null;
       }
   }
}
