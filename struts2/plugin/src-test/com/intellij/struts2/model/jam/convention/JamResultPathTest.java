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

package com.intellij.struts2.model.jam.convention;

import com.intellij.lang.properties.IProperty;
import com.intellij.psi.jsp.WebDirectoryElement;
import com.intellij.struts2.Struts2ProjectDescriptorBuilder;
import com.intellij.testFramework.LightProjectDescriptor;
import org.jetbrains.annotations.NotNull;

/**
 * Tests for {@link com.intellij.struts2.model.jam.convention.JamResultPath}.
 *
 * @author Yann C&eacute;bron
 */
public class JamResultPathTest extends JamConventionLightTestCase {

  private final LightProjectDescriptor CONVENTION_WEB = new Struts2ProjectDescriptorBuilder()
    .withStrutsLibrary()
    .withStrutsFacet()
    .withLibrary("struts2-convention-plugin", "struts2-convention-plugin-" + STRUTS2_VERSION + ".jar")
    .withWebModuleType(getTestDataPath());

  @NotNull
  @Override
  protected String getTestDataFolder() {
    return "resultPath";
  }

  @NotNull
  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
    return CONVENTION_WEB;
  }

  /**
   * "property" variants from struts.properties.
   */
  public void testCompletionActionProperty() throws Exception {
    myFixture.testCompletionVariants("/src/testcompletion/ActionProperty.java",
                                     "myProperty1", "myProperty2");
  }

  /**
   * "property" resolving to key in struts.properties.
   */
  public void testResolveActionProperty() throws Exception {
    final JamResultPath jamResultPath = getClassJam("jam.ActionProperty", JamResultPath.META_CLASS);
    final IProperty property = jamResultPath.getProperty().getValue();
    assertNotNull(property);
    assertEquals("myProperty1", property.getName());
  }

  /**
   * "value" resolving to web-dir.
   */
  public void testResolveActionValue() throws Exception {
    myFixture.configureByFile("/WEB-INF/customContent/test.jsp");

    final JamResultPath jamResultPath = getClassJam("jam.ActionValue", JamResultPath.META_CLASS);
    final WebDirectoryElement webDirectoryElement = jamResultPath.getValue().getValue();
    assertNotNull(webDirectoryElement);
    assertEquals("/WEB-INF/customContent", webDirectoryElement.getPath());
  }
}
