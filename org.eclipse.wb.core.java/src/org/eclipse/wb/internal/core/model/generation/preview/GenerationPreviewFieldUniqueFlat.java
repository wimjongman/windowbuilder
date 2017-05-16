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
package org.eclipse.wb.internal.core.model.generation.preview;

import org.eclipse.wb.internal.core.model.generation.GenerationPropertiesComposite;
import org.eclipse.wb.internal.core.model.generation.statement.flat.FlatStatementGenerator;
import org.eclipse.wb.internal.core.model.variable.FieldUniqueVariableSupport;
import org.eclipse.wb.internal.core.model.variable.FieldVariableSupport;

/**
 * Implementation of {@link GenerationPreview} for {@link FieldUniqueVariableSupport} and
 * {@link FlatStatementGenerator}.
 *
 * @author scheglov_ke
 * @coverage core.model.generation.ui
 */
public final class GenerationPreviewFieldUniqueFlat extends GenerationPreview {
  public static final GenerationPreview INSTANCE = new GenerationPreviewFieldUniqueFlat();

  ////////////////////////////////////////////////////////////////////////////
  //
  // Constructor
  //
  ////////////////////////////////////////////////////////////////////////////
  private GenerationPreviewFieldUniqueFlat() {
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // GenerationPreview
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  public String getPreview(GenerationPropertiesComposite variableComposite,
      GenerationPropertiesComposite statementComposite) {
    boolean v_useThis = variableComposite.getBoolean(FieldUniqueVariableSupport.P_PREFIX_THIS);
    int v_modifierIndex = variableComposite.getInteger(FieldUniqueVariableSupport.P_FIELD_MODIFIER);
    String v_modifierSource = FieldVariableSupport.V_MODIFIER_CODE[v_modifierIndex];
    boolean s_usePrefix = statementComposite.getBoolean(FlatStatementGenerator.P_USE_PREFIX);
    String s_thePrefix = statementComposite.getString(FlatStatementGenerator.P_PREFIX_TEXT);
    //
    String source = "";
    String panelRef = v_useThis ? "this.panel" : "panel";
    String buttonRef = v_useThis ? "this.button" : "button";
    // declare fields
    source += "\t" + v_modifierSource + "JPanel panel;\n";
    source += "\t" + v_modifierSource + "JButton button;\n";
    // begin
    source += "\t...\n";
    // parent
    {
      // assign field
      source += "\t" + panelRef + " = new JPanel();\n";
      // properties
      source += "\t" + panelRef + ".setBorder(new TitledBorder(\"Management\"));\n";
    }
    // child
    {
      // optional prefix
      if (s_usePrefix) {
        source += "\t" + s_thePrefix + "\n";
      }
      // assign field
      source += "\t" + buttonRef + " = new JButton();\n";
      // properties
      source += "\t" + buttonRef + ".setText(\"Add customer...\");\n";
      source += "\t" + panelRef + ".add(" + buttonRef + ");\n";
    }
    // end
    source += "\t...\n";
    // final result
    return source;
  }
}
