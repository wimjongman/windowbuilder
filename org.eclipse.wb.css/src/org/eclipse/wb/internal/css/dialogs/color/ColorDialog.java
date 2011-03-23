/*******************************************************************************
 * Copyright (c) 2011 Google, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Google, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wb.internal.css.dialogs.color;

import org.eclipse.wb.internal.core.utils.ui.dialogs.color.AbstractColorDialog;
import org.eclipse.wb.internal.core.utils.ui.dialogs.color.pages.NamedColorsComposite;
import org.eclipse.wb.internal.core.utils.ui.dialogs.color.pages.WebSafeColorsComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import org.apache.commons.lang.SystemUtils;

/**
 * Dialog for color choosing.
 * 
 * @author scheglov_ke
 * @coverage CSS.ui
 */
public final class ColorDialog extends AbstractColorDialog {
  ////////////////////////////////////////////////////////////////////////////
  //
  // Constructor
  //
  ////////////////////////////////////////////////////////////////////////////
  public ColorDialog(Shell parentShell) {
    super(parentShell);
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // Pages
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  protected void addPages(Composite parent) {
    addPage("Named colors", new NamedColorsComposite(parent, SWT.NONE, this));
    addPage("Web safe colors", new WebSafeColorsComposite(parent, SWT.NONE, this));
    if (SystemUtils.IS_OS_WINDOWS) {
      addPage("System colors", new SystemColorsComposite(parent, SWT.NONE, this));
    }
  }
}