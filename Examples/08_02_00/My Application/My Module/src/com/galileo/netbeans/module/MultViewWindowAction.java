/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galileo.netbeans.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.core.spi.multiview.MultiViewDescription;
import org.netbeans.core.spi.multiview.MultiViewFactory;
import org.openide.windows.TopComponent;

public final class MultViewWindowAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      MultiViewDescription desc[] = {
         new MultiViewPanel1Description(),
         new MultiViewPanel2Description(),
         new MultiViewPanel3Description()};

      TopComponent tc = MultiViewFactory.createMultiView(desc, desc[0]);
      tc.open();
    }
}
