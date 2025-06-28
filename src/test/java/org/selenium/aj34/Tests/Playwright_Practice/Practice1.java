package org.selenium.aj34.Tests.Playwright_Practice;

import com.microsoft.playwright.options.LoadState;
import org.selenium.aj34.BaseTest_Playwright;
import org.testng.annotations.Test;

public class Practice1 extends BaseTest_Playwright {

    @Test
    public void test() throws InterruptedException {
        getPage().navigate("https://www.amazon.in/?tag=msndeskstdin-21&ref=pd_sl_3oes7cd2fz_e&adgrpid=1324913168722107&hvadid=82807336663554&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=157422&hvtargid=kwd-82808007665574:loc-90&hydadcr=5620_2377278&msclkid=353df3ab8e281207a6f195456317b764");
        getPage().locator("//input[@id=\"twotabsearchtextbox\"]").fill("perfume");
        getPage().waitForLoadState(LoadState.LOAD);
        String text = getPage().locator("//input[@id=\"twotabsearchtextbox\"]").getAttribute("aria-label");
        System.out.println(text);

        getPage().locator("").clear();

    }
}
