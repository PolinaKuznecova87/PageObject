package ru.netology.page;




import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VarificationPage {
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement verifyButton = $("[data-test-id='action-verify']");

   public VarificationPage() {


       codeField.shouldBe(visible);
   }




public  DashboardPage validVerify(DataHelper.VerificationCode verificationCode){
    codeField.setValue(verificationCode.getCode());
    verifyButton.click();
    return new DashboardPage();
}
}


