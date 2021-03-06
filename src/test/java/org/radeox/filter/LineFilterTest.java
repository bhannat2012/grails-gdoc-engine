/*
 *      Copyright 2001-2004 Fraunhofer Gesellschaft, Munich, Germany, for its 
 *      Fraunhofer Institute Computer Architecture and Software Technology
 *      (FIRST), Berlin, Germany
 *      
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.radeox.filter;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.radeox.filter.LineFilter;

public class LineFilterTest extends FilterTestSupport {
   protected void setUp() throws Exception {
    filter = new LineFilter();
    super.setUp();
  }

  public static Test suite() {
    return new TestSuite(LineFilterTest.class);
  }

  public void test3Line() {
    assertEquals("Test---Text", filter.filter("Test---Text", context));
  }

  public void test4Line() {
    assertEquals("Test<hr class=\"line\"/>Text", filter.filter("Test----Text", context));
  }

  public void test5Line() {
    assertEquals("Test<hr class=\"line\"/>Text", filter.filter("Test-----Text", context));
  }

  public void testSimpleLine() {
    assertEquals("<hr class=\"line\"/>\n", filter.filter("-----\n", context));
  }
}
