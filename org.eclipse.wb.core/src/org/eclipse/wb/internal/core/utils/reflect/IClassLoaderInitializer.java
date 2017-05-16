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
package org.eclipse.wb.internal.core.utils.reflect;

/**
 * Initializer for created project {@link ClassLoader}.
 *
 * @author scheglov_ke
 * @coverage core.util
 */
public interface IClassLoaderInitializer {
  /**
   * Project {@link ClassLoader} was created and should be initialized.
   */
  void initialize(ClassLoader classLoader);

  /**
   * Clear all resources association with project {@link ClassLoader}.
   */
  void deinitialize(ClassLoader classLoader);
}
