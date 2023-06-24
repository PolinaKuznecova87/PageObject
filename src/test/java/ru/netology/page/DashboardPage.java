package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.impl.Html.text;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id='dashboard']");
   private final ElementsCollection cards =  $$(".list__item div");

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public  int getCardBalance(DataHelper.CardInfo cardInfo) {

        var text = cards.findBy(Condition.attribute("data-test-id", cardInfo.getTestId())).getText();

        return extractBalance(text);
    }
    public  TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo){
        cards.findBy(text(cardInfo.getCardNumber().substring(15))).$("button").click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}
