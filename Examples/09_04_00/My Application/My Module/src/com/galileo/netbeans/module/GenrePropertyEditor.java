package com.galileo.netbeans.module;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.openide.explorer.propertysheet.ExPropertyEditor;
import org.openide.explorer.propertysheet.InplaceEditor;
import org.openide.explorer.propertysheet.PropertyEnv;
import org.openide.explorer.propertysheet.PropertyModel;

public class GenrePropertyEditor extends PropertyEditorSupport implements ExPropertyEditor, InplaceEditor.Factory
{
   private InplaceEditor ed = null;

   public void attachEnv(PropertyEnv propertyEnv) {
      propertyEnv.registerInplaceEditorFactory(this);
   }

   public InplaceEditor getInplaceEditor() {
      if(ed == null)
         ed = new Inplace();
      return(ed);
   }
   
   private static class Inplace implements InplaceEditor
   {
      private       PropertyEditor editor = null;
      private       PropertyModel  model  = null;
      private final JComboBox      genres = new JComboBox(new String[] {"Techno", "Trance", "Rock", "Pop"});

      public void connect(PropertyEditor propertyEditor, PropertyEnv propertyEnv) {
         this.editor = propertyEditor;
         reset();
      }

      public JComponent getComponent() {
         return this.genres;
      }

      public void clear() {
         this.editor = null;
         this.model  = null;
      }

      public Object getValue() {
         return this.genres.getSelectedItem();
      }

      public void setValue(Object object) {
         this.genres.setSelectedItem(object);
      }

      public boolean supportsTextEntry() {
         return true;
      }

      public void reset() {
         String genre = (String) editor.getValue();
         if(genre != null)
            this.genres.setSelectedItem(genre);
      }

      public void addActionListener(ActionListener actionListener) {
         //not needed
      }

      public void removeActionListener(ActionListener actionListener) {
         //not needed
      }

      public KeyStroke[] getKeyStrokes() {
         return new KeyStroke[0];
      }

      public PropertyEditor getPropertyEditor() {
         return this.editor;
      }

      public PropertyModel getPropertyModel() {
         return this.model;
      }

      public void setPropertyModel(PropertyModel propertyModel) {
         this.model = propertyModel;
      }

      public boolean isKnownComponent(Component component) {
         return component == this.genres || this.genres.isAncestorOf(component);
      }
   }
}
