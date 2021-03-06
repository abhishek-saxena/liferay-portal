/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.wiki.wikipage.changeparentwikipagetowikipage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ChangeParentWikiPageToWikiPageTest extends BaseTestCase {
	public void testChangeParentWikiPageToWikiPage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//ul[@class='top-links-navigation']/li[contains(.,'All Pages')]/span/a/span",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page2 Title"),
			selenium.getText("//tr[contains(.,'Wiki Page2 Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Wiki Page2 Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki Page2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Wiki Page2 Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
		assertEquals(RuntimeVariables.replace("Details"),
			selenium.getText(
				"//div[@class='page-actions top-actions']/span[contains(.,'Details')]/a/span"));
		selenium.clickAt("//div[@class='page-actions top-actions']/span[contains(.,'Details')]/a/span",
			RuntimeVariables.replace("Details"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//ul[@class='lfr-component taglib-icon-list']/li[contains(.,'Move')]/a/span"));
		selenium.clickAt("//ul[@class='lfr-component taglib-icon-list']/li[contains(.,'Move')]/a/span",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Change Parent",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForVisible("//select[@id='_36_newParentTitle']");
		selenium.select("//select[@id='_36_newParentTitle']",
			RuntimeVariables.replace("- Wiki Page1 Title"));
		selenium.clickAt("//input[@value='Change Parent']",
			RuntimeVariables.replace("Change Parent"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//ul[@class='top-links-navigation']/li[contains(.,'All Pages')]/span/a/span",
			RuntimeVariables.replace("All Pages"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page1 Title"),
			selenium.getText("//tr[contains(.,'Wiki Page1 Title')]/td[1]/a"));
		selenium.clickAt("//tr[contains(.,'Wiki Page1 Title')]/td[1]/a",
			RuntimeVariables.replace("Wiki Page1 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page2 Title"),
			selenium.getText(
				"//div[@class='child-pages']/ul/li[contains(.,'Wiki Page2 Title')]/a"));
		selenium.clickAt("//div[@class='child-pages']/ul/li[contains(.,'Wiki Page2 Title')]/a",
			RuntimeVariables.replace("Wiki Page2 Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki Page2 Title"),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("\u00ab Back to Wiki Page1 Title"),
			selenium.getText("//span[@class='header-back-to']/a"));
		assertEquals(RuntimeVariables.replace("Wiki Page2 Content"),
			selenium.getText("//div[@class='wiki-body']/p"));
	}
}