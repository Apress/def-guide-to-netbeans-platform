package com.galileo.netbeans.module;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

public class PlaylistWizardPanel1 implements WizardDescriptor.FinishablePanel<WizardDescriptor>, PropertyChangeListener {
   
   private PlaylistVisualPanel1 view  = null;
   private WizardDescriptor     model = null;

   private boolean isValid = false;
   
   private ResourceBundle bundle = NbBundle.getBundle(PlaylistWizardPanel1.class);
   
   public PlaylistVisualPanel1 getComponent() {
      if (view == null) {
         view = new PlaylistVisualPanel1();
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, new Integer(0));
         view.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, Boolean.TRUE);
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, Boolean.TRUE);
         view.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, Boolean.TRUE);
      }

      return view;
   }

   public String getName() {
      return bundle.getString("Panel1.Name");
   }

   public HelpCtx getHelp() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   public boolean isValid() {
      return isValid;
   }
   
   private boolean checkValidity() {
      if(getComponent().getPlaylistName().trim().length() < 3) {
         setMessage(bundle.getString("Panel1.Error1"));
         return false;
      } else if(getComponent().getImagePath().length() != 0) {
         ImageIcon img = new ImageIcon(getComponent().getImagePath());
         if(img.getIconHeight() > 128 || img.getIconWidth() > 128) {
            setMessage(bundle.getString("Panel1.Error2"));
            return false;
         } 
      } else if(getComponent().getImagePath().length() == 0) {
         setMessage(bundle.getString("Panel1.Warning1"));
         return true;
      }

      setMessage(null);
      return true;
   }
   
   private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);

   public void addChangeListener(ChangeListener l) {
      synchronized(listeners) {
         listeners.add(l);
      }
   }

   public void removeChangeListener(ChangeListener l) {
      synchronized(listeners) {
         listeners.remove(l);
      }
   }

    protected final void fireChangeEvent(Object source, boolean oldState, boolean newState) {
       if(oldState != newState) {
          Iterator<ChangeListener> it;
          synchronized (listeners) {
             it = new HashSet<ChangeListener>(listeners).iterator();
          }
          ChangeEvent ev = new ChangeEvent(source);
          while (it.hasNext()) {
             it.next().stateChanged(ev);
          }
       }
    }

   public void readSettings(WizardDescriptor model) {
      this.model = model;
      getComponent().addPropertyChangeListener(this);
   }

   public void storeSettings(WizardDescriptor model) {
      model.putProperty(PlaylistVisualPanel1.PROP_PLAYLIST_NAME, getComponent().getPlaylistName());
      model.putProperty(PlaylistVisualPanel1.PROP_GENRE, getComponent().getGenre());
      model.putProperty(PlaylistVisualPanel1.PROP_DESCRIPTION, getComponent().getDescription());
      model.putProperty(PlaylistVisualPanel1.PROP_IMAGE_PATH, getComponent().getImagePath());
   }

   public void propertyChange(PropertyChangeEvent event) {
      boolean oldState = isValid;
      isValid = checkValidity();
      fireChangeEvent(this, oldState, isValid);
   }
    
   private void setMessage(String message) {
      model.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
   }

   public boolean isFinishPanel() {
      return true;
   }
}
