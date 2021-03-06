/*
 * Copyright 2013 The authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.lang.ognl.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ognl.psi.OgnlPsiCompositeElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yann C&eacute;bron
 */
abstract class OgnlPsiCompositeElementImpl extends ASTWrapperPsiElement implements OgnlPsiCompositeElement {

  protected OgnlPsiCompositeElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public String toString() {
    return getNode().getElementType().toString();
  }
}
